package com.codefury.backend.service;

import com.codefury.backend.dao.EmployeeDao;
import com.codefury.backend.dao.EmployeeDaoImpl;
import com.codefury.backend.domain.Employee;

public class EmployeeServiceImpl implements EmployeeService{
	private EmployeeDao ed;
	
	// Constructor
	public EmployeeServiceImpl() {
		ed = new EmployeeDaoImpl();
	}

	// Methods Implementation
	@Override
	// Creating Employee Table
	public void createEmployees() {
		ed.create();
	}
	@Override
	// Inserting Record in Employee
	public void insertEmployees(Employee e) {
		ed.insert(e);
	}

}
