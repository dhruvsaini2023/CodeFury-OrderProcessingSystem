package com.codefury.backend.service;

import java.util.Set;

import com.codefury.backend.domain.Products;

public interface ProductService {
	// Method Declaration
	public void searchAll();
	public void searchById(int id);

	public void insert(Set<Products> products);
	public void updateProduct(int id, Products product);
	
}
