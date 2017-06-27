package com.controller;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.xsdschemas.invoice.InvoiceRequest;
import com.company.xsdschemas.invoiceitem.InvoiceItem;
import com.service.InvoiceItemServiceImpl;
import com.service.InvoiceServiceImpl;


@RequestMapping("/invoices")
@RestController
public class InvoiceController {

	@Autowired
	private InvoiceServiceImpl invoiceServiceImpl;
	
	@Autowired
	private InvoiceItemServiceImpl invoiceItemServiceImpl;
	
	@RequestMapping(path="/getAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ArrayList<InvoiceRequest> getAllInvoices(){
		ArrayList<InvoiceRequest> i = invoiceServiceImpl.getAll();
		return i;
	}
	
	@RequestMapping(path="/addInvoice", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public InvoiceRequest addInvoice(@RequestBody InvoiceRequest invoice){
		
		
		
		invoice.setPurchaserAdress(invoice.getPurchaser().getAddress());
		invoice.setPurchaserName(invoice.getPurchaser().getName());
		invoice.setPurchaserPib(invoice.getPurchaser().getPib());
		
		invoice.setSupplierAddress(invoice.getSupplier().getAddress());
		invoice.setSupplierName(invoice.getSupplier().getName());
		invoice.setSupplierPib(invoice.getSupplier().getPib());
		
		invoice.setAccountNumber(invoice.getAccount().getAccountNumber());
		
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(invoice.getBillingDateDate());
		
		XMLGregorianCalendar billingDateXml = null;
		try {
			billingDateXml = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		invoice.setBillingDate(billingDateXml);
		
		c.setTime(invoice.getCurrencyDateDate());
		
		XMLGregorianCalendar currencyDateXml = null;
		try {
			currencyDateXml = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		invoice.setCurrencyDate(currencyDateXml);
		
		ArrayList<InvoiceItem> invoiceItems = new ArrayList<>();
		invoiceItems.addAll(invoice.getInvoiceItems());
		invoice.setInvoiceItems(null);
		
		InvoiceRequest invoiceRet = invoiceServiceImpl.save(invoice);
		
		
		for(int i = 0;i < invoiceItems.size();i++){
			invoiceItems.get(i).setInvoice(invoiceRet);
			invoiceItemServiceImpl.save(invoiceItems.get(i));
		}
		return invoiceRet;
	}
	
}
