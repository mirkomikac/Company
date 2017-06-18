package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.company.model.Bank;

public interface BankRepository extends JpaRepository<Bank, Long>{
	
	@Query("select bank from Bank bank where bank.bankCode = ?1")
	public Bank findByBankCode(String bankCode);
}
