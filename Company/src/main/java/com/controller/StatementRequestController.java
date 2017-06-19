package com.controller;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.validation.Valid;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.model.Bank;
import com.company.wsdl.StatementRequest;
import com.service.BankService;
import com.service.StatementRequestService;
import com.webservice.AccountStatementWebServiceClient;

@RestController
@RequestMapping("/statementRequests")
public class StatementRequestController {
	
	@Autowired
	private BankService bankService;
	
	@Autowired
	private StatementRequestService statementRequestService;
	
	@Autowired
	private ApplicationContext context;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<StatementRequest> getAll(){
		return statementRequestService.findAll();
	}
	
	@RequestMapping(path="/add", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<StatementRequest> add(@RequestBody @Valid StatementRequest statementRequest){
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(statementRequest.getStatementDateDate());
		cal.setTime(new Date());
		
		try {
			statementRequest.setStatementDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(cal));
		} catch (DatatypeConfigurationException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		cal.setTime(statementRequest.getCurrencyDateDate());
		
		try {
			statementRequest.setCurrencyDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(cal));
		} catch (DatatypeConfigurationException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		AccountStatementWebServiceClient client = context.getBean(AccountStatementWebServiceClient.class);
		Bank destinationBank = bankService.findByBankCode(statementRequest.getOriginatorAccountNumber());
		String bankServiceUrl = destinationBank.getAccountStatementRequestService();
		
		boolean success = client.sendAccountStatementSectionItem(statementRequest, destinationBank.getStatementService());
		
		statementRequestService.save(statementRequest);
		
		return null;
	}
}
