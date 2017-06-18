package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

}
