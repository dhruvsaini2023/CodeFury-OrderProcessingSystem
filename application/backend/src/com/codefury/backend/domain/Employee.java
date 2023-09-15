package com.codefury.backend.domain;

import java.util.Objects;

public class Employee {
	
	//private attributes
	private int employeeId;
	private String username;
	private String password;
	
	//getters and setters for private attributes
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	//equals and hashcode method using id attribute
	@Override
	public int hashCode() {
		return Objects.hash(employeeId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return employeeId == other.employeeId;
	}
	
	//toString method
	@Override
	public String toString() {
		return "Employee [id=" + employeeId + ", username=" + username + ", password=" + password + "]";
	}
	
	
}
