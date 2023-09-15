package com.codefury.backend.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import com.codefury.backend.domain.Products;


public interface ProductsDAO {
	// Method declaration
	public List<Products> search() throws SQLException;

	public Products search(int id) throws SQLException;

	public void save(Set<Products> products) throws SQLException;

	public void update(int id, Products product) throws SQLException;
}
