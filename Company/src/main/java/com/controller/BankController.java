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

import com.company.model.Bank;
import com.service.BankService;

@RestController
@RequestMapping("/banks")
public class BankController {
	
	@Autowired
	private BankService bankService;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Bank>> getAll(){
		return new ResponseEntity<List<Bank>>(bankService.getAll(), HttpStatus.OK);
	}
	
	@PostMapping("/create")
	@ResponseBody
	public ResponseEntity<Bank> create(@RequestBody @Valid Bank bank){
		Bank result = bankService.save(bank);
		return new ResponseEntity<Bank>(result, HttpStatus.OK);
	}
	
	@PostMapping("/delete")
	@ResponseBody
	public ResponseEntity<Bank> delete(@RequestBody Bank bank){
		bankService.delete(bank);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/update")
	@ResponseBody
	public ResponseEntity<Bank> update(@RequestBody @Valid Bank bank){
		Bank result = bankService.update(bank);
		return new ResponseEntity<Bank>(result, HttpStatus.OK);
	}
	
	@PostMapping("/search")
	@ResponseBody
	public ResponseEntity<List<Bank>> search(@RequestBody Bank bank){
		List<Bank> result = bankService.search(bank);
		return new ResponseEntity<List<Bank>>(result, HttpStatus.OK);
	}
}
