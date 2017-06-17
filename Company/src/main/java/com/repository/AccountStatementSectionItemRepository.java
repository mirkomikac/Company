package com.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.company.wsdl.AccountStatementSectionItem;

public interface AccountStatementSectionItemRepository extends JpaRepository<AccountStatementSectionItem, Long>{
	
	@Query("select item from AccountStatementSectionItem item where item.accountStatementSectionResponse.id=?1")
	List<AccountStatementSectionItem> findByAccountStatementSectionId(Long accountStatementSectionId);
}
