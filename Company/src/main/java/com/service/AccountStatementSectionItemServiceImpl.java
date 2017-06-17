package com.service;


import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.wsdl.AccountStatementSectionItem;
import com.repository.AccountStatementSectionItemRepository;

@Service
public class AccountStatementSectionItemServiceImpl implements AccountStatementSectionItemService{
	
	private final AccountStatementSectionItemRepository accountStatementSectionItemRepository;
	
	@Autowired
	public AccountStatementSectionItemServiceImpl(AccountStatementSectionItemRepository accountStatementSectionItemRepository) {
		this.accountStatementSectionItemRepository = accountStatementSectionItemRepository;
	}
	
	@Override
	public AccountStatementSectionItem save(AccountStatementSectionItem accountStatementSectionItem) {
		return accountStatementSectionItemRepository.save(accountStatementSectionItem);
	}

	@Override
	public List<AccountStatementSectionItem> findByAccountStatementSectionId(Long accountStatementSectionId) {
		return accountStatementSectionItemRepository.findByAccountStatementSectionId(accountStatementSectionId);
	}

	@Override
	public Collection<AccountStatementSectionItem> getAll() {
		return accountStatementSectionItemRepository.findAll();
	}
	
}
