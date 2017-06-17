var bankController = angular.module('company.bankController', []);

bankController.controller('bankController', function($rootScope, $scope,
		$location, $http, bankService, $routeParams, $window, ngNotify) {

	$scope.action = {};
	$scope.banks = [];
	$scope.bank = {};
	$scope.selectedbank = {};
	$scope.mode = {};
	$scope.mode.current = "Rezim izmene";

	$scope.getAllBanks = function() {
		bankService.getAllBanks().then(function(response) {
			if (response.data != null) {
				$scope.banks = response.data;
				$('selectField').removeAttr('disabled');
			}
		});
	}

	$scope.getAllBanks();

	$scope.setSelected = function(bank) {
		if ($scope.selectedbank == bank) {
			$scope.selectedbank = {};
		} else {
			$scope.setParameters(bank);
		}
	}

	$scope.firstClicked = function() {
		$scope.action = "firstClicked";
		$scope.setParameters($scope.banks[0]);
	}

	$scope.lastClicked = function() {
		$scope.action = "lastClicked";
		$scope.setParameters($scope.banks[$scope.banks.length - 1]);
	}

	$scope.nextClicked = function() {
		$scope.action = "nextClicked";
		var n = $scope.banks.indexOf($scope.selectedBank) + 1;
		n = n % $scope.banks.length;
		$scope.setParameters($scope.banks[n]);
	}

	$scope.prevClicked = function() {
		$scope.action = "prevClicked";
		var n = $scope.banks.indexOf($scope.selectedBank);
		if (n == 0 || n == -1) {
			n = $scope.banks.length;
		}
		$scope.setParameters($scope.banks[n - 1]);
	}

	$scope.addClicked = function() {
		$scope.action = "addClicked";
		$scope.mode.current = "Rezim dodavanja";
		$scope.bank = {};
		$scope.selectedBank = {};
		$scope.selectedCountry = {};
	}

	$scope.searchClicked = function() {
		$scope.action = "searchClicked";
		$scope.mode.current = "Rezim pretrage";
	}

	$scope.removeClicked = function() {
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
				bankService.deleteBank($scope.selectedBank.id).then(
						function(response) {
							if (response.data.id == $scope.selectedBank.id) {
								var index = $scope.banks
										.indexOf($scope.selectedBank);
								$scope.banks.splice(index, 1);
								swal("Deleted!", "Your data has been deleted.",
										"success");
							} else {
								swal("Error!", "This bank has accounts.",
										"error");
							}
						});
			} else {
				swal("Cancelled", "Your have canceled delete operation.",
						"error");
			}
		});
	}

	$scope.submitAction = function(bank) {
		if ($scope.action == "addClicked") {
			bankService.createBank(bank, $scope.selectedCountry.id).then(
					function(response) {
						$scope.banks.push(response.data);
						$scope.selectedBank = response.data;
						$scope.bank = response.data;
					});
		} else if ($scope.action == "searchClicked") {
			bankService.searchBanks(bank, $scope.selectedCountry.id).then(
					function(response) {
						$scope.banks = response.data;
					});
		} else {
			if (Object.keys($scope.banks).length > 0) {
				bankService.updateBank(bank, $scope.selectedCountry.id).then(
						function(response) {
							var index = $scope.banks
									.indexOf($scope.selectedBank);
							$scope.banks.splice(index, 1);
							$scope.banks.splice(index, 0, response.data);
							$scope.bank = {};
							$scope.selectedBank = {};

						});
			}
		}
	}

	$scope.rollbackAction = function() {
		$scope.action = "editClicked"
		$scope.mode.current = "Rezim izmene";
		$scope.bank = {};
		$scope.getAllBanks();
	}

	$scope.setParameters = function(bank) {
		$scope.selectedBank = bank;
		$scope.bank = angular.copy(bank);
		for (i = 0; i < $scope.countries.length; i++) {
			if ($scope.countries[i].id == bank.country.id) {
				$scope.selectedCountry = $scope.countries[i];
				break;
			}
		}
	}

	$scope.nextForm = function() {

	}

});