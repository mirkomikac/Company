package com.company.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.company.xsdschemas.invoice.InvoiceRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Company {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String pib;
	
	@Column(nullable = false)
	private String address;
	
	@Column(nullable = true)
	private String urlInvoiceService;
	
	@Transient
	@JsonIgnore
	private Set<InvoiceRequest> invoiceSuppliers;
	
	@Transient
	@JsonIgnore
	private Set<InvoiceRequest> invoicePurchasers;

	public Company() {
		super();
	}
	
	public String getUrlInvoiceService() {
		return urlInvoiceService;
	}


	public void setUrlInvoiceService(String urlInvoiceService) {
		this.urlInvoiceService = urlInvoiceService;
	}


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

	public String getPib() {
		return pib;
	}

	public void setPib(String pib) {
		this.pib = pib;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@JsonIgnore
	public Set<InvoiceRequest> getInvoiceSuppliers() {
		return invoiceSuppliers;
	}

	@JsonProperty
	public void setInvoiceSuppliers(Set<InvoiceRequest> invoiceSuppliers) {
		this.invoiceSuppliers = invoiceSuppliers;
	}

	@JsonIgnore
	public Set<InvoiceRequest> getInvoicePurchasers() {
		return invoicePurchasers;
	}

	@JsonProperty
	public void setInvoicePurchasers(Set<InvoiceRequest> invoicePurchasers) {
		this.invoicePurchasers = invoicePurchasers;
	}
	
	
	
}
