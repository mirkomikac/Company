//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.06.14 at 11:37:44 PM CEST 
//


package com.company.wsdl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

import com.company.model.Account;
import com.company.model.AccountRequestResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="accountNumber" type="{http://com/xsdSchemas/types}accountNumber"/&gt;
 *         &lt;element name="requestDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="sectionOrdinate" type="{http://com/xsdSchemas/types}ordinate2"/&gt;
 *         &lt;element name="previousBalance" type="{http://com/xsdSchemas/types}dec15_2"/&gt;
 *         &lt;element name="numberOfChangesProfit" type="{http://com/xsdSchemas/types}num6"/&gt;
 *         &lt;element name="totalProfit" type="{http://com/xsdSchemas/types}dec15_2"/&gt;
 *         &lt;element name="numberOfChangesDue" type="{http://com/xsdSchemas/types}num6"/&gt;
 *         &lt;element name="totalDue" type="{http://com/xsdSchemas/types}dec15_2"/&gt;
 *         &lt;element name="currentBalance" type="{http://com/xsdSchemas/types}dec15_2"/&gt;
 *         &lt;element name="accountStatementSectionItems" type="{http://com/xsdSchemas/accountStatementSectionItem}accountStatementSectionItem" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "accountNumber",
    "requestDate",
    "sectionOrdinate",
    "previousBalance",
    "numberOfChangesProfit",
    "totalProfit",
    "numberOfChangesDue",
    "totalDue",
    "currentBalance",
    "accountStatementSectionItems"
})
@XmlRootElement(name = "accountStatementSectionResponse")
@Entity
public class AccountStatementSectionResponse {
	
	public AccountStatementSectionResponse() {	}
	
	@Id
	@GeneratedValue
	@XmlTransient
	private Long id;
	
	@Column(nullable = false)
	@Size(min=1, max=50)
    @XmlElement(required = true)
    protected String accountNumber;
    
	@Transient
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar requestDate;
    
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(nullable=false)
	@XmlTransient
	private Date requestDateDate;
	
	@Column(nullable = false)
	@XmlElement(required = true)
    @Min(0)
	@Max(999)
	protected short sectionOrdinate;
    
	@Column(nullable = false)
	@XmlElement(required = true)
    protected BigDecimal previousBalance;
    
	@Column(nullable = false)
    @XmlElement(required = true)
    protected BigInteger numberOfChangesProfit;
    
	@Column(nullable = false)
    @XmlElement(required = true)
    protected BigDecimal totalProfit;
    
	@Column(nullable = false)
    @XmlElement(required = true)
    protected BigInteger numberOfChangesDue;
    
	@Column(nullable = false)
    @XmlElement(required = true)
    protected BigDecimal totalDue;
    
	@Column(nullable = false)
    @XmlElement(required = true)
    protected BigDecimal currentBalance;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="accountStatementSectionResponse", orphanRemoval=true, targetEntity=AccountStatementSectionItem.class)
    @JsonIgnore
	@XmlElement(required = true)
    protected List<AccountStatementSectionItem> accountStatementSectionItems;
	
	@XmlTransient
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="accountStatementSectionResponse", orphanRemoval=true, targetEntity=AccountRequestResponse.class)
	private Set<AccountRequestResponse> responses;
	
	/**
     * Gets the value of the accountNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets the value of the accountNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountNumber(String value) {
        this.accountNumber = value;
    }

    /**
     * Gets the value of the requestDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRequestDate() {
        return requestDate;
    }

    /**
     * Sets the value of the requestDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRequestDate(XMLGregorianCalendar value) {
        this.requestDate = value;
    }

    /**
     * Gets the value of the sectionOrdinate property.
     * 
     */
    public short getSectionOrdinate() {
        return sectionOrdinate;
    }

    /**
     * Sets the value of the sectionOrdinate property.
     * 
     */
    public void setSectionOrdinate(short value) {
        this.sectionOrdinate = value;
    }

    /**
     * Gets the value of the previousBalance property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPreviousBalance() {
        return previousBalance;
    }

    /**
     * Sets the value of the previousBalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPreviousBalance(BigDecimal value) {
        this.previousBalance = value;
    }

    /**
     * Gets the value of the numberOfChangesProfit property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumberOfChangesProfit() {
        return numberOfChangesProfit;
    }

    /**
     * Sets the value of the numberOfChangesProfit property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumberOfChangesProfit(BigInteger value) {
        this.numberOfChangesProfit = value;
    }

    /**
     * Gets the value of the totalProfit property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalProfit() {
        return totalProfit;
    }

    /**
     * Sets the value of the totalProfit property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalProfit(BigDecimal value) {
        this.totalProfit = value;
    }

    /**
     * Gets the value of the numberOfChangesDue property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumberOfChangesDue() {
        return numberOfChangesDue;
    }

    /**
     * Sets the value of the numberOfChangesDue property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumberOfChangesDue(BigInteger value) {
        this.numberOfChangesDue = value;
    }

    /**
     * Gets the value of the totalDue property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalDue() {
        return totalDue;
    }

    /**
     * Sets the value of the totalDue property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalDue(BigDecimal value) {
        this.totalDue = value;
    }

    /**
     * Gets the value of the currentBalance property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    /**
     * Sets the value of the currentBalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCurrentBalance(BigDecimal value) {
        this.currentBalance = value;
    }

    /**
     * Gets the value of the accountStatementSectionItems property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the accountStatementSectionItems property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccountStatementSectionItems().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AccountStatementSectionItem }
     * 
     * 
     */
    public List<AccountStatementSectionItem> getAccountStatementSectionItems() {
        if (accountStatementSectionItems == null) {
            accountStatementSectionItems = new ArrayList<AccountStatementSectionItem>();
        }
        return this.accountStatementSectionItems;
    }
    
    public Date getRequestDateDate() {
		return requestDateDate;
	}

	public void setRequestDateDate(Date requestDateDate) {
		this.requestDateDate = requestDateDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
