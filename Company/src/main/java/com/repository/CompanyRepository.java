package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long>{

}
