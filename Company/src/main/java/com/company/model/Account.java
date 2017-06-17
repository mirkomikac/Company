package com.company.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import com.company.wsdl.AccountStatementRequest;
import com.company.wsdl.AccountStatementSectionResponse;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Account {
	
	@Id
	@GeneratedValue
	private Long id;

	@Size(min=1, max=50)
	@Column(nullable=false)
	private String accountNumber;

	@Column(nullable=false)
	private boolean active;
	
	@Size(min=1, max=3)
	@Column(nullable=false)
	private String currency;

	@ManyToOne(optional = true)
	private Bank bank;

	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="account", orphanRemoval=true, targetEntity=AccountStatementRequest.class)
	private Set<AccountStatementRequest> accountStatementRequests;
	
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="account", orphanRemoval=true, targetEntity=AccountStatementSectionResponse.class)
	private Set<AccountStatementSectionResponse> accountStatementSectionResponses;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
}
