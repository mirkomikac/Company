var statementRequestController = angular.module('company.statementRequestController',
		[]);

statementRequestController.controller('statementRequestController', function($scope,
		$location, $window, $compile, $routeParams, statementRequestService, ngNotify) {
	
	$scope.action = {};
	$scope.statementRequests = [];
	$scope.statementRequest= {};
	
	$scope.mode = {};
	$scope.mode.current = "Rezim dodavanja";
	$scope.action = "addClicked";
	$scope.selectedModalAccount = {};
	
	$scope.getAllStatementRequests = function() {
		statementRequestService.getAllStatementRequests().then(function(data) {
			if($routeParams.param > 0){
			} 
			else{
				if (data.data != null) {
					$scope.statementRequests = data.data;
				}
			}
		});
	}
	
	$scope.getAllStatementRequests();

	$scope.statementRequest = {};
	$scope.selectedStatementRequest = {};
	$scope.setSelected = function(statementRequest) {
		
		if ($scope.selectedStatementRequest == statementRequest) {
			$scope.LegalPersonAccount = {};
		} else {
			$scope.setParameters(statementRequest);
		}
	}

	$scope.firstClicked = function() {
		$scope.action = "firstClicked";
		$scope.setParameters($scope.statementRequests[0]);
	}
	$scope.lastClicked = function() {
		$scope.action = "lastClicked";
		$scope.setParameters($scope.statementRequests[$scope.statementRequests.length - 1]);
	}
	$scope.nextClicked = function() {
		$scope.action = "nextClicked";
		var n = $scope.statementRequests.indexOf($scope.selectedStatementRequest) + 1;
		n = n % $scope.statementRequests.length;
		$scope.setParameters($scope.statementRequests[n]);
	}
	$scope.prevClicked = function() {
		$scope.action = "prevClicked";
		var n = $scope.statementRequests.indexOf($scope.selectedStatementRequest);
		if (n == 0 || n == -1) {
			n = $scope.statementRequests.length;
		}
		$scope.setParameters($scope.statementRequests[n - 1]);
	}
	$scope.addClicked = function() {
		$scope.action = "addClicked";
		$scope.mode.current = "Rezim dodavanja";
	}
	$scope.searchClicked = function() {
		$scope.action = "searchClicked";
		$scope.mode.current = "Rezim pretrage";
	}

	$scope.removeClicked = function(statementRequest) {
		swal({
			title : "Are you sure?",
			text : "You will not be able to recover this!",
			type : "warning",
			showCancelButton : true,
			confirmButtonColor : "#DD6B55",
			confirmButtonText : "Yes, delete it!",
			cancelButtonText : "Cancel!",
			closeOnConfirm : false,
			closeOnCancel : false
		}, function(isConfirm) {
			if (isConfirm) {
				statementRequestService.deleteAccount($scope.selectedStatementRequest).then(
						function(response) {
							if (response.data.id == $scope.selectedStatementRequest.id) {
								var index = $scope.banks
										.indexOf($scope.selectedBank);
								$scope.banks.splice(index, 1);
								swal("Deleted!", "Your data has been deleted.",
										"success");
							} else {
								swal("Error!", "This bank has statementRequests.",
										"error");
							}
						});
			} else {
				swal("Cancelled", "Your have canceled delete operation.",
						"error");
			}});
	}

	$scope.statementRequest = {};
	$scope.submitAction = function(statementRequest) {
		if ($scope.action == "addClicked") {
			statementRequestService.addAccount(statementRequest, $scope.selectedBank.id).then(function(response) {
				$scope.getAllStatementRequests();
			});
		} else if ($scope.action == "searchClicked") {
			statementRequestService.searchLegalPersonAccounts(statementRequest, $scope.selectedStatus, $scope.selectedBank, $scope.selectedClient, $scope.selectedCurrency, $("#openingDateDatePicker").val()).then(function(response) {
				$scope.statementRequests = response.data;
			});
		} 
	}

	$scope.rollbackAction = function() {
		$scope.action = "editBank"
		$scope.mode.current = "Rezim izmene";
		$scope.statementRequest= {};
		$scope.selectedStatementRequest= {};
		$scope.getAllStatementRequests();
	}
	
	$scope.showAccounts = function(account){
		$("#accountModal").modal('show');
		$scope.setModalSelectedAccount(account);
	}
	
	$scope.setModalSelectedAccount = function(account){
		$scope.selectedModalAccount = account;
	}
	
	$scope.confirmAccount = function(){
		$scope.selectedAccount = $scope.selectedModalAccount;
		$("#accountModal").modal('hide');
		$scope.selectedModalAccount = {};
	}
	
	
	$scope.selectedStatus = {};
	
	$scope.setParameters = function(statementRequest){
		$scope.selectedStatementRequest = statementRequest;
		$scope.statementRequest = angular.copy(statementRequest);
		
	}
 	
	
	$scope.confirmDelete = function(){
		if($scope.transferAccount != null && $scope.transferAccount != ""){
			if (Object.keys($scope.selectedStatementRequest).length > 0) {
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
						  statementRequestService.deleteLegalPersonAccount($scope.selectedStatementRequest).then(function(response) {
								$scope.getAllStatementRequests();
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
	
	$scope.previousForm = function(){
		$location.path('/accounts');
	}
	
});