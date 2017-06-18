package com.service;

import java.util.List;

import com.company.model.Account;
import com.company.model.AccountRequestResponse;
import com.company.wsdl.AccountStatementRequest;
import com.company.wsdl.AccountStatementSectionResponse;

public interface AccountRequestResponseService {
	public AccountStatementRequest findAccountStatementRequestByResponse(Long id);

	public AccountStatementSectionResponse findAccountStatementSectionResponseByRequest(Long id);

	public List<AccountStatementRequest> findAccountStatementRequestByAccount(Long id);

	public List<AccountStatementSectionResponse> findAccountStatementSectionByAccount(Long id);

	public Account findAccountByResponse(Long id);

	public Account findAccountByRequest(Long id);
	
	public AccountRequestResponse save(AccountRequestResponse accountRequestResponse);
	
	public void delete(AccountRequestResponse accountRequestResponse);

}
