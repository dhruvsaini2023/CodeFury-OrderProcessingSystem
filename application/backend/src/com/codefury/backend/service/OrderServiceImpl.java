package com.codefury.backend.service;

import com.codefury.backend.dao.OrderDAO;
import com.codefury.backend.domain.Order;
import com.codefury.backend.exceptions.OrderDoesNotExistException;

public class OrderServiceImpl implements OrderService{
	private OrderDAO orderDAO;

	// Constructor
	public OrderServiceImpl() {
		this.orderDAO = new OrderDAO();
	}
	
	// Methods
	// Method for searching and displaying all records
	public void displayAll() {
		orderDAO.viewAll();
	}
	// Searching Orders by IDs
	public void searchById(String orderId) {
		try {
			orderDAO.findById(orderId);
		} catch (OrderDoesNotExistException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	// Deleting Orders from table
	public void removeOrder(String orderId) {
		orderDAO.deleteRecords(orderId);
	}
	// Inserting new Order
	public void addOrder(Order order) {
		orderDAO.insertOrder(order);
	}
	// Updating order status
	// Example pending to delivered by using orderID
	public void orderUpdation(String orderId, String orderStatus) {
		try {
			orderDAO.updateStatus(orderId, orderStatus);
		} catch (OrderDoesNotExistException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
}
