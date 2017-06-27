package com.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.company.xsdschemas.invoiceitem.InvoiceItem;



public interface InvoiceItemRepository extends JpaRepository<InvoiceItem, Long> {
	
	@Query("select inv from InvoiceItem as inv where inv.invoice.id = ?1")
	ArrayList<InvoiceItem> getInvoiceItemsByInvoiceId(Long id);
}
