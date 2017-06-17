package com.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.model.AccountRequestResponse;

public interface AccountStatementRequestResponseRepository extends JpaRepository<AccountRequestResponse, Serializable>{

}
