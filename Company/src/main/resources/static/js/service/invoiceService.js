var invoiceService = angular.module('company.invoiceService', []);

invoiceService.factory('invoiceService', function($http){
	var temp = {};
	
	temp.getAllInvoices = function(){
		return $http.get("/invoices/getAll");
	}
	
	temp.addInvoice = function(invoice){
		return $http.post("/invoices/addInvoice", invoice);
	}

	return temp;
});