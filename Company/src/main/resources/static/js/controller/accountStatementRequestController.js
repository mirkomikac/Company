var accountStatementRequestController = angular.module('company.accountStatementRequestController',
		[]);

accountStatementRequestController.controller('accountStatementRequestController', function($scope,
		$location, $window, $compile, accountStatementRequestService, ngNotify, accountService, $rootScope) {
	
	$scope.action = {};
	$scope.accountStatementRequests = [];
	$scope.accountStatementRequest = {};
	$scope.mode = {};
	$scope.mode.current = "Rezim dodavanja";
	$scope.action = "addClicked"
		
	$scope.accounts = [];
	$scope.accountOptions = "account.accountNumber for account in accounts";
	$scope.selectedAccount = {};

	$scope.getAllAccountStatementRequests = function() {
		accountStatementRequestService.getAllAccountStatementRequests().then(function(data) {
			if (data.data != null) {
				$scope.accountStatementRequests = data.data;
			}
		});
	}
	
	$scope.getAllAccounts = function(){
		accountService.getAllAccounts().then(function(data) {
			if (data.data != null) {
				$scope.accounts = data.data;
			}
		});
	}
	
	$scope.getAllAccountStatementRequests();
	$scope.getAllAccounts();
	
	$scope.accountStatementRequest = {};
	$scope.selectedAccountStatementRequest = {};
	$scope.setSelected = function(accountStatementRequest) {
		if ($scope.selectedAccountStatementRequest == accountStatementRequest) {
			$scope.selectedAccountStatementRequest = {};
		} else {
			$scope.setParameters(accountStatementRequest);
		}
	}

	$scope.firstClicked = function() {
		$scope.action = "firstClicked";
		$scope.setParameters($scope.accountStatementRequests[0]);
	}
	$scope.lastClicked = function() {
		$scope.action = "lastClicked";
		$scope.setParameters($scope.accountStatementRequests[$scope.accountStatementRequests.length - 1]);
	}
	$scope.nextClicked = function() {
		$scope.action = "nextClicked";
		var n = $scope.accountStatementRequests.indexOf($scope.selectedAccountStatementRequest) + 1;
		n = n % $scope.accountStatementRequests.length;
		$scope.setParameters($scope.accountStatementRequests[n]);
	}
	$scope.prevClicked = function() {
		$scope.action = "prevClicked";
		var n = $scope.accountStatementRequests.indexOf($scope.selectedAccountStatementRequest);
		if (n == 0 || n == -1) {
			n = $scope.accountStatementRequests.length;
		}
		$scope.setParameters($scope.accountStatementRequests[n - 1]);
	}
	$scope.addClicked = function() {
		$scope.action = "addClicked";
		$scope.mode.current = "Rezim dodavanja";
	}
	$scope.searchClicked = function() {
		$scope.action = "searchClicked";
		$scope.mode.current = "Rezim pretrage";
	}

	$scope.removeClicked = function(accountStatementRequest) {
		$scope.action = "removeClicked";
		$scope.mode.current = "Rezim brisanja";
		if (Object.keys(accountStatementRequest).length > 0) {
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
					  accountStatementRequestService.deleteAccountStatementRequest(accountStatementRequest).then(function(response) {
							$scope.getAllExchangeLists();
						});
					  swal("Obrisano!", "Uspesno ste obrisali.", "success");
				  } else {
				    swal("Ponisteno", "Ponistili ste operaciju brisanja.", "error");
				  }
				});
	} else {
		swal({ title:"Selektujte zeljeni zahtev.", type:"error" });
	}
	}

	$scope.accountStatementRequest = {};
	$scope.submitAction = function(accountStatementRequest) {
		if ($scope.action == "addClicked") {
			accountStatementRequestService.addAccountStatementRequest(accountStatementRequest, $("#dateDatePicker").val(), $scope.selectedAccount.accountNumber).then(function(response) {
				$scope.getAllAccountStatementRequests();
				if (response.data != null && response.data != undefined) {
					swal({
						  title: "Pregled rezultata?",
						  text: "Da li zelite da pregledate odmah rezultat",
						  type: "success",
						  showCancelButton: true,
						  confirmButtonColor: "#DD6B55",
						  confirmButtonText: "Da, prikazi",
						  cancelButtonText: "Ponisti",
						  closeOnConfirm: true,
						  closeOnCancel: true
						},
						function(isConfirm){
						  if (isConfirm) {
							  $rootScope.$apply(function() {
								  $location.path('/accountStatementSectionResponses').search({paramRequest: response.data.id});
							        console.log($location.path());
							      });
							  
						  } 
						});
			} else {
				swal({ title:"Selektujte zeljeni zahtev.", type:"error" });
			}
			});
		} else if ($scope.action == "searchClicked") {
			accountStatementRequestService.searchAccountStatementRequests(accountStatementRequest, $("#dateDatePicker").val(), $scope.selectedAccount).then(function(response) {
				if(response.data != null){
					$scope.accountStatementRequests = response.data;
					swal("Pretraga", "Broj rezultata pretrage: " + response.data.length, "success");
				}
			});
		} 
	}

	$scope.rollbackAction = function() {
		$scope.action = "addClicked"
		$scope.mode.current = "Rezim dodavanja";
		$scope.accountStatementRequest = {};
		$scope.getAllAccountStatementRequests();
		$("#dateDatePicker").val(new Date());
	}
	
	$scope.setParameters = function(accountStatementRequest){
		$scope.selectedAccountStatementRequest = accountStatementRequest;
		$scope.accountStatementRequest = angular.copy(accountStatementRequest);
	}
	
	$scope.getDateForPicker = function(date, format){
		var check = moment(date, format);
		var month = check.format('MM');
		var day   = check.format('DD');
		var year  = check.format('YYYY');
		var today = year+"-"+(month)+"-"+(day);
		return today;
	}
	
	$scope.confirmPreviousForm = function(){
		$("#previousFormsModal").modal('hide');
		$location.path('/'+$scope.selectedModalPrevousForm);
		$scope.selectedModalPrevousForm = {};
	}
	
	$scope.previousForm = function(){
		$("#previousFormsModal").modal('show');
	}
	
	
	$scope.showAccounts = function(){
		$("#accountsModal").modal('show');
	}
	
	$scope.selectedModalAccount = {};
	$scope.setModalSelectedAccount = function(account){
		$scope.selectedModalAccount = account;
	}
	
	$scope.confirmAccount = function(){
		$scope.selectedAccount = $scope.selectedModalAccount;
		$("#accountsModal").modal('hide');
		$scope.selectedModalAccount = {};
	}
	
	$scope.previousForm = function(){
		$location.path('/accounts');
	}
	
	$scope.chain = function(){
		  $location.path('/accountStatementSectionResponses').search({paramRequest: $scope.selectedAccountStatementRequest.id});
	}
});