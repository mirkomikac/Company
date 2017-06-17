package com.service;

import java.util.List;

import com.company.model.Account;

public interface AccountService {
	
	List<Account> getAll();
	List<Account> findByBankId(Long bankId);
	Account save(Account account);
	void delete(Account account);
	Account update(Account account);
	List<Account> searchWithoutActive(String accountNumber, Long bankId);
	List<Account> searchWithActive(String accountNumber, Long bankId, boolean active);
	
}
