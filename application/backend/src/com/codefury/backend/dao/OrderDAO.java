package com.codefury.backend.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.codefury.backend.domain.Order;
import com.codefury.backend.exceptions.OrderDoesNotExistException;

public class OrderDAO {
	
	// Methods
	// Displaying All records
	public void viewAll() {
		// TODO Auto-generated method stub
		
		String url = "jdbc:mysql://localhost/codefury";
	
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = DriverManager.getConnection(url, "root", "root");
			
			String query = "select * from orders;";
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				System.out.println(resultSet.getString("orderId") + " : " +
						resultSet.getDate("orderDate") + " : " +
						resultSet.getString("customerId") + " : " +
						resultSet.getString("customerShoppingAddress") + " : " +
						resultSet.getString("listOfProducts") + " : " +
						resultSet.getDouble("totalOrderValue") + " : " +
						resultSet.getDouble("shippingCost") + " : " +
						resultSet.getString("shippingAgency") + " : " +
						resultSet.getString("orderStatus")
						);
			}
			
			resultSet.close();
			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	// Search by order ID
	public Boolean findById(String orderId) throws OrderDoesNotExistException{
		String url = "jdbc:mysql://localhost/codefury";
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = DriverManager.getConnection(url, "root", "root");
			
			String query = "Select * from orders where orderId=?;";
			statement = connection.prepareStatement(query);
			statement.setString(1, orderId);
			resultSet = statement.executeQuery();
		
			while(resultSet.next()) {
				System.out.println(resultSet.getString("orderId") + " : " +
						resultSet.getDate("orderDate") + " : " +
						resultSet.getString("customerId") + " : " +
						resultSet.getString("customerShoppingAddress") + " : " +
						resultSet.getString("listOfProducts") + " : " +
						resultSet.getDouble("totalOrderValue") + " : " +
						resultSet.getDouble("shippingCost") + " : " +
						resultSet.getString("shippingAgency") + " : " +
						resultSet.getString("orderStatus")
						);
			}
			
			resultSet.close();
			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return true;
	}

	// Deleting order 
	public void deleteRecords(String orderId) {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost/codefury";
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = DriverManager.getConnection(url, "root", "root");
			String query = "delete from orders where orderId=?;";
			statement = connection.prepareStatement(query);
			
			statement.setString(1, orderId);
			
			int n = statement.executeUpdate();
			System.out.println(n + " Order(s) deleted");
			
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	// Creating new order record
	public void insertOrder(Order order) {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost/codefury";
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = DriverManager.getConnection(url, "root", "root");
			String query = "insert into orders values(?,?,?,?,?,?,?,?,?)";
			statement = connection.prepareStatement(query);
			
			statement.setString(1, order.getOrderId());
			statement.setDate(2, Date.valueOf(order.getOrderDate()));
			statement.setString(3, order.getCustomerId());
			statement.setString(4, order.getCustomerShoppingAddress());
			statement.setString(5, order.getListOfProducts());
			statement.setDouble(6, order.getTotalOrderValue());
			statement.setDouble(7, order.getShippingCost());
			statement.setString(8, order.getShippingAgency());
			statement.setString(9, order.getOrderStatus());
			
			int n = statement.executeUpdate();
			System.out.println(n + " Order(s) inserted");
			
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	// Updating Order status
	public void updateStatus(String orderID, String orderStatus) throws OrderDoesNotExistException {
		String url = "jdbc:mysql://localhost/codefury";
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = DriverManager.getConnection(url, "root", "root");
			String query = "update orders set orderStatus=? where orderId=?;";
			statement = connection.prepareStatement(query);

			statement.setString(1, orderStatus);
			statement.setString(2, orderID);
			
			int n = statement.executeUpdate();
			if(n == 0) {
				throw new OrderDoesNotExistException();
			}
			System.out.println(n + " Order(s) updated");
			
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}		
	
	
}
