package com.service;

import java.util.Date;
import java.util.List;

import com.company.wsdl.AccountStatementRequest;

public interface AccountStatementRequestService {
	
	AccountStatementRequest save(AccountStatementRequest accountStatementRequest);
	
	void delete(AccountStatementRequest accountStatementRequest);
	
	List<AccountStatementRequest> getAll();
	
	List<AccountStatementRequest> search(String accountNumber, Date dateMin, Date dateMax, short sectionOrdinateMin, short sectionOrdinateMax);
	
	List<AccountStatementRequest> findByAccountId(Long accountId);
	
}
