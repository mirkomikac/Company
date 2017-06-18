package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.model.AccountRequestResponse;
import com.company.wsdl.AccountStatementSectionItem;
import com.company.wsdl.AccountStatementSectionResponse;
import com.service.AccountRequestResponseService;
import com.service.AccountStatementSectionItemService;
import com.service.AccountStatementSectionResponseService;

@RestController
@RequestMapping("/accountStatementSectionResponses")
public class AccountStatementSectionResponseController {

	@Autowired
	AccountStatementSectionResponseService accountStatementSectionResponseService;
	
	@Autowired
	AccountStatementSectionItemService accountStatementSectionItemService;
	
	@Autowired
	AccountRequestResponseService accountRequestResponseService;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<AccountStatementSectionResponse>> getAll(){
		return new ResponseEntity<List<AccountStatementSectionResponse>>(accountStatementSectionResponseService.findAll(), HttpStatus.OK);
	}
	
	@PostMapping("/delete")
	@ResponseBody
	public ResponseEntity<?> delete(@RequestBody AccountStatementSectionResponse accountStatementSectionResponse){
		accountStatementSectionResponseService.delete(accountStatementSectionResponse);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/search")
	@ResponseBody
	public ResponseEntity<List<AccountStatementSectionResponse>> search(@RequestBody AccountStatementSectionResponse accountStatementSectionResponse){
		List<AccountStatementSectionResponse> result = accountStatementSectionResponseService.findAll();
		return new ResponseEntity<List<AccountStatementSectionResponse>>(result, HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/details/{id}", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<List<AccountStatementSectionItem>> getItems(@PathVariable("id") Long accountStatementSectionResponseId){
		List<AccountStatementSectionItem> result = accountStatementSectionItemService.findByAccountStatementSectionId(accountStatementSectionResponseId);
		return new ResponseEntity<List<AccountStatementSectionItem>>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value="/get/{id}", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<AccountStatementSectionResponse> getOne(@PathVariable("id") Long accountStatementSectionRequestId){
		AccountStatementSectionResponse result = accountRequestResponseService.findAccountStatementSectionResponseByRequest(accountStatementSectionRequestId);
		return new ResponseEntity<AccountStatementSectionResponse>(result, HttpStatus.OK);
	}
}
