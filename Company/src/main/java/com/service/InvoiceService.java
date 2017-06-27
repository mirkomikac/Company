package com.service;

import java.util.ArrayList;

import com.company.xsdschemas.invoice.InvoiceRequest;


public interface InvoiceService {

	InvoiceRequest save(InvoiceRequest invoice);
	
	ArrayList<InvoiceRequest> getAll();
	
}
