package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.wsdl.AccountStatementRequest;
import com.company.wsdl.AccountStatementSectionResponse;
import com.company.wsdl.StatementRequest;
import com.webservice.AccountStatementWebServiceClient;

@RestController
@RequestMapping("/accounts")
public class AccountController {

	private final AccountStatementWebServiceClient accountStatementWebService;
	
	@Autowired
	public AccountController(@Qualifier("accountStatementWebService") AccountStatementWebServiceClient accountStatementWebService) {
		this.accountStatementWebService = accountStatementWebService;
	}
	
	@PostMapping("/add")
	@ResponseBody
	public boolean addAccountStatement(@RequestBody StatementRequest request){
		return accountStatementWebService.sendAccountStatementSectionItem(request);
	}
	
	@PostMapping("/status")
	@ResponseBody
	public AccountStatementSectionResponse getAccountStatementStatus(@RequestBody AccountStatementRequest accountStatementRequest){
		return accountStatementWebService.getAccountStatementResponse(accountStatementRequest);
	}
	
}
