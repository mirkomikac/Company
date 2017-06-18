package com.service;

import java.util.List;

import com.company.model.Bank;

public interface BankService {
	
	List<Bank> getAll();
	Bank save(Bank bank);
	Bank update(Bank bank);
	void delete(Bank bank);
	List<Bank> search(Bank bank);
	Bank getOne(Long id);
	Bank findByBankCode(String accountNumber);
}
