package com.codefury.backend.service;


import com.codefury.backend.domain.Order;

public interface OrderService {
	// Method declarations for service layer
	public void displayAll();
	public void searchById(String orderId);
	public void removeOrder(String orderId);
	public void addOrder(Order order);
	public void orderUpdation(String orderID, String orderStatus);
	
}
