package com.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.xsdschemas.invoiceitem.InvoiceItem;
import com.service.InvoiceItemServiceImpl;


@RequestMapping("/invoiceItems")
@RestController
public class InvoiceItemController {

	@Autowired
	private InvoiceItemServiceImpl invoiceItemServiceImpl;
	
	@RequestMapping(path="/getAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ArrayList<InvoiceItem> getAllInvoices(){
		ArrayList<InvoiceItem> i = invoiceItemServiceImpl.getAll();
		return i;
	}
	
	@RequestMapping(path="/getByInvoiceId", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ArrayList<InvoiceItem> getInvoiceItemsByInvoiceId(@RequestBody Long id){
		ArrayList<InvoiceItem> i = invoiceItemServiceImpl.getInvoiceItemsByInvoiceId(id);
		return i;
	}
	
}
