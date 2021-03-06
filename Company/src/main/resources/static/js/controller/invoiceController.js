var invoiceController = angular.module('company.invoiceController', []);

invoiceController.controller('invoiceController', function($rootScope, $scope,
		$location, $http, invoiceService, $routeParams, $window, accountService) {
	
	$scope.invoices = {};
	$scope.mode = {};
	$scope.mode.current = "Rezim pregleda";
	$scope.accountNumbers = {};
	
	$scope.suppliers = {};
	$scope.purchasers = {};
	
	function refreshView(){
		invoiceService.getAllInvoices().then(function(response){
			if(response.data != null){
				$scope.invoices = response.data;
				for(var i = 0;i < $scope.invoices.length;i++){
					$scope.invoices[i].billingDate = new Date($scope.invoices[i].billingDate);
					$scope.invoices[i].currencyDate = new Date($scope.invoices[i].currencyDate);
				}
			}
		});
		invoiceService.getAllCompanies().then(function(response){
			if(response.data != null){
				$scope.suppliers = response.data;
				$scope.purchasers = response.data;
			}
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
	
	findCompanyForSelect = function(id){
		for(var i = 0; i < $scope.suppliers.length; i++){
			if($scope.suppliers[i].id = id){
				return $scope.suppliers[i];
			}
		}
	}

	$scope.invoiceItemsInvoice = [];
	
	syncClick = function(invoice){
		$scope.selectedInvoice = invoice;
		$scope.invoice.messageId = invoice.messageId;
		$scope.invoice.billingNumber = invoice.billingNumber;
		$scope.invoice.billingDate = invoice.billingDate;
		$scope.invoice.merchandiseValue = invoice.merchandiseValue;
		$scope.invoice.servicesValue = invoice.servicesValue;
		$scope.invoice.totalServiceAndMerchandiseValue = invoice.totalServiceAndMerchandiseValue;
		$scope.invoice.totalDiscount = invoice.totalDiscount;
		$scope.invoice.totalTaxes  = invoice.totalTaxes;
		$scope.invoice.amountForPayment = invoice.amountForPayment;
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
	
	$scope.invoiceItems = [{id : 1}];
	
	$scope.addNewInvoiceItem = function(){
		var newItemNo = $scope.invoiceItems.length+1;
	    $scope.invoiceItems.push({'id': newItemNo});
	}
	
	$scope.invoice.invoiceItems = [];
	
	$scope.submitAction = function(invoice, invoiceItems){
		invoice.invoiceItems = invoiceItems;
		invoiceService.addInvoice(invoice).then(function(response){
			refreshView();
		});
	}
	
	$scope.rollbackAction = function(){
		$scope.mode.current = "Rezim pregleda";
		$scope.invoice = {};
		$scope.selectedInvoice = {};
		$scope.invoiceItem = {};
		$scope.invoiceItems = {};
		$scope.invoiceItems = [{id : 1}];
		refreshView();
	}
	
	$scope.showItems = function(id){
		$("#itemsModal").modal('show');
		$scope.setModalSelectedInvoiceItem();
		invoiceService.getItemsByInvoice(id).then(function(response){
			$scope.invoiceItemsInvoice = response.data;
		});
		
	}
	
	$scope.selectedModalInvoiceItem = {};
	$scope.setModalSelectedInvoiceItem = function(item){
		$scope.selectedModalInvoiceItem = item;
	}
	
});