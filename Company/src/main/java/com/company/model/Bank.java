package com.company.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Bank {
	
	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false, length = 120)
	private String name;

	@Column(nullable = false, length = 120)
	private String address;
	
	@Column(nullable = false, length = 255)
	private String accountStatementRequestService;
	
	@Column(nullable = false, length = 255)
	private String statementService;

	@Column(length = 128)
	@Email
	private String email;

	@Column(length = 128)
	private String web;

	@Column(length = 20)
	private String telephone;

	@Column(length = 20)
	private String fax;
	
	@Column(nullable = false)
	String bankCode;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "bank", orphanRemoval = true, targetEntity = Account.class)
	private Set<Account> accounts;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getAccountStatementRequestService() {
		return accountStatementRequestService;
	}

	public void setAccountStatementRequestService(String accountStatementRequestService) {
		this.accountStatementRequestService = accountStatementRequestService;
	}

	public String getStatementService() {
		return statementService;
	}

	public void setStatementService(String statementService) {
		this.statementService = statementService;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
}
