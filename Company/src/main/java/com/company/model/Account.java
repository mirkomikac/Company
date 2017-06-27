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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

import com.company.xsdschemas.invoice.InvoiceRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(uniqueConstraints={ @UniqueConstraint(columnNames={"accountNumber"})})
public class Account {

	@Id
	@GeneratedValue
	private Long id;

	@Size(min = 1, max = 50)
	@Column(nullable = false)
	private String accountNumber;

	@Column(nullable = false)
	private boolean active;

	@Size(min = 1, max = 3)
	@Column(nullable = false)
	private String currency;

	@ManyToOne(optional = false)
	private Bank bank;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "account", orphanRemoval = true, targetEntity = AccountRequestResponse.class)
	private Set<AccountRequestResponse> AccountRequestResponses;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "account", orphanRemoval = true, targetEntity = InvoiceRequest.class)
	@JsonIgnore
	private Set<InvoiceRequest> invoices;

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
