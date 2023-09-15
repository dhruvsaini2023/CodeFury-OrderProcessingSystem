package com.codefury.backend.service;

import com.codefury.backend.dao.InvoiceDAO;
import com.codefury.backend.domain.Invoice;

public class InvoiceServiceImpl implements InvoiceService {
	private InvoiceDAO invoiceDAO;

	// Constructor
	public InvoiceServiceImpl() {
		this.invoiceDAO = new InvoiceDAO();
	}
	
	// Methods
	public void displayAll() {
		this.invoiceDAO.viewAll();
	}

	public void searchById(String invoiceId) {
		this.invoiceDAO.findById(invoiceId);
	}

	public void removeOrder(String invoiceId) {
		this.invoiceDAO.deleteRecords(invoiceId);
	}

	public void addOrder(Invoice invoice) {
		this.invoiceDAO.insertOrder(invoice);
	}

	public void invoiceStatusUpdation(String invoiceId, String invoiceStatus) {
		this.invoiceDAO.updateStatus(invoiceId, invoiceStatus);
	}
}
