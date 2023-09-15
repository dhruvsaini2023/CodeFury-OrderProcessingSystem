package com.codefury.backend.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.codefury.backend.domain.Invoice;

public class InvoiceDAO {

	// Displaying All records
	public void viewAll() {
		// TODO Auto-generated method stub

		String url = "jdbc:mysql://localhost/codefury";

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DriverManager.getConnection(url, "root", "root");

			String query = "select * from invoice;";
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				System.out.println(resultSet.getString("invoiceID") + " : " + resultSet.getDate("invoicedate") + " : "
						+ resultSet.getString("orderDetails") + " : " + resultSet.getString("customerDetails") + " : "
						+ resultSet.getString("productList") + " : " + resultSet.getString("typeOfGST") + " : "
						+ resultSet.getDouble("totalGSTAmount") + " : " + resultSet.getDouble("totalInvoiceValue")
						+ " : " + resultSet.getString("statusOfInvoice"));
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
	public Boolean findById(String invoiceID) {
		String url = "jdbc:mysql://localhost/codefury";

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DriverManager.getConnection(url, "root", "root");

			String query = "Select * from invoice where invoiceID=?;";
			statement = connection.prepareStatement(query);
			statement.setString(1, invoiceID);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				System.out.println(resultSet.getString("invoiceID") + " : " + resultSet.getDate("invoicedate") + " : "
						+ resultSet.getString("orderDetails") + " : " + resultSet.getString("customerDetails") + " : "
						+ resultSet.getString("productList") + " : " + resultSet.getString("typeOfGST") + " : "
						+ resultSet.getDouble("totalGSTAmount") + " : " + resultSet.getDouble("totalInvoiceValue")
						+ " : " + resultSet.getString("statusOfInvoice"));
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
	public void deleteRecords(String invoiceID) {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost/codefury";
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = DriverManager.getConnection(url, "root", "root");
			String query = "delete from invoice where invoiceID=?;";
			statement = connection.prepareStatement(query);

			statement.setString(1, invoiceID);

			int n = statement.executeUpdate();
			System.out.println(n + " invoice(s) deleted");

			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Creating new order record
	public void insertOrder(Invoice invoice) {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost/codefury";
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = DriverManager.getConnection(url, "root", "root");
			String query = "insert into invoice values(?,?,?,?,?,?,?,?,?)";
			statement = connection.prepareStatement(query);

			statement.setString(1, invoice.getInvoiceID());
			statement.setDate(2, Date.valueOf(invoice.getInvoicedate()));
			statement.setString(3, invoice.getOrderDetails());
			statement.setString(4, invoice.getCustomerDetails());
			statement.setString(5, invoice.getProductList());
			statement.setString(6, invoice.getTypeOfGST());
			statement.setDouble(7, invoice.getTotalGSTAmount());
			statement.setDouble(8, invoice.getTotalInvoiceValue());
			statement.setString(9, invoice.getStatusOfInvoice());

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
	public void updateStatus(String invoiceId, String invoiceStatus) {
		String url = "jdbc:mysql://localhost/codefury";
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = DriverManager.getConnection(url, "root", "root");
			String query = "update invoice set statusOfInvoice=? where invoiceID=?;";
			statement = connection.prepareStatement(query);

			statement.setString(1, invoiceStatus);
			statement.setString(2, invoiceId);

			int n = statement.executeUpdate();
			System.out.println(n + " Invoice(s) updated");

			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
