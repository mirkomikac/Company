//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.06.14 at 11:37:44 PM CEST 
//


package com.company.wsdl;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="messageId" type="{http://com/xsdSchemas/types}str50num"/&gt;
 *         &lt;element name="originator" type="{http://com/xsdSchemas/types}str255"/&gt;
 *         &lt;element name="paymentPurpose" type="{http://com/xsdSchemas/types}str255"/&gt;
 *         &lt;element name="reciever" type="{http://com/xsdSchemas/types}str255"/&gt;
 *         &lt;element name="statementDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="currencyDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="originatorAccountNumber" type="{http://com/xsdSchemas/types}accountNumber"/&gt;
 *         &lt;element name="chargeModel" type="{http://com/xsdSchemas/types}ordinate2"/&gt;
 *         &lt;element name="chargeDialNumber" type="{http://com/xsdSchemas/types}str20num"/&gt;
 *         &lt;element name="recieverAccountNumber" type="{http://com/xsdSchemas/types}accountNumber"/&gt;
 *         &lt;element name="clearanceModel" type="{http://com/xsdSchemas/types}ordinate2"/&gt;
 *         &lt;element name="clearanceDialNumber" type="{http://com/xsdSchemas/types}str20num"/&gt;
 *         &lt;element name="amount" type="{http://com/xsdSchemas/types}dec15_2"/&gt;
 *         &lt;element name="currency" type="{http://com/xsdSchemas/types}str3currency"/&gt;
 *         &lt;element name="emergency" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
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
    "messageId",
    "originator",
    "paymentPurpose",
    "reciever",
    "statementDate",
    "currencyDate",
    "originatorAccountNumber",
    "chargeModel",
    "chargeDialNumber",
    "recieverAccountNumber",
    "clearanceModel",
    "clearanceDialNumber",
    "amount",
    "currency",
    "emergency",
    "placeOfAcceptance"
})
@XmlRootElement(name = "statementRequest", namespace = "http://com/xsdSchemas/statement")
public class StatementRequest {

    @XmlElement(namespace = "http://com/xsdSchemas/statement", required = true)
    protected String messageId;
    @XmlElement(namespace = "http://com/xsdSchemas/statement", required = true)
    protected String originator;
    @XmlElement(namespace = "http://com/xsdSchemas/statement", required = true)
    protected String paymentPurpose;
    @XmlElement(namespace = "http://com/xsdSchemas/statement", required = true)
    protected String reciever;
    @XmlElement(namespace = "http://com/xsdSchemas/statement", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar statementDate;
    @XmlElement(namespace = "http://com/xsdSchemas/statement", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar currencyDate;
    @XmlElement(namespace = "http://com/xsdSchemas/statement", required = true)
    protected String originatorAccountNumber;
    @XmlElement(namespace = "http://com/xsdSchemas/statement")
    protected short chargeModel;
    @XmlElement(namespace = "http://com/xsdSchemas/statement", required = true)
    protected String chargeDialNumber;
    @XmlElement(namespace = "http://com/xsdSchemas/statement", required = true)
    protected String recieverAccountNumber;
    @XmlElement(namespace = "http://com/xsdSchemas/statement")
    protected short clearanceModel;
    @XmlElement(namespace = "http://com/xsdSchemas/statement", required = true)
    protected String clearanceDialNumber;
    @XmlElement(namespace = "http://com/xsdSchemas/statement", required = true)
    protected BigDecimal amount;
    @XmlElement(namespace = "http://com/xsdSchemas/statement", required = true)
    protected String currency;
    @XmlElement(namespace = "http://com/xsdSchemas/statement")
    protected boolean emergency;
    @XmlElement(namespace = "http://com/xsdSchemas/statement")
    protected String placeOfAcceptance;

    /**
     * Gets the value of the messageId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * Sets the value of the messageId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageId(String value) {
        this.messageId = value;
    }

    /**
     * Gets the value of the originator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginator() {
        return originator;
    }

    /**
     * Sets the value of the originator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginator(String value) {
        this.originator = value;
    }

    /**
     * Gets the value of the paymentPurpose property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentPurpose() {
        return paymentPurpose;
    }

    /**
     * Sets the value of the paymentPurpose property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentPurpose(String value) {
        this.paymentPurpose = value;
    }

    /**
     * Gets the value of the reciever property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReciever() {
        return reciever;
    }

    /**
     * Sets the value of the reciever property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReciever(String value) {
        this.reciever = value;
    }

    /**
     * Gets the value of the statementDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStatementDate() {
        return statementDate;
    }

    /**
     * Sets the value of the statementDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStatementDate(XMLGregorianCalendar value) {
        this.statementDate = value;
    }

    /**
     * Gets the value of the currencyDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCurrencyDate() {
        return currencyDate;
    }

    /**
     * Sets the value of the currencyDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCurrencyDate(XMLGregorianCalendar value) {
        this.currencyDate = value;
    }

    /**
     * Gets the value of the originatorAccountNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginatorAccountNumber() {
        return originatorAccountNumber;
    }

    /**
     * Sets the value of the originatorAccountNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginatorAccountNumber(String value) {
        this.originatorAccountNumber = value;
    }

    /**
     * Gets the value of the chargeModel property.
     * 
     */
    public short getChargeModel() {
        return chargeModel;
    }

    /**
     * Sets the value of the chargeModel property.
     * 
     */
    public void setChargeModel(short value) {
        this.chargeModel = value;
    }

    /**
     * Gets the value of the chargeDialNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChargeDialNumber() {
        return chargeDialNumber;
    }

    /**
     * Sets the value of the chargeDialNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChargeDialNumber(String value) {
        this.chargeDialNumber = value;
    }

    /**
     * Gets the value of the recieverAccountNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecieverAccountNumber() {
        return recieverAccountNumber;
    }

    /**
     * Sets the value of the recieverAccountNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecieverAccountNumber(String value) {
        this.recieverAccountNumber = value;
    }

    /**
     * Gets the value of the clearanceModel property.
     * 
     */
    public short getClearanceModel() {
        return clearanceModel;
    }

    /**
     * Sets the value of the clearanceModel property.
     * 
     */
    public void setClearanceModel(short value) {
        this.clearanceModel = value;
    }

    /**
     * Gets the value of the clearanceDialNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClearanceDialNumber() {
        return clearanceDialNumber;
    }

    /**
     * Sets the value of the clearanceDialNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClearanceDialNumber(String value) {
        this.clearanceDialNumber = value;
    }

    /**
     * Gets the value of the amount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmount(BigDecimal value) {
        this.amount = value;
    }

    /**
     * Gets the value of the currency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrency(String value) {
        this.currency = value;
    }

    /**
     * Gets the value of the emergency property.
     * 
     */
    public boolean isEmergency() {
        return emergency;
    }

    /**
     * Sets the value of the emergency property.
     * 
     */
    public void setEmergency(boolean value) {
        this.emergency = value;
    }

	public String getPlaceOfAcceptance() {
		return placeOfAcceptance;
	}

	public void setPlaceOfAcceptance(String placeOfAcceptance) {
		this.placeOfAcceptance = placeOfAcceptance;
	}

}
