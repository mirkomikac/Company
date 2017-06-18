package com.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.model.Invoice;
import com.repository.InvoiceRepository;

@Service
public class InvoiceServiceImpl implements InvoiceService {
	
	@Autowired
	private InvoiceRepository invoiceRepository;

	@Override
	public Invoice save(Invoice invoice) {
		// TODO Auto-generated method stub
		return invoiceRepository.save(invoice);
	}

	@Override
	public ArrayList<Invoice> getAll() {
		// TODO Auto-generated method stub
		return (ArrayList<Invoice>) invoiceRepository.findAll();
	}
	
	

}
