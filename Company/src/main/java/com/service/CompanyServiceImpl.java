package com.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.model.Company;
import com.repository.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	@Override
	public ArrayList<Company> getAll() {
		// TODO Auto-generated method stub
		return (ArrayList<Company>) companyRepository.findAll();
	}
	
	
}
