package com.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.model.Invoice;
import com.company.model.InvoiceItem;
import com.repository.InvoiceItemRepository;

@Service
public class InvoiceItemServiceImpl implements InvoiceItemService{

	@Autowired
	private InvoiceItemRepository invoiceItemRepository;

	@Override
	public InvoiceItem save(InvoiceItem invoiceItem) {
		// TODO Auto-generated method stub
		return invoiceItemRepository.saveAndFlush(invoiceItem);
	}

	@Override
	public ArrayList<InvoiceItem> getAll() {
		// TODO Auto-generated method stub
		return (ArrayList<InvoiceItem>) invoiceItemRepository.findAll();
	}


	
}
