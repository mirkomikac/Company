package com.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.company.model.Account;
import com.company.model.AccountRequestResponse;
import com.company.wsdl.AccountStatementRequest;
import com.company.wsdl.AccountStatementSectionResponse;

public interface AccountRequestResponseRepository extends JpaRepository<AccountRequestResponse, Serializable>{
	
	@Query("select accountStatementRequest from AccountRequestResponse res where res.accountStatementSectionResponse.id = ?1")
	public AccountStatementRequest findAccountStatementRequestByResponse(Long id);
	
	@Query("select accountStatementSectionResponse from AccountRequestResponse res where res.accountStatementRequest.id = ?1")
	public AccountStatementSectionResponse findAccountStatementSectionResponseByRequest(Long id);
	
	
	@Query("select accountStatementRequest from AccountRequestResponse res where res.account.id = ?1")
	public List<AccountStatementRequest> findAccountStatementRequestByAccount(Long id);
	
	@Query("select accountStatementSectionResponse from AccountRequestResponse res where res.account.id = ?1")
	public List<AccountStatementSectionResponse> findAccountStatementSectionByAccount(Long id);
	
	
	@Query("select account from AccountRequestResponse res where res.accountStatementSectionResponse.id = ?1")
	public Account findAccountByResponse(Long id);
	
	@Query("select account from AccountRequestResponse res where res.accountStatementRequest.id = ?1")
	public Account findAccountByRequest(Long id);
};
