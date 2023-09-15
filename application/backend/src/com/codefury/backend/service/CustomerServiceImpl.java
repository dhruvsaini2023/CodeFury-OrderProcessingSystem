package com.codefury.backend.service;

import java.sql.SQLException;

import com.codefury.backend.dao.CustomerDAO;
import com.codefury.backend.dao.CustomerDAOImpl;
import com.codefury.backend.domain.Customer;
import com.codefury.backend.exceptions.CustomerDoesntExsistException;


public class CustomerServiceImpl implements CustomerService{
	private CustomerDAO customerDAO;
	
	// Constructor
	public CustomerServiceImpl() {
		// TODO Auto-generated constructor stub
		customerDAO=new CustomerDAOImpl();
	}

	// Method Implementation
	// Method for verifying login information 
	@Override
	public void login(String field, String value, String password) throws CustomerDoesntExsistException {
		// TODO Auto-generated method stub
		if(field=="name")
		{
			try {
				Customer c=customerDAO.search(value);
				if(c.getPassword().equals(password))
				{
					System.out.println("Order Management System");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new CustomerDoesntExsistException("User Not Found");
			}
			
		}
	}

	// Method for searching record using Customer ID
	@Override
	public void searchById(int id) {
		// TODO Auto-generated method stub
		Customer customer = null;
		try {
			customer = customerDAO.search(id);
			System.out.println(customer);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Method for searching record using Customer Name
	@Override
	public void searchByName(String name) {
		// TODO Auto-generated method stub		
		Customer customer = null;
		try {
			customer = customerDAO.search(name);
			System.out.println(customer);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
