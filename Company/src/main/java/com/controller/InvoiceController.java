package com.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.model.Invoice;
import com.service.InvoiceServiceImpl;

@RequestMapping("/invoices")
@RestController
public class InvoiceController {

	@Autowired
	private InvoiceServiceImpl invoiceServiceImpl;
	
	@RequestMapping(path="/getAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ArrayList<Invoice> getAllInvoices(){
		ArrayList<Invoice> i = invoiceServiceImpl.getAll();
		return i;
	}
	
	@RequestMapping(path="/addInvoice", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Invoice addInvoice(@RequestBody Invoice invoice){
		invoiceServiceImpl.save(invoice);
		return invoice;
	}
	
}
