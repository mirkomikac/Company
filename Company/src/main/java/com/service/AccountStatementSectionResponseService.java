package com.service;

import java.util.List;

import com.company.wsdl.AccountStatementSectionResponse;

public interface AccountStatementSectionResponseService {
	
	List<AccountStatementSectionResponse> findAll();
	
	AccountStatementSectionResponse save(AccountStatementSectionResponse accountStatementSectionResponse);
	
	void delete(AccountStatementSectionResponse accountStatementSectionResponse);
	
}
