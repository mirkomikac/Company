package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.model.Bank;

public interface BankRepository extends JpaRepository<Bank, Long>{

}
