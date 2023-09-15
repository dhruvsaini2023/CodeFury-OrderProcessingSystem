package com.codefury.backend.domain;

import java.util.Objects;

public class Customer {
	
	private int customerId;
	private String name;
	private String gstNumber;
	private String address;
	private String city;
	private String email;
	private String phone;
	private String pincode;
	private String password;
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(int customerId, String name, String gstNumber, String address, String city, String email,
			String phone, String pincode,String password) {
		//super();
		this.customerId = customerId;
		this.name = name;
		this.gstNumber = gstNumber;
		this.address = address;
		this.city = city;
		this.email = email;
		this.phone = phone;
		this.pincode = pincode;
	}

	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGstNumber() {
		return gstNumber;
	}

	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(customerId, other.customerId);
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", gstNumber=" + gstNumber + ", address="
				+ address + ", city=" + city + ", email=" + email + ", phone=" + phone + ", pincode=" + pincode
				+ ", password=" + password + "]";
	}
	

	
	
	

}
