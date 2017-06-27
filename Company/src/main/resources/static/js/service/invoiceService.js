var invoiceService = angular.module('company.invoiceService', []);

invoiceService.factory('invoiceService', function($http){
	var temp = {};
	
	temp.getAllInvoices = function(){
		return $http.get("/invoices/getAll");
	}
	
	temp.addInvoice = function(invoice){
		return $http.post("/invoices/addInvoice", invoice);
	}
	
	temp.addInvoiceItem = function(invoiceItem){
		return $http.post("/invoiceItems/addInvoiceItem", invoiceItem);
	}
	
	temp.getAllCompanies = function(){
		return $http.get("/companies/getAllCompanies");
	}
	
	temp.getItemsByInvoice = function(id){
		return $http.post("/invoiceItems/getByInvoiceId", id);
	}

	return temp;
});