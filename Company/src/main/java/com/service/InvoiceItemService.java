package com.service;

import java.util.ArrayList;

import com.company.xsdschemas.invoiceitem.InvoiceItem;


public interface InvoiceItemService {

	InvoiceItem save(InvoiceItem invoiceItem);
	
	ArrayList<InvoiceItem> getAll();
	
	ArrayList<InvoiceItem> getInvoiceItemsByInvoiceId(Long id);
}
