package com.codefury.backend.domain;

import java.time.LocalDate;
import java.util.Objects;

public class Order {
	// Properties of Order class
	private String customerId;
	private LocalDate orderDate;
	private String OrderId;
	
	private String customerShoppingAddress, listOfProducts;
	private Double totalOrderValue, shippingCost;
	private String shippingAgency, orderStatus;
	
	// Methods
	@Override
	public String toString() {
		return "OrderDAO [customerId=" + customerId + ", orderDate=" + orderDate + ", OrderId=" + OrderId
				+ ", customerShoppingAddress=" + customerShoppingAddress + ", listOfProducts=" + listOfProducts
				+ ", totalOrderValue=" + totalOrderValue + ", shippingCost=" + shippingCost + ", shippingAgency="
				+ shippingAgency + ", orderStatus=" + orderStatus + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(OrderId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(OrderId, other.OrderId);
	}

	// Getter and Setters
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderId() {
		return OrderId;
	}
	public void setOrderId(String orderId) {
		OrderId = orderId;
	}
	public String getCustomerShoppingAddress() {
		return customerShoppingAddress;
	}
	public void setCustomerShoppingAddress(String customerShoppingAddress) {
		this.customerShoppingAddress = customerShoppingAddress;
	}
	public String getListOfProducts() {
		return listOfProducts;
	}
	public void setListOfProducts(String listOfProducts) {
		this.listOfProducts = listOfProducts;
	}
	public Double getTotalOrderValue() {
		return totalOrderValue;
	}
	public void setTotalOrderValue(Double totalOrderValue) {
		this.totalOrderValue = totalOrderValue;
	}
	public Double getShippingCost() {
		return shippingCost;
	}
	public void setShippingCost(Double shippingCost) {
		this.shippingCost = shippingCost;
	}
	public String getShippingAgency() {
		return shippingAgency;
	}
	public void setShippingAgency(String shippingAgency) {
		this.shippingAgency = shippingAgency;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

}
