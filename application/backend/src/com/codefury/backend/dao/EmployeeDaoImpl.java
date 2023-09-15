package com.codefury.backend.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.codefury.backend.domain.Employee;


public class EmployeeDaoImpl implements EmployeeDao{

	// Method Implementation
	
	//method to create company employees table
	public void create() {
		 // Database connection parameters
        String jdbcUrl = "jdbc:mysql://localhost:3306/codefury"; // Replace with your database URL
        String username = "root";
        String password = "root";

        // SQL query to create the Company table
        String createTableSQL = "CREATE TABLE employees (" +
                "employeeId INT AUTO_INCREMENT PRIMARY KEY," +
                "userName VARCHAR(255) NOT NULL," +
                "password VARCHAR(255) NOT NULL" +
                ")";

        try {
            // creating jdbc connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            Statement statement = connection.createStatement();
            statement.executeUpdate(createTableSQL);
            statement.close();
            connection.close();

            System.out.println("employees table created successfully!");

        } catch (ClassNotFoundException e) {
            System.err.println("Error: MySQL JDBC driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("SQL Error:");
            e.printStackTrace();
        }
	}
	
	//method to insert data into employees table
	public void insert(Employee emp) {
		 // Database connection parameters
		String url="jdbc:mysql://localhost/codefury";
		Connection con=null;
		PreparedStatement stmt=null;
		
		try {
			con= DriverManager.getConnection(url,"root","root");
			String query="insert into employees(employeeId,userName,password) values(?,?,?)";
			stmt= con.prepareStatement(query);
			stmt.setInt(1,emp.getEmployeeId());
			stmt.setString(2,emp.getUsername());
			stmt.setString(3,emp.getPassword());
			int n= stmt.executeUpdate();
			System.out.println(n+ " Employee(s) inserted");
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
