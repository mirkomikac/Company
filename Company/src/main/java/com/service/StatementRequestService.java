package com.service;

import java.util.List;

import com.company.wsdl.StatementRequest;

public interface StatementRequestService {
	
	StatementRequest save(StatementRequest statementRequest);
	
	List<StatementRequest> findAll();
}
