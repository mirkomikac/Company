package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.xsdschemas.invoiceitem.InvoiceItem;



public interface InvoiceItemRepository extends JpaRepository<InvoiceItem, Long> {

}
