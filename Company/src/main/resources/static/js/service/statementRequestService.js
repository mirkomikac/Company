var statementRequestService = angular.module(
		'company.statementRequestService', []);

statementRequestService.factory('statementRequestService', function($http) {

	var temp = {};

	temp.getAllStatementRequests = function() {
		return $http.get('/statementRequests/');
	};

	temp.deleteStatamentRequest = function(statementRequest){
		return $http.post('/statamentRequests/delete/',account);
	};
	temp.addStatementRequest = function(statementRequest) {
		var jsonStatementRequest = JSON.stringify({
			amount : statementRequest.amount,
			chargeDialNumber : statementRequest.chargeDialNumber,
			clearanceDialNumber : statementRequest.clearanceDialNumber,
			clearanceModel : statementRequest.clearanceModel,
			chargeModel : statementRequest.chargeModel,
			currency : statementRequest.currency,
			currencyDateDate : new Date(),
			emergency : statementRequest.emergency,
			originator : statementRequest.originator,
			originatorAccountNumber : statementRequest.originatorAccountNumber,
			reciever : statementRequest.reciever,
			recieverAccountNumber : statementRequest.recieverAccountNumber,
			statementDateDate : new Date(),
			placeOfAcceptance : statementRequest.placeOfAcceptance,
			paymentPurpose : statementRequest.paymentPurpose,
			messageId : "messageId"
		});
		return $http.post('/statementRequests/add', jsonStatementRequest);
	};

	temp.getAllAccounts = function() {
		return $http.get('/accounts');
	}

	temp.searchStatementRequests = function(statementRequest, date) {

		return $http.post('/statementRequests/search/' + pathVarActive, jsonStatementRequest);
	};

	return temp;

});