package com.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.xsdschemas.invoice.InvoiceRequest;
import com.repository.InvoiceRepository;

@Service
public class InvoiceServiceImpl implements InvoiceService {
	
	@Autowired
	private InvoiceRepository invoiceRepository;

	@Override
	public InvoiceRequest save(InvoiceRequest invoice) {
		// TODO Auto-generated method stub
		return invoiceRepository.save(invoice);
	}

	@Override
	public ArrayList<InvoiceRequest> getAll() {
		// TODO Auto-generated method stub
		return (ArrayList<InvoiceRequest>) invoiceRepository.findAll();
	}
	
	

}
