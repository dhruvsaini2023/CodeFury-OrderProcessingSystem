package com.codefury.backend.service;

import com.codefury.backend.exceptions.CustomerDoesntExsistException;

public interface CustomerService {
	
	// Method Declaration
    public void login(String field,String value,String password)throws CustomerDoesntExsistException;
    public void searchById(int id);
    public void searchByName(String name);
    
}
