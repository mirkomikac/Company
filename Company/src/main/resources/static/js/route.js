var app = angular.module("company.route", [ "ngRoute" ]);

app.config(function($routeProvider) {
	$routeProvider.when("/", {
		templateUrl : "html/index.html"
	}).when("/accountStatementRequests", {
		templateUrl : "html/accountStatementRequest.html"
	}).when("/banks", {
		templateUrl : "html/bank.html"
	}).when("/accountsManagement", {
		templateUrl : "html/account.html"
	}).when("/accountStatementSectionResponses", {
		templateUrl : "html/accountStatementSectionResponse.html"
	});

});