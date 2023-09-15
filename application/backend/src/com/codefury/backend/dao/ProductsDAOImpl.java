package com.codefury.backend.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.codefury.backend.domain.Products;


public class ProductsDAOImpl implements ProductsDAO {

	// Method for searching all records
	@Override
	public List<Products> search() throws SQLException {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost/codefury";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet res = null;

		con = DriverManager.getConnection(url, "root", "root");
		String query = "Select *from product";
		stmt = con.prepareStatement(query);
		res = stmt.executeQuery();
		List<Products> result = new ArrayList<>();
		while (res.next()) {
			Products product = new Products(res.getInt("id"), res.getString("name"), res.getDouble("price"),
					res.getString("category"));
			result.add(product);
		}
		res.close();
		stmt.close();
		con.close();
		return result;
	}

	// Method for searching record using ProductID
	// Method for S records
	@Override
	public Products search(int id) throws SQLException {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost/codefury";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet res = null;
		con = DriverManager.getConnection(url, "root", "root");
		String query = "Select *from product where id=?";
		stmt = con.prepareStatement(query);
		stmt.setInt(1, id);
		res = stmt.executeQuery();
		if (res.next()) {
			Products product = new Products(res.getInt("id"), res.getString("name"), res.getDouble("price"),
					res.getString("category"));
			res.close();
			stmt.close();
			con.close();
			return product;
		}
		res.close();
		stmt.close();
		con.close();
		return null;
	}

	// Method for saving records in database
	// Method for Saving records
	@Override
	public void save(Set<Products> products) throws SQLException {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost/codefury";
		Connection con = null;
		PreparedStatement stmt = null;
		con = DriverManager.getConnection(url, "root", "root");
		String query = "Insert into product values(?,?,?,?)";
		for (Products products2 : products) {
			stmt = con.prepareStatement(query);
			stmt.setInt(1, products2.getId());
			stmt.setString(2, products2.getName());
			stmt.setDouble(3, products2.getPrice());
			stmt.setString(4, products2.getCategory());
			stmt.executeUpdate();
		}

		stmt.close();
		con.close();
	}
	// Method for updating records

	// Method for updating records
	@Override
	public void update(int id, Products product) throws SQLException {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost/codefury";
		Connection con = null;
		PreparedStatement stmt = null;

		con = DriverManager.getConnection(url, "root", "root");
		String query = "Update product set name=?, price=?, category=? where id=?";
		stmt = con.prepareStatement(query);

		stmt.setString(1, product.getName());
		stmt.setDouble(2, product.getPrice());
		stmt.setString(3, product.getCategory());
		int n = stmt.executeUpdate();

		System.out.println(n + " Record(s) updated");
		stmt.close();
		con.close();

	}

}
