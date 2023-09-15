package com.codefury.backend.dao;

import java.sql.SQLException;
import java.util.List;

import com.codefury.backend.domain.Customer;


public interface CustomerDAO {
	
	// Method declaration
   public List<Customer> search() throws SQLException;
   public Customer search(int id) throws SQLException;
   public Customer search(String name) throws SQLException;

}
