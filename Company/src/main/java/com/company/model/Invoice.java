package com.company.model;


import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Invoice {
	
	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private Long messageId;
	
	@ManyToOne(optional = false)
	private Company supplier;
	
	@ManyToOne(optional = false)
	private Company purchaser;
	
	@Column(nullable = false)
	private Integer billingNumber;
	
	@Column(nullable = false)
	private Date billingDate;
	
	@Column(nullable = false)
	private Double merchandiseValue;
	
	@Column(nullable = false)
	private Double serviceValue;
	
	@Column(nullable = false)
	private Double merchandiseAndServiceValue;
	
	@Column(nullable = false)
	private Double discount;
	
	@Column(nullable = false)
	private Double taxes;
	
	@Column(nullable = false)
	private Double amountForPayment;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy="invoice", targetEntity=InvoiceItem.class)
	private Set<InvoiceItem> invoiceItems;
	
	@ManyToOne(optional = false)
	private Account accountNumber;
	
	@Column(nullable = false)
	private String currency;
	
	@Column(nullable = false)
	private Date currencyDate;

	public Invoice() {
		super();
	}
	
	

	public Company getSupplier() {
		return supplier;
	}



	public void setSupplier(Company supplier) {
		this.supplier = supplier;
	}



	public Company getPurchaser() {
		return purchaser;
	}



	public void setPurchaser(Company purchaser) {
		this.purchaser = purchaser;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMessageId() {
		return messageId;
	}

	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}

	public Integer getBillingNumber() {
		return billingNumber;
	}

	public void setBillingNumber(Integer billingNumber) {
		this.billingNumber = billingNumber;
	}

	public Date getBillingDate() {
		return billingDate;
	}

	public void setBillingDate(Date billingDate) {
		this.billingDate = billingDate;
	}

	public Double getMerchandiseValue() {
		return merchandiseValue;
	}

	public void setMerchandiseValue(Double merchandiseValue) {
		this.merchandiseValue = merchandiseValue;
	}

	public Double getServiceValue() {
		return serviceValue;
	}

	public void setServiceValue(Double serviceValue) {
		this.serviceValue = serviceValue;
	}

	public Double getMerchandiseAndServiceValue() {
		return merchandiseAndServiceValue;
	}

	public void setMerchandiseAndServiceValue(Double merchandiseAndServiceValue) {
		this.merchandiseAndServiceValue = merchandiseAndServiceValue;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Double getTaxes() {
		return taxes;
	}

	public void setTaxes(Double taxes) {
		this.taxes = taxes;
	}

	public Double getAmountForPayment() {
		return amountForPayment;
	}

	public void setAmountForPayment(Double amountForPayment) {
		this.amountForPayment = amountForPayment;
	}

	@JsonIgnore
	public Set<InvoiceItem> getInvoiceItems() {
		return invoiceItems;
	}

	@JsonProperty
	public void setInvoiceItems(Set<InvoiceItem> invoiceItems) {
		this.invoiceItems = invoiceItems;
	}

	public Account getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Account accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Date getCurrencyDate() {
		return currencyDate;
	}

	public void setCurrencyDate(Date currencyDate) {
		this.currencyDate = currencyDate;
	}
	
	
	
}
