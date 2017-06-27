package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.xsdschemas.invoice.InvoiceRequest;

public interface InvoiceRepository extends JpaRepository<InvoiceRequest, Long> {

}
