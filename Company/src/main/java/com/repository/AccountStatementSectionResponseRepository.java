package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.company.wsdl.AccountStatementSectionResponse;

public interface AccountStatementSectionResponseRepository extends JpaRepository<AccountStatementSectionResponse, Long>{
	
}
