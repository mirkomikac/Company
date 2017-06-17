package com.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.wsdl.AccountStatementRequest;
import com.repository.AccountStatementRequestRepository;

@Service
public class AccountStatementRequestServiceImpl implements AccountStatementRequestService{
	
	private final AccountStatementRequestRepository accountStatementRequestRepository;
	
	@Autowired
	public AccountStatementRequestServiceImpl(AccountStatementRequestRepository accountStatementRequestRepository) {
		this.accountStatementRequestRepository = accountStatementRequestRepository;
	}
	
	@Override
	public AccountStatementRequest save(AccountStatementRequest accountStatementRequest) {
		return accountStatementRequestRepository.save(accountStatementRequest);
	}

	@Override
	public void delete(AccountStatementRequest accountStatementRequest) {
		accountStatementRequestRepository.delete(accountStatementRequest);
	}

	@Override
	public List<AccountStatementRequest> getAll() {
		return accountStatementRequestRepository.findAll();
	}

	@Override
	public List<AccountStatementRequest> search(String accountNumber, Date dateMin, Date dateMax, short sectionOrdinateMin, short sectionOrdinateMax) {
		return accountStatementRequestRepository.search(accountNumber, dateMin, dateMax, sectionOrdinateMin, sectionOrdinateMax);
	}

	@Override
	public List<AccountStatementRequest> findByAccountId(Long accountId) {
		return accountStatementRequestRepository.findByAccountId(accountId);
	}

}
