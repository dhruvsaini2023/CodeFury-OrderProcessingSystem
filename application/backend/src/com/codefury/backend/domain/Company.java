package com.codefury.backend.domain;

import java.util.Objects;

public class Company {
	
	//private attributes
	private int companyId;
	private String companyName;
	private String address;
	private String city;
	private String gstNumber;
	
	//getters and setters for private attributes
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGstNumber() {
		return gstNumber;
	}
	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	//equals and hashcode methods using id attribute
	@Override
	public int hashCode() {
		return Objects.hash(companyId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Company other = (Company) obj;
		return companyId == other.companyId;
	}
	
	//toString method 
	@Override
	public String toString() {
		return "Company [id=" + companyId + ", name=" + companyName + ", address=" + address + ", gstNo=" + gstNumber + "]";
	}

}
