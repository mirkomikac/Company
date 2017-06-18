package com.company.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.company.wsdl.AccountStatementRequest;
import com.company.wsdl.AccountStatementSectionResponse;

@Entity
@Table(uniqueConstraints={ @UniqueConstraint(columnNames={"account_request", "account_response"})})
public class AccountRequestResponse {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne(optional = false)
	@JoinColumn(name="account_request")
	public AccountStatementRequest accountStatementRequest;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="account_response")
	public AccountStatementSectionResponse accountStatementSectionResponse;
	
	@ManyToOne(optional = false)
	public Account account;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AccountStatementRequest getAccountStatementRequest() {
		return accountStatementRequest;
	}

	public void setAccountStatementRequest(AccountStatementRequest accountStatementRequest) {
		this.accountStatementRequest = accountStatementRequest;
	}

	public AccountStatementSectionResponse getAccountStatementSectionResponse() {
		return accountStatementSectionResponse;
	}

	public void setAccountStatementSectionResponse(AccountStatementSectionResponse accountStatementSectionResponse) {
		this.accountStatementSectionResponse = accountStatementSectionResponse;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}
