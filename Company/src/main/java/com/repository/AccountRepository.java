package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.company.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
	
	@Query("select account from Account account where account.accountNumber=?1 and account.bank.id=?2 and account.active=?3")
	public List<Account> searchWithActive(String accountNumber, Long bankId, boolean active);
	
	@Query("select account from Account account where account.accountNumber=?1 and account.bank.id=?2")
	public List<Account> searchWithoutActive(String accountNumber, Long bankId);
	
	@Query("select account from Account account where account.bank.id=?1")
	public List<Account> findByBankId(Long bankId);
}
