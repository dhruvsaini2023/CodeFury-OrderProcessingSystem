package com.codefury.backend.service;

import com.codefury.backend.dao.CompanyDao;
import com.codefury.backend.dao.CompanyDaoImpl;
import com.codefury.backend.domain.Company;

public class CompanyServiceImpl implements CompanyService{
	private CompanyDao cd;
	
	// Constructor
	public CompanyServiceImpl() {
		cd = new CompanyDaoImpl();
	}

	// Methods Implementation
	@Override
	// Creating Company table in case it is not present
	public void createCompany() {
		cd.create();
		
	}
	@Override
	// Adding company details in our database
	public void insertCompany(Company c) {
		// TODO Auto-generated method stub
		cd.insert(c);
	}
	
}
