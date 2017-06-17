package com.controller;

import java.util.Collection;

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

import com.company.wsdl.AccountStatementSectionItem;
import com.service.AccountStatementSectionItemService;

@RestController
@RequestMapping("/accountStatementSectionItems")
public class AccountStatementSectionItemController {
	@Autowired
	private AccountStatementSectionItemService accountStatementSectionItemService;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<Collection<AccountStatementSectionItem>> getAll(){
		return new ResponseEntity<Collection<AccountStatementSectionItem>>(accountStatementSectionItemService.getAll(), HttpStatus.OK);
	}
	
	@PostMapping("/create")
	@ResponseBody
	public ResponseEntity<AccountStatementSectionItem> create(@RequestBody @Valid AccountStatementSectionItem accountStatementSectionItem){
		AccountStatementSectionItem result = accountStatementSectionItemService.save(accountStatementSectionItem);
		return new ResponseEntity<AccountStatementSectionItem>(result, HttpStatus.OK);
	}
	
	@PostMapping("/search")
	@ResponseBody
	public ResponseEntity<Collection<AccountStatementSectionItem>> search(@RequestBody AccountStatementSectionItem accountStatementSectionItem){
		Collection<AccountStatementSectionItem> result = accountStatementSectionItemService.getAll();
		return new ResponseEntity<Collection<AccountStatementSectionItem>>(result, HttpStatus.OK);
	}
}
