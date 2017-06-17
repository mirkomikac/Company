var accountStatementSectionResponseService = angular.module('company.accountStatementSectionResponseService', []);

accountStatementSectionResponseService.factory('accountStatementSectionResponseService', function($http){
	
	var temp = {};
	
	temp.getAllAccountStatementSectionResponses = function(){
		return $http.get('/accountStatementSectionResponses/');
	};
	
	temp.deleteAccountStatementSectionResponse = function(accountStatementSectionResponse){
		var jsonASSR = JSON.stringify({
			id : accountStatementSectionResponse.id
		});
		return $http.post('/accountStatementSectionResponses/delete/', jsonASSR);
	};
	
	temp.searchAccountStatementSectionResponses = function(accountStatementSectionResponse){
		
		//return $http.post('/accountStatementRequests/search/', jsonAccountStatementRequest);
		return $http.get('/accountStatementSectionResponses');
	};
	
	temp.getAccountStatementSectionItems = function(id){
		return $http.post('/accountStatementSectionResponses/details/' + id);
	}
	
	return temp;
});