var accountStatementRequestService = angular.module('company.accountStatementRequestService', []);

accountStatementRequestService.factory('accountStatementRequestService', function($http){
	
	var temp = {};
	
	temp.getAllAccountStatementRequests = function(){
		return $http.get('/accountStatementRequests');
	};
	
	temp.deleteAccountStatementRequest = function(accountStatementRequest){
		var jsonAccountStatementRequest = JSON.stringify({
			id : accountStatementRequest.id
		});
		return $http.post('/accountStatementRequests/delete/', jsonExchangeList);
	};
	
	temp.addAccountStatementRequest = function(accountStatementRequest, date, accountNumber){
		var dT = new Date(date);
		var jsonAccountStatementRequest = JSON.stringify({
			dateDate : dT.valueOf(),
			accountNumber : accountNumber,
			sectionOrdinate : accountStatementRequest.sectionOrdinate
		
		});
		return $http.post('/accountStatementRequests/create/', jsonAccountStatementRequest);
	};
	
	temp.searchAccountStatementRequests = function(accountStatementRequest, date, account){
		var dT = new Date(date);
		var sectionOrdinate = -1;
		
		if(accountStatementRequest.sectionOrdinate != undefined || accountStatementRequest.sectionOrdinate != null){
			sectionOrdinate = accountStatementRequest.sectionOrdinate;
		}
		
		var jsonAccountStatementRequest = JSON.stringify({
			date : dT.valueOf(),
			accountNumber : account.accountNumber,
			sectionOrdinate : accountStatementRequest.sectionOrdinate
		
		});
		
		return $http.post('/accountStatementRequests/search/', jsonAccountStatementRequest);
	};
	
	return temp;
});