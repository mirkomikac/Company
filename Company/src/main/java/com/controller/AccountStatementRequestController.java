package com.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.validation.Valid;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.model.Account;
import com.company.model.AccountRequestResponse;
import com.company.model.Bank;
import com.company.wsdl.AccountStatementRequest;
import com.company.wsdl.AccountStatementSectionResponse;
import com.service.AccountRequestResponseService;
import com.service.AccountService;
import com.service.AccountStatementRequestService;
import com.service.AccountStatementSectionItemService;
import com.service.AccountStatementSectionResponseService;
import com.service.BankService;
import com.webservice.AccountStatementWebServiceClient;

@RestController
@RequestMapping("/accountStatementRequests")
public class AccountStatementRequestController {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private AccountStatementRequestService accountStatementRequestService;
	
	@Autowired
	private AccountStatementSectionResponseService accountStatementSectionResponseService;
	
	@Autowired
	private AccountRequestResponseService accountRequestResponseService;
	
	@Autowired
	private AccountStatementSectionItemService accountStatementSectionItemService;
	
	@Autowired
	private BankService bankService;
	
	@Autowired
	private ApplicationContext context;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<AccountStatementRequest>> getAll(){
		return new ResponseEntity<List<AccountStatementRequest>>(accountStatementRequestService.getAll(), HttpStatus.OK);
	}
	
	@PostMapping("/create")
	@ResponseBody
	public ResponseEntity<AccountStatementRequest> create(@RequestBody @Valid AccountStatementRequest accountStatementRequest){
		
		Account account = accountService.findByAccountNumber(accountStatementRequest.getAccountNumber());
		if(account != null){
			accountStatementRequest.setSectionOrdinate((short) (accountStatementRequest.getSectionOrdinate() - 1));
			
			GregorianCalendar cal = new GregorianCalendar();
			cal.setTime(accountStatementRequest.getDateDate());
			
			try {
				accountStatementRequest.setDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(cal));
			} catch (DatatypeConfigurationException e) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			
			AccountStatementWebServiceClient client = context.getBean(AccountStatementWebServiceClient.class);
			Bank destinationBank = bankService.findByBankCode(accountStatementRequest.getAccountNumber());
			String bankServiceUrl = destinationBank.getAccountStatementRequestService();
			
			AccountStatementSectionResponse response = client.getAccountStatementResponse(accountStatementRequest, bankServiceUrl);
			
			if(response != null){
			
				AccountStatementRequest result = accountStatementRequestService.save(accountStatementRequest);
				
				response.setRequestDateDate(response.getRequestDate().toGregorianCalendar().getTime());
				
				for(int i = 0;i < response.getAccountStatementSectionItems().size();i++){
					response.getAccountStatementSectionItems().get(i).setAccountStatementSectionResponse(response);
					response.getAccountStatementSectionItems().get(i).setCurrencyDateDate(response.getAccountStatementSectionItems().get(i).getCurrencyDate().toGregorianCalendar().getTime());
					response.getAccountStatementSectionItems().get(i).setStatementDateDate(response.getAccountStatementSectionItems().get(i).getStatementDate().toGregorianCalendar().getTime());
					if(response.getAccountStatementSectionItems().get(i).getRecieverAccountNumber().equals(response.getAccountNumber())){
						response.getAccountStatementSectionItems().get(i).setDirection("PRILIV");
					} else {
						response.getAccountStatementSectionItems().get(i).setDirection("ODLIV");
					}
				}
				
				AccountStatementSectionResponse accountStatementSectionResponse = accountStatementSectionResponseService.save(response);
				
				
				
				for(int i = 0;i < response.getAccountStatementSectionItems().size();i++){
					accountStatementSectionItemService.save(response.getAccountStatementSectionItems().get(i));
				}
				
				AccountRequestResponse accountRequestResponse= new AccountRequestResponse();
				accountRequestResponse.setAccount(account);
				accountRequestResponse.setAccountStatementRequest(result);
				accountRequestResponse.setAccountStatementSectionResponse(accountStatementSectionResponse);
				
				accountRequestResponseService.save(accountRequestResponse);
				
				return new ResponseEntity<AccountStatementRequest>(result, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/delete")
	@ResponseBody
	public ResponseEntity<AccountStatementRequest> delete(@RequestBody AccountStatementRequest bank){
		accountStatementRequestService.delete(bank);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/search")
	@ResponseBody
	public ResponseEntity<List<AccountStatementRequest>> search(@RequestBody AccountStatementRequest accountStatementRequest){
		Calendar cal = Calendar.getInstance();
		cal.set(1900, 1, 1);
		Date dateMin = cal.getTime();
		cal.set(2100, 12, 31);
		Date dateMax = cal.getTime();
		if(accountStatementRequest.getDateDate() != null){
			cal.setTime(accountStatementRequest.getDateDate());
			cal.set(Calendar.HOUR, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.DATE, cal.get(Calendar.DATE) + 1);
			dateMin = cal.getTime();
			cal.setTime(accountStatementRequest.getDateDate());
			cal.set(Calendar.HOUR, 23);
			cal.set(Calendar.MINUTE, 59);
			cal.set(Calendar.SECOND, 59);
			cal.set(Calendar.DATE, cal.get(Calendar.DATE) + 1);
			dateMax = cal.getTime();
		}
		
		String accountNumber = "";
		if(accountStatementRequest.getAccountNumber() != null){
			accountNumber = accountStatementRequest.getAccountNumber();
		}
		
		accountNumber = "%" + accountNumber + "%";
		
		short sectionOrdinateMin = 0;
		short sectionOrdinateMax = 999;
		
		if(accountStatementRequest.getSectionOrdinate() != -1){
			sectionOrdinateMin = accountStatementRequest.getSectionOrdinate();
			sectionOrdinateMax = accountStatementRequest.getSectionOrdinate();
		}
		
		List<AccountStatementRequest> result = accountStatementRequestService.search(accountNumber, dateMin, dateMax, sectionOrdinateMin, sectionOrdinateMax);
		return new ResponseEntity<List<AccountStatementRequest>>(result, HttpStatus.OK);
	}
}
