var invoiceController = angular.module('company.invoiceController', []);

invoiceController.controller('invoiceController', function($rootScope, $scope,
		$location, $http, invoiceService, $routeParams, $window, accountService) {
	
	$scope.invoices = {};
	$scope.mode = {};
	$scope.mode.current = "Rezim pregleda";
	$scope.accountNumbers = {};
	
	function refreshView(){
		invoiceService.getAllInvoices().then(function(response){
			if(response.data != null)
				$scope.invoices = response.data;
		});
		accountService.getAllAccounts().then(function(response){
			if(response.data != null){
				$scope.accountNumbers = response.data;
			}
		});
	}
	refreshView();
	
	findAccountForSelect = function(id){
		for(var i = 0; i < $scope.accountNumbers.length; i++){
			if($scope.accountNumbers[i].id === id){
				return $scope.accountNumbers[i];
			}
		}
	}

	
	syncClick = function(invoice){
		$scope.selectedInvoice = invoice;
		$scope.invoice.id = invoice.id;
		$scope.invoice.messageId = invoice.messageId;
		//$scope.invoice.supplier = findCountryForSelect(currency.country.id);
		//$scope.invoice.purchaser = findCountryForSelect(currency.country.id);
		$scope.invoice.billingNumber = invoice.billingNumber;
		$scope.invoice.billingDate = invoice.billingDate;
		$scope.invoice.merchandiseValue = invoice.merchandiseValue;
		$scope.invoice.serviceValue = invoice.serviceValue;
		$scope.invoice.merchandiseAndServiceValue = invoice.merchandiseAndServiceValue;
		$scope.invoice.discount = invoice.discount;
		$scope.invoice.taxes  = invoice.taxes;
		$scope.invoice.amountForPayment = invoice.amountForPayment;
		$scope.invoice.accountNumber = findAccountForSelect(invoice.accountNumber.id);
		$scope.invoice.currency = invoice.currency;
		$scope.invoice.currencyDate = invoice.currencyDate;
	}
	
	$scope.invoice = {};
	$scope.selectedInvoice = {};
	$scope.setSelected = function(invoice){
		if($scope.selectedInvoice==invoice){
			$scope.selectedInvoice = {};
		} else {
			syncClick(invoice);
		}
	}
	
	
});