package com.service;

import java.util.ArrayList;

import com.company.model.Invoice;

public interface InvoiceService {

	Invoice save(Invoice invoice);
	
	ArrayList<Invoice> getAll();
	
}
