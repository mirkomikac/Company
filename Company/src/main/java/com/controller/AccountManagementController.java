package com.controller;

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

import com.company.model.Account;
import com.service.AccountService;

@RestController
@RequestMapping("/accountsManagement")
public class AccountManagementController {
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Account>> getAll(){
		return new ResponseEntity<List<Account>>(accountService.getAll(), HttpStatus.OK);
	}
	
	@PostMapping("/create")
	@ResponseBody
	public ResponseEntity<Account> create(@RequestBody @Valid Account account){
		Account result = accountService.save(account);
		return new ResponseEntity<Account>(result, HttpStatus.OK);
	}
	
	@PostMapping("/delete")
	@ResponseBody
	public ResponseEntity<Account> delete(@RequestBody Account account){
		accountService.delete(account);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/update")
	@ResponseBody
	public ResponseEntity<Account> update(@RequestBody @Valid Account account){
		Account result = accountService.update(account);
		return new ResponseEntity<Account>(result, HttpStatus.OK);
	}
	
	@PostMapping("/search")
	@ResponseBody
	public ResponseEntity<List<Account>> search(@RequestBody Account account){
		List<Account> result = accountService.searchWithoutActive(account.getAccountNumber(), account.getBank().getId());
		return new ResponseEntity<List<Account>>(result, HttpStatus.OK);
	}

}
