package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.model.InvoiceItem;


public interface InvoiceItemRepository extends JpaRepository<InvoiceItem, Long> {

}
