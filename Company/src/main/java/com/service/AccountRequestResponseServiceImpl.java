package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.model.Account;
import com.company.model.AccountRequestResponse;
import com.company.wsdl.AccountStatementRequest;
import com.company.wsdl.AccountStatementSectionResponse;
import com.repository.AccountRequestResponseRepository;

@Service
public class AccountRequestResponseServiceImpl implements AccountRequestResponseService{
	
	@Autowired
	private AccountRequestResponseRepository accountRequestResponseRepository;
	
	@Override
	public AccountStatementRequest findAccountStatementRequestByResponse(Long id) {
		return accountRequestResponseRepository.findAccountStatementRequestByResponse(id);
	}

	@Override
	public AccountStatementSectionResponse findAccountStatementSectionResponseByRequest(Long id) {
		return accountRequestResponseRepository.findAccountStatementSectionResponseByRequest(id);
	}

	@Override
	public List<AccountStatementRequest> findAccountStatementRequestByAccount(Long id) {
		return accountRequestResponseRepository.findAccountStatementRequestByAccount(id);
	}

	@Override
	public List<AccountStatementSectionResponse> findAccountStatementSectionByAccount(Long id) {
		return accountRequestResponseRepository.findAccountStatementSectionByAccount(id);
	}

	@Override
	public Account findAccountByResponse(Long id) {
		return accountRequestResponseRepository.findAccountByResponse(id);
	}

	@Override
	public Account findAccountByRequest(Long id) {
		return accountRequestResponseRepository.findAccountByRequest(id);
	}

	@Override
	public AccountRequestResponse save(AccountRequestResponse accountRequestResponse) {
		return accountRequestResponseRepository.save(accountRequestResponse);
	}

	@Override
	public void delete(AccountRequestResponse accountRequestResponse) {
		accountRequestResponseRepository.delete(accountRequestResponse);
	}

}
