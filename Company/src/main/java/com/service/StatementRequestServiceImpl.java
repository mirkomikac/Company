package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.wsdl.StatementRequest;
import com.repository.StatementRequestRepository;

@Service
public class StatementRequestServiceImpl implements StatementRequestService{

	private final StatementRequestRepository statementRequestRepository;
	
	@Autowired
	public StatementRequestServiceImpl(StatementRequestRepository statementRequestRepository) {
		this.statementRequestRepository = statementRequestRepository;
	}
	
	@Override
	public StatementRequest save(StatementRequest statementRequest) {
		return statementRequestRepository.save(statementRequest);
	}

	@Override
	public List<StatementRequest> findAll() {
		return statementRequestRepository.findAll();
	}
	
}
