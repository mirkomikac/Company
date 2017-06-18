var bankService = angular.module('company.bankService', []);

bankService.factory('bankService', function($http){
	
var temp = {};
	
	temp.getAllBanks = function(){
		return $http.get('/banks');
	}
	
	temp.createBank = function(bank){
		jsonBank = JSON.stringify({
			name: bank.name,
			address: bank.address,
			email: bank.email,
			web: bank.web,
			telephone: bank.telephone,
			fax: bank.fax,
			statementService: bank.statementService,
			accountStatementRequestService: bank.accountStatementRequestService,
			bankCode : bank.bankCode
		});
		return $http.post('/banks/create/', jsonBank);
		
	}
	
	temp.updateBank = function(bank){
		jsonBank = JSON.stringify({
			id : bank.id,
			name: bank.name,
			address: bank.address,
			email: bank.email,
			web: bank.web,
			telephone: bank.telephone,
			fax: bank.fax,
			statementService: bank.statementService,
			accountStatementRequestService: bank.accountStatementRequestService,
			bankCode : bank.bankCode
		});
		return $http.post('/banks/update/', jsonBank);
	}
	
	temp.deleteBank = function(bank){
		jsonBank = JSON.stringify({
			id : bank.id,
			name: bank.name,
			address: bank.address,
			email: bank.email,
			web: bank.web,
			telephone: bank.telephone,
			fax: bank.fax,
			statementService: bank.statementService,
			accountStatementRequestService : bank.accountStatementRequestService});
		return $http.post('/banks/delete/', jsonBank);
	}
	
	temp.searchBanks = function(bank){
		jsonBank = JSON.stringify({
			name: bank.name,
			address: bank.address,
			email: bank.email,
			web: bank.web,
			telephone: bank.telephone,
			fax: bank.fax,
			statementService: bank.statementService,
			accountStatementRequestService: bank.accountStatementRequestService});
		return $http.post('/banks/search/', jsonBank);
		
	};
	return temp;
});