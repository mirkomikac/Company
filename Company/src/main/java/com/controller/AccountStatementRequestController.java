package com.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.wsdl.AccountStatementRequest;
import com.service.AccountStatementRequestService;

@RestController
@RequestMapping("/accountStatementRequests")
public class AccountStatementRequestController {
	@Autowired
	private AccountStatementRequestService accountStatementRequestService;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<AccountStatementRequest>> getAll(){
		return new ResponseEntity<List<AccountStatementRequest>>(accountStatementRequestService.getAll(), HttpStatus.OK);
	}
	
	@PostMapping("/create")
	@ResponseBody
	public ResponseEntity<AccountStatementRequest> create(@RequestBody @Valid AccountStatementRequest accountStatementRequest){
		AccountStatementRequest result = accountStatementRequestService.save(accountStatementRequest);
		return new ResponseEntity<AccountStatementRequest>(result, HttpStatus.OK);
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
