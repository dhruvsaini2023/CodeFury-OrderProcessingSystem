package com.codefury.backend.service;

import com.codefury.backend.domain.Invoice;

public interface InvoiceService {
	public void displayAll();
	public void searchById(String orderId);
	public void removeOrder(String orderId);
	public void addOrder(Invoice invoice);
	public void invoiceStatusUpdation(String invoiceId, String invoiceStatus);
	
}
