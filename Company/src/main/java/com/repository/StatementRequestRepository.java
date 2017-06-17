package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.wsdl.StatementRequest;

public interface StatementRequestRepository extends JpaRepository<StatementRequest, Long>{

}
