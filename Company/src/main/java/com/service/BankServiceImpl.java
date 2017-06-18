package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.model.Bank;
import com.repository.BankRepository;

@Service
public class BankServiceImpl implements BankService {

	private final BankRepository bankRepository;

	@Autowired
	public BankServiceImpl(BankRepository bankRepository) {
		this.bankRepository = bankRepository;
	}

	@Override
	public Bank save(Bank bank) {
		return bankRepository.save(bank);
	}

	@Override
	public Bank update(Bank bank) {
		Bank oldBank = bankRepository.findOne(bank.getId());
		oldBank.setName(bank.getName());
		oldBank.setAddress(bank.getAddress());
		oldBank.setAccountStatementRequestService(bank.getAccountStatementRequestService());
		oldBank.setStatementService(bank.getStatementService());
		oldBank.setEmail(bank.getEmail());
		oldBank.setFax(bank.getFax());
		oldBank.setBankCode(bank.getBankCode());
		oldBank.setTelephone(bank.getTelephone());
		oldBank.setWeb(bank.getWeb());
		return bankRepository.save(oldBank);
	}

	@Override
	public void delete(Bank bank) {
		bankRepository.delete(bank);
	}

	@Override
	public List<Bank> search(Bank bank) {
		return null;
	}

	@Override
	public List<Bank> getAll() {
		return bankRepository.findAll();
	}

	@Override
	public Bank getOne(Long id) {
		return bankRepository.findOne(id);
	}

	@Override
	public Bank findByBankCode(String accountNumber) {
		return bankRepository.findByBankCode(accountNumber.substring(0, 3));
	}

}
