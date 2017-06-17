package com.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.model.Account;
import com.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService{

	private final AccountRepository accountRepository;

	@Autowired
	public AccountServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	@Override
	public List<Account> getAll() {
		return accountRepository.findAll();
	}
	
	
	@Override
	public Account save(Account account) {
		return accountRepository.save(account);
	}

	@Override
	public void delete(Account account) {
		accountRepository.delete(account);
	}

	@Override
	public Account update(@Valid Account account) {
		Account oldAccount = accountRepository.findOne(account.getId());
		oldAccount.setAccountNumber(account.getAccountNumber());
		oldAccount.setActive(account.isActive());
		oldAccount.setBank(account.getBank());
		return accountRepository.save(oldAccount);
	}

	@Override
	public List<Account> searchWithoutActive(String accountNumber, Long bankId) {
		return accountRepository.searchWithoutActive(accountNumber, bankId);
	}
	
	@Override
	public List<Account> searchWithActive(String accountNumber, Long bankId, boolean active) {
		return accountRepository.searchWithActive(accountNumber, bankId, active);
	}

	@Override
	public List<Account> findByBankId(Long bankId) {
		return accountRepository.findByBankId(bankId);
	}

}
