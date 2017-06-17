package com.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.company.wsdl.AccountStatementRequest;

public interface AccountStatementRequestRepository extends JpaRepository<AccountStatementRequest, Long>{
	
	
	@Query("select statement from AccountStatementRequest statement where statement.accountNumber = ?1 and statement.dateDate between ?2 and ?3 and statement.sectionOrdinate between ?4 and ?5")
	List<AccountStatementRequest> search(String accountNumber, Date min, Date max, short sectionOrdinateMin, short sectionOrdinateMax);

	@Query("select statement from AccountStatementRequest statement where statement.account.id = ?1")
	List<AccountStatementRequest> findByAccountId(Long accountId);
}
