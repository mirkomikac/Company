var accountController = angular.module('company.accountController',
		[]);

accountController.controller('accountController', function($scope,
		$location, $window, $compile, $routeParams,accountService, ngNotify) {
	
	$scope.action = {};
	$scope.accounts = [];
	$scope.account= {};
	$scope.banks = [];
	$scope.bankOptions = "bank.name for bank in banks";
	$scope.selectedBank = {};
	
	$scope.mode = {};
	$scope.mode.current = "Rezim izmene";
	
	$scope.references = ['Banks', 'Clients', ''];

	$scope.getAllAccounts = function() {
		accountService.getAllAccounts().then(function(data) {
			if($routeParams.param > 0){
				var temp = [];
				for(var i = 0; i<data.data.length; i++){
					if(data.data[i].currency.id === $routeParams.param > 0){
						temp.push(data.data[i]);
					}
				}
				$scope.accounts = temp;
				$('#selectFieldCurrency').prop('disabled', 'disabled');
				$scope.selectedCurrency = $scope.currencies[$routeParams.param - 1];
			} 
			else{
				if (data.data != null) {
					$scope.accounts = data.data;
					for(var i = 0;i < $scope.accounts.length;i++){
						if($scope.accounts[i].active == true){
							$scope.accounts[i].activeView = "AKTIVAN";
						} else {
							$scope.accounts[i].activeView = "NEAKTIVAN";
						}
					}
				}
				$('#selectFieldCurrency').removeAttr('disabled');
			}
		});
	}
	
	$scope.getAllBanks = function() {
		accountService.getAllBanks().then(function(data) {
			if (data.data != null) {
				$scope.banks = data.data;
			}
		});
	}
	
	
	$scope.getAllAccounts();
	$scope.getAllBanks();

	$scope.account = {};
	$scope.selectedAccount = {};
	$scope.setSelected = function(account) {
		
		if ($scope.selectedAccount == account) {
			$scope.LegalPersonAccount = {};
		} else {
			$scope.setParameters(account);
		}
	}

	$scope.firstClicked = function() {
		$scope.action = "firstClicked";
		$scope.setParameters($scope.accounts[0]);
	}
	$scope.lastClicked = function() {
		$scope.action = "lastClicked";
		$scope.setParameters($scope.accounts[$scope.accounts.length - 1]);
	}
	$scope.nextClicked = function() {
		$scope.action = "nextClicked";
		var n = $scope.accounts.indexOf($scope.selectedAccount) + 1;
		n = n % $scope.accounts.length;
		$scope.setParameters($scope.accounts[n]);
	}
	$scope.prevClicked = function() {
		$scope.action = "prevClicked";
		var n = $scope.accounts.indexOf($scope.selectedAccount);
		if (n == 0 || n == -1) {
			n = $scope.accounts.length;
		}
		$scope.setParameters($scope.accounts[n - 1]);
	}
	$scope.addClicked = function() {
		$scope.action = "addClicked";
		$scope.mode.current = "Rezim dodavanja";
	}
	$scope.searchClicked = function() {
		$scope.action = "searchClicked";
		$scope.mode.current = "Rezim pretrage";
	}

	$scope.removeClicked = function(account) {
		if (Object.keys($scope.selectedAccount).length > 0){
			$scope.action = "removeClicked";
			$scope.mode.current = "Rezim brisanja";
			$("#deleteModal").modal('show');
		} else {
			swal("Izvrsite selekciju", "Selektujte racun!", "error");
		}
	}

	$scope.account = {};
	$scope.submitAction = function(account) {
		if ($scope.action == "addClicked") {
			accountService.addLegalPersonAccount(account, $("#openingDateDatePicker").val(), $scope.selectedBank.id, $scope.selectedClient.id, $scope.selectedCurrency.id).then(function(response) {
				$scope.getAllAccounts();
			});
		} else if ($scope.action == "searchClicked") {
			accountService.searchLegalPersonAccounts(account, $scope.selectedStatus, $scope.selectedBank, $scope.selectedClient, $scope.selectedCurrency, $("#openingDateDatePicker").val()).then(function(response) {
				$scope.accounts = response.data;
				for(var i = 0;i < $scope.accounts.length;i++){
					if($scope.accounts[i].active == true){
						$scope.accounts[i].activeView = "AKTIVAN";
					} else {
						$scope.accounts[i].activeView = "NEAKTIVAN";
					}
				}
			});
		} else {
			if (Object.keys($scope.selectedAccount).length > 0) {
				accountService.editLegalPersonAccount(account,$scope.selectedStatus, $("#openingDateDatePicker").val(), $scope.selectedBank.id, $scope.selectedClient.id, $scope.selectedCurrency.id).then(
						function(response) {
							$scope.getAllAccounts();
				});
			} else {
				swal("Izvrsite selekciju", "Selektujte racun!", "error");
			}
		}
	}

	$scope.rollbackAction = function() {
		$scope.action = "editBank"
		$scope.mode.current = "Rezim izmene";
		$scope.account= {};
		$scope.selectedAccount= {};
		$scope.selectedBank = {};
		$scope.selectedCurrency = {};
		$scope.selectedClient = {};
		$scope.getAllAccounts();
		$("#openingDateDatePicker").val(new Date());
	}
	
	
	$scope.showBanks = function(bank){
		$("#bankModal").modal('show');
		$scope.setModalSelectedBank(bank);
	}
	
	$scope.setModalSelectedBank = function(bank){
		$scope.selectedModalBank = bank;
	}
	
	
	$scope.selectedStatus = {};
	
	$scope.setParameters = function(account){
		$scope.selectedAccount = account;
		$scope.account = angular.copy(account);
		
		if(account.active == true){
			$scope.selectedStatus = "Aktivan";
		} else {
			$scope.selectedStatus = "Neaktivan";
		}
		
		for(i=0;i<$scope.banks.length;i++){
			if($scope.banks[i].id == account.bank.id){
				$scope.selectedBank = $scope.banks[i];
				break;  
			}
		}
	}
 	
	
	$scope.confirmBank = function(){
		$scope.selectedBank = $scope.selectedModalBank;
		$("#bankModal").modal('hide');
		$scope.selectedModalBank = {};
	}
	
	
	$scope.confirmDelete = function(){
		if($scope.transferAccount != null && $scope.transferAccount != ""){
			if (Object.keys($scope.selectedAccount).length > 0) {
				swal({
					  title: "Da li ste sigurni?",
					  text: "Necete uspeti da vratite ovo.",
					  type: "warning",
					  showCancelButton: true,
					  confirmButtonColor: "#DD6B55",
					  confirmButtonText: "Da, obrisi.",
					  cancelButtonText: "Ponisti",
					  closeOnConfirm: false,
					  closeOnCancel: false
					},
					function(isConfirm){
					  if (isConfirm) {
						  accountService.deleteLegalPersonAccount($scope.selectedAccount).then(function(response) {
								$scope.getAllAccounts();
								$("#deleteModal").modal('hide');
							});
						  swal("Obrisano!", "Uspesno ste obrisali.", "success");
					  } else {
					    swal("Ponisteno", "Ponistili ste operaciju brisanja.", "error");
					  }
					});
			} else {
				swal({ title:"Selektujte zeljeni nalog.", type:"error" });
			}
		} else {
			swal({ title:"Unesite racun za transfer!.", type:"error" });
		} 
	}
	
	$scope.chain = function(selectedAccount){
		if(Object.keys($scope.selectedAccount).length > 0){
				$location.path('/dailyAccountStatuses/').search({paramAccount: $scope.selectedAccount.id});
		} else {
			swal({ title:"Selektujte racun!", type:"error" });
		}
	}
	
});