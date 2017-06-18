package com.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.model.Account;
import com.company.model.Bank;
import com.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	private final AccountRepository accountRepository;
	
	private final BankService bankService;

	@Autowired
	public AccountServiceImpl(AccountRepository accountRepository, BankService bankService) {
		this.accountRepository = accountRepository;
		this.bankService = bankService;
	}

	@Override
	public List<Account> getAll() {
		return accountRepository.findAll();
	}

	@Override
	public Account save(Account account) {
		Bank bank = bankService.getOne(account.getBank().getId());
		if (account.getAccountNumber().substring(0, 3).equals(bank.getBankCode())) {
			return accountRepository.save(account);
		} else {
			return null;
		}
	}

	@Override
	public void delete(Account account) {
		accountRepository.delete(account);
	}

	@Override
	public Account update(@Valid Account account) {
		Bank bank = bankService.getOne(account.getBank().getId());
		if(!account.getAccountNumber().substring(0, 3).equals(bank.getBankCode())){
			return null;
		}
		
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

	@Override
	public Account findByAccountNumber(String accountNumber) {
		return accountRepository.findByAccountNumber(accountNumber);
	}

}
