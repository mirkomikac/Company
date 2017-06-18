package com.service;

import java.util.ArrayList;

import com.company.model.InvoiceItem;

public interface InvoiceItemService {

	InvoiceItem save(InvoiceItem invoiceItem);
	
	ArrayList<InvoiceItem> getAll();
}
