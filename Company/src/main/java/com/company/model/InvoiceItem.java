package com.company.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class InvoiceItem {
	
	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private Integer ordinate;
	
	@Column(nullable = false)
	private String merchandiseOrServiceName;
	
	@Column(nullable = false)
	private Double amount;
	
	@Column(nullable = false)
	private String unitOfMeasure;
	
	@Column(nullable = false)
	private Double unitPrice;
	
	@Column(nullable = false)
	private Double value;
	
	@Column(nullable = false)
	private Double discountPercentage;
	
	@Column(nullable = false)
	private Double discountValue;
	
	@Column(nullable = false)
	private Double discountTaken;
	
	@Column(nullable = false)
	private Double totalTaxes;
	
	@ManyToOne(optional = false)
	private Invoice invoice;

	public InvoiceItem() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getOrdinate() {
		return ordinate;
	}

	public void setOrdinate(Integer ordinate) {
		this.ordinate = ordinate;
	}

	public String getMerchandiseOrServiceName() {
		return merchandiseOrServiceName;
	}

	public void setMerchandiseOrServiceName(String merchandiseOrServiceName) {
		this.merchandiseOrServiceName = merchandiseOrServiceName;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}

	public void setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Double getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(Double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public Double getDiscountValue() {
		return discountValue;
	}

	public void setDiscountValue(Double discountValue) {
		this.discountValue = discountValue;
	}

	public Double getDiscountTaken() {
		return discountTaken;
	}

	public void setDiscountTaken(Double discountTaken) {
		this.discountTaken = discountTaken;
	}

	public Double getTotalTaxes() {
		return totalTaxes;
	}

	public void setTotalTaxes(Double totalTaxes) {
		this.totalTaxes = totalTaxes;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	
	
	
}
