var accountService = angular.module(
		'company.accountService', []);

accountService.factory('accountService', function($http) {

	var temp = {};

	temp.getAllAccounts = function() {
		return $http.get('/accountsManagement/');
	};

	temp.deleteAccount = function(account){
		return $http.post('/accountsManagement/delete/',account);
	};


	temp.addAccount = function(account) {
		var jsonAccount = JSON.stringify({
			accountNumber : account.accountNumber,
			bank : {
				id : bankId
			},
			currency : account.currency,
			active : true
		});
		return $http.post('/accountsManagement/create', jsonAccount);
	};

	temp.editAccount = function(account, status,
			openingDate, bankId, clientId, currencyId) {
		var dT = new Date(openingDate);
		dT = dT.getTime();
		var active = true;
		if (status == "Aktivan") {
			active = true;
		} else if (status == "Neaktivan") {
			active = false;
		} else {
			active = account.active;
		}	
		if (openingDate == null) {
			dT = account.openingDate;
		}
		var jsonAccount = JSON.stringify({
			id : account.id,
			openingDate : dT,
			active : active,
			accountNumber : account.accountNumber,
			bank : {
				id : bankId
			}
		});

		return $http.put('/accountsManagement/update/', jsonAccount);
	};

	temp.getAllBanks = function() {
		return $http.get('/banks');
	}

	temp.accounts = function(account, status, bank) {
		var bankName; 
		
		pathVarActive = "null";
		if (status != null) {
			if (status == "Aktivan") {
				active = true;
				pathVarActive = "true";
			} else if (status == "Neaktivan") {
				active = false;
				pathVarActive = "false";
			}
		} else {
			active = null;
			pathVarActive = "null";
		}
		if(bank != null){
			bankName = bank.name;
		} else {
			bankName = "";
		}

		var jsonLegalPersonAccount = JSON.stringify({
			active : active,
			accountNumber : account.accountNumber,
			bank : {
				name : bankName
			},
			client : {
				name : clientName,
				surname : clientSurname
			},
			currency : account.currency
		});

		return $http.post('/accounts/search/' + pathVarActive, jsonLegalPersonAccount);

	};

	return temp;

});