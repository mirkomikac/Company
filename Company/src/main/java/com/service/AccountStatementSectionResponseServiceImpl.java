package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.wsdl.AccountStatementSectionResponse;
import com.repository.AccountStatementSectionResponseRepository;

@Service
public class AccountStatementSectionResponseServiceImpl implements AccountStatementSectionResponseService {
	
	private final AccountStatementSectionResponseRepository accountStatementSectionResponseRepository;
	
	@Autowired
	public AccountStatementSectionResponseServiceImpl(AccountStatementSectionResponseRepository accountStatementSectionResponseRepository) {
		this.accountStatementSectionResponseRepository = accountStatementSectionResponseRepository;
	}
	
	@Override
	public List<AccountStatementSectionResponse> findAll() {
		return accountStatementSectionResponseRepository.findAll();
	}

	@Override
	public AccountStatementSectionResponse save(AccountStatementSectionResponse accountStatementSectionResponse) {
		return accountStatementSectionResponseRepository.save(accountStatementSectionResponse);
	}

	@Override
	public void delete(AccountStatementSectionResponse accountStatementSectionResponse) {
		accountStatementSectionResponseRepository.delete(accountStatementSectionResponse);
	}

	@Override
	public List<AccountStatementSectionResponse> findByAccountId(Long accountId) {
		return accountStatementSectionResponseRepository.findByAccountId(accountId);
	}

}
