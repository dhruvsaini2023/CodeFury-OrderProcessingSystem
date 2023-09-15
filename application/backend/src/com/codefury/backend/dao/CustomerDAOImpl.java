package com.codefury.backend.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.codefury.backend.domain.Customer;


public class CustomerDAOImpl implements CustomerDAO {

	// Method for searching and displaying all records
	@Override
	public List<Customer> search() throws SQLException {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost/codefury";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet res = null;

		con = DriverManager.getConnection(url, "root", "root");
		String query = "Select *from customer";
		stmt = con.prepareStatement(query);
		res = stmt.executeQuery();
		List<Customer> result = new ArrayList<>();
		while (res.next()) {
			Customer customer = new Customer(res.getInt("id"), res.getString("name"), res.getString("gstNo"),
					res.getString("address"), res.getString("city"), res.getString("email"), res.getString("phone"),
					res.getString("pincode"), res.getString("password"));
			result.add(customer);
		}
		stmt.close();
		con.close();
		return result;
	}

	// Method for searching base on CustomerID
	@Override
	public Customer search(int id) throws SQLException {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost/codefury";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet res = null;

		con = DriverManager.getConnection(url, "root", "root");
		String query = "Select * from customer where id=?";
		stmt = con.prepareStatement(query);
		stmt.setInt(1, id);
		res = stmt.executeQuery();
		Customer customer = null;
		if (res.next()) {
			customer = new Customer(res.getInt("id"), res.getString("name"), res.getString("gstNo"),
					res.getString("address"), res.getString("city"), res.getString("email"), res.getString("phone"),
					res.getString("pincode"), res.getString("password"));
		}

		stmt.close();
		con.close();
		return customer;
	}

	// Method for searching customer based on name
	@Override
	public Customer search(String name) throws SQLException {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost/codefury";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet res = null;

		con = DriverManager.getConnection(url, "root", "root");
		String query = "Select * from customer where name=?";
		stmt = con.prepareStatement(query);
		stmt.setString(1, name);
		res = stmt.executeQuery();
		Customer customer = null;
		if (res.next()) {
			customer = new Customer(res.getInt("id"), res.getString("name"), res.getString("gstNo"),
					res.getString("address"), res.getString("city"), res.getString("email"), res.getString("phone"),
					res.getString("pincode"), res.getString("password"));
		}
		stmt.close();
		con.close();
		return customer;
	}

}
