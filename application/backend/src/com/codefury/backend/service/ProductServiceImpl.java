package com.codefury.backend.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import com.codefury.backend.dao.ProductsDAO;
import com.codefury.backend.dao.ProductsDAOImpl;
import com.codefury.backend.domain.Products;

public class ProductServiceImpl implements ProductService{
	private ProductsDAO productDAO;
	
	// Constructor
	public ProductServiceImpl() {
		this.productDAO = new ProductsDAOImpl();
	}
	
	@Override
	public void searchAll() {
		// TODO Auto-generated method stub
		try {
			List<Products> products = this.productDAO.search();
			for (Products product : products) {
				System.out.println(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void searchById(int id) {
		// TODO Auto-generated method stub
		try {
			Products product = this.productDAO.search(id);
			System.out.println(product);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void insert(Set<Products> products) {
		// TODO Auto-generated method stub
		try {
			this.productDAO.save(products);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateProduct(int id, Products product) {
		// TODO Auto-generated method stub
		try {
			this.productDAO.update(id, product);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
