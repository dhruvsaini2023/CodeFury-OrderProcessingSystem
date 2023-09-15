package com.codefury.backend.domain;

import java.time.LocalDate;
import java.util.Objects;

public class Invoice {
	private String invoiceID;
	private LocalDate invoicedate;
	private String orderDetails;
	
	private String customerDetails, productList, typeOfGST;
	private Double totalGSTAmount, totalInvoiceValue;
	private String statusOfInvoice;

	// Constructor
	public Invoice() {
		// TODO Auto-generated constructor stub
		this.invoiceID = "";
		this.invoicedate = LocalDate.now();
		this.orderDetails = "";
		this.customerDetails = "";
		this.productList = "";
		this.typeOfGST = "";
		this.totalGSTAmount = 0.0;
		this.totalInvoiceValue = 0.0;
		this.statusOfInvoice = "";
	}
	
	// Methods
	@Override
	public String toString() {
		return "Invoice [invoiceID=" + invoiceID + ", invoicedate=" + invoicedate + ", orderDetails=" + orderDetails
				+ ", customerDetails=" + customerDetails + ", productList=" + productList + ", typeOfGST=" + typeOfGST
				+ ", totalGSTAmount=" + totalGSTAmount + ", totalInvoiceValue=" + totalInvoiceValue
				+ ", statusOfInvoice=" + statusOfInvoice + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(invoiceID);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Invoice other = (Invoice) obj;
		return Objects.equals(invoiceID, other.invoiceID);
	}

	// Getter and Setters
	public String getInvoiceID() {
		return invoiceID;
	}
	public void setInvoiceID(String invoiceID) {
		this.invoiceID = invoiceID;
	}
	public LocalDate getInvoicedate() {
		return invoicedate;
	}
	public void setInvoicedate(LocalDate invoicedate) {
		this.invoicedate = invoicedate;
	}
	public String getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(String orderDetails) {
		this.orderDetails = orderDetails;
	}
	public String getCustomerDetails() {
		return customerDetails;
	}
	public void setCustomerDetails(String customerDetails) {
		this.customerDetails = customerDetails;
	}
	public String getProductList() {
		return productList;
	}
	public void setProductList(String productList) {
		this.productList = productList;
	}
	public String getTypeOfGST() {
		return typeOfGST;
	}
	public void setTypeOfGST(String typeOfGST) {
		this.typeOfGST = typeOfGST;
	}
	public Double getTotalGSTAmount() {
		return totalGSTAmount;
	}
	public void setTotalGSTAmount(Double totalGSTAmount) {
		this.totalGSTAmount = totalGSTAmount;
	}
	public Double getTotalInvoiceValue() {
		return totalInvoiceValue;
	}
	public void setTotalInvoiceValue(Double totalInvoiceValue) {
		this.totalInvoiceValue = totalInvoiceValue;
	}
	public String getStatusOfInvoice() {
		return statusOfInvoice;
	}
	public void setStatusOfInvoice(String statusOfInvoice) {
		this.statusOfInvoice = statusOfInvoice;
	}

}
