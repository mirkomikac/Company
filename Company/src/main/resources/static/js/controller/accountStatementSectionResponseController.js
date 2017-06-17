var accountStatementSectionResponseController = angular.module('company.accountStatementSectionResponseController',
		[]);

accountStatementSectionResponseController.controller('accountStatementSectionResponseController', function($scope,
		$location, $window, $compile, $routeParams,accountStatementSectionResponseService, ngNotify) {
	
	$scope.action = {};
	$scope.accountStatementSectionResponses= [];
	$scope.accountStatementSectionItems=[];
	
	$scope.mode = {};
	

	$scope.getAllAccountStatementSectionResponses = function() {
		accountStatementSectionResponseService.getAllAccountStatementSectionResponses().then(function(data) {
			if($routeParams.param > 0){
			} 
			else{
				if (data.data != null) {
					$scope.accountStatementSectionResponses = data.data;
				}
			}
		});
	}
	
	$scope.getAllAccountStatementSectionResponses();
	
	$scope.accountStatementSectionResopnse = {};
	$scope.selectedAccountStatementSectionResponse = {};
	
	$scope.setSelected = function(accountStatementSectionResponse) {
		if ($scope.selectedAccountStatementSectionResponse == accountStatementSectionResponse) {
			$scope.accountStatementSectionResponse = {};
		} else {
			$scope.setParameters(accountStatementSectionResponse);
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
		var n = $scope.accounts.indexOf($scope.selectedAccountStatementSectionResponse) + 1;
		n = n % $scope.accounts.length;
		$scope.setParameters($scope.accounts[n]);
	}
	$scope.prevClicked = function() {
		$scope.action = "prevClicked";
		var n = $scope.accounts.indexOf($scope.selectedAccountStatementSectionResponse);
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
		if (Object.keys($scope.selectedAccountStatementSectionResponse).length > 0){
			$scope.action = "removeClicked";
			$scope.mode.current = "Rezim brisanja";
			$("#deleteModal").modal('show');
		} else {
			swal("Izvrsite selekciju", "Selektujte racun!", "error");
		}
	}

	$scope.account = {};
	$scope.submitAction = function(account) {
		/*
		accountStatementSectionResponseService.searchLegalPersonAccounts(account, $scope.selectedStatus, $scope.selectedBank, $scope.selectedClient, $scope.selectedCurrency, $("#openingDateDatePicker").val()).then(function(response) {
			$scope.accounts = response.data;
			for(var i = 0;i < $scope.accounts.length;i++){
				if($scope.accounts[i].active == true){
					$scope.accounts[i].activeView = "AKTIVAN";
				} else {
					$scope.accounts[i].activeView = "NEAKTIVAN";
				}
			}
		});*/
	}

	$scope.rollbackAction = function() {
		$scope.action = "editBank"
		$scope.mode.current = "Rezim izmene";
		$scope.account= {};
		$scope.selectedAccountStatementSectionResponse= {};
		$scope.getAllAccountStatementResponses();
	}
	
	
	$scope.selectedStatus = {};
	
	$scope.setParameters = function(account){
		$scope.selectedAccountStatementSectionResponse = account;
		$scope.account = angular.copy(account);
		
	}
	
	
	$scope.showItems = function(selectedAccountStatementSectionResponse){
		accountStatementSectionResponseService.getAccountStatementSectionItems(selectedAccountStatementSectionResponse.id).then(function(data){
			if(data.data != null){
				$scope.accountStatementSectionItems = data.data;
			}
		});
		$("#itemModal").modal("show");
	}
	
	$scope.confirmDelete = function(){
		if($scope.transferAccount != null && $scope.transferAccount != ""){
			if (Object.keys($scope.selectedAccountStatementSectionResponse).length > 0) {
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
						  accountStatementSectionResponseService.deleteAccountStatementSectionResponse($scope.selectedAccountStatementSectionResponse).then(function(response) {
								$scope.getAllAccounts();
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
	
	$scope.chain = function(selectedAccountStatementSectionResponse){
		if(Object.keys($scope.selectedAccountStatementSectionResponse).length > 0){
				$location.path('/accountStatementSectionItems/').search({paramAccount: $scope.selectedAccountStatementSectionResponse.id});
		} else {
			swal({ title:"Selektujte racun!", type:"error" });
		}
	}
	
});