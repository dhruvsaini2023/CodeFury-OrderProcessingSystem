package com.codefury.backend.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.codefury.backend.domain.Company;


public class CompanyDaoImpl implements CompanyDao{
	// Method Implementation
	public void create() {
		 // Database connection parameters
        String jdbcUrl = "jdbc:mysql://localhost/codefury"; // Replace with your database URL
        String username = "root";
        String password = "root";

        // SQL query to create the Company table
        String createTableSQL = "CREATE TABLE company (" +
                "companyId INT AUTO_INCREMENT PRIMARY KEY," +
                "companyName VARCHAR(255) NOT NULL," +
                "address VARCHAR(255)," +
                "city VARCHAR(25) NOT NULL," +
                "gstNumber VARCHAR(15) NOT NULL" +
                ")";

        try {
            // creating jdbc connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            Statement statement = connection.createStatement();
            statement.executeUpdate(createTableSQL);
            statement.close();
            connection.close();

            System.out.println("Company table created successfully!");

        } catch (SQLException e) {
            System.err.println("SQL Error:");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insert(Company c) {
		 // Database connection parameters
		String url="jdbc:mysql://localhost/codefury";
		Connection con=null;
		PreparedStatement stmt=null;
		
		try {
			con= DriverManager.getConnection(url,"root","root");
			String query="insert into company(companyName,address,city,gstNumber) values(?,?,?,?)";
			stmt= con.prepareStatement(query);
			stmt.setString(1,c.getCompanyName());
			stmt.setString(2,c.getAddress());
			stmt.setString(3,c.getCity());
			stmt.setString(4,c.getGstNumber());
			int n= stmt.executeUpdate();
			System.out.println(n+ " Company(s) inserted");
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
