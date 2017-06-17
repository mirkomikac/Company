package com.service;

import java.util.Collection;
import java.util.List;

import com.company.wsdl.AccountStatementSectionItem;

public interface AccountStatementSectionItemService {
	
	AccountStatementSectionItem save(AccountStatementSectionItem accountStatementSectionItem);
	
	List<AccountStatementSectionItem> findByAccountStatementSectionId(Long accountStatementSectionId);
	
	Collection<AccountStatementSectionItem> getAll();
}
