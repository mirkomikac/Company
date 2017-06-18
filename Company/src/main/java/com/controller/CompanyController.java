package com.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.model.Company;
import com.service.CompanyServiceImpl;

@RequestMapping("/companies")
@RestController
public class CompanyController {

	@Autowired
	private CompanyServiceImpl companyServiceImpl;
	
	@RequestMapping(path="/getAllCompanies", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ArrayList<Company> getAll(){
		ArrayList<Company> c = companyServiceImpl.getAll();
		return c;
	}
	
}
