package com.codefury.backend.main;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

import com.codefury.backend.domain.Company;
import com.codefury.backend.domain.Employee;
import com.codefury.backend.domain.Invoice;
import com.codefury.backend.domain.Order;
import com.codefury.backend.domain.Products;
import com.codefury.backend.service.CompanyService;
import com.codefury.backend.service.CompanyServiceImpl;
import com.codefury.backend.service.EmployeeService;
import com.codefury.backend.service.EmployeeServiceImpl;
import com.codefury.backend.service.InvoiceService;
import com.codefury.backend.service.InvoiceServiceImpl;
import com.codefury.backend.service.OrderService;
import com.codefury.backend.service.OrderServiceImpl;
import com.codefury.backend.service.ProductService;
import com.codefury.backend.service.ProductServiceImpl;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		
		// -- ORDER RECORD TESTING
		OrderService orderService = new OrderServiceImpl();

		// Displaying all order that exist in database
		orderService.displayAll();
		
		// Searching a record by its ID
		orderService.searchById("");
		
		// Removing records and displaying all to check changes
		orderService.removeOrder("");
		orderService.displayAll();
		
		// Creating Order
		Order order = new Order();
		order.setCustomerId("1");
		order.setOrderDate(LocalDate.now());
		order.setOrderId("ORD1");
		order.setCustomerShoppingAddress("Pune, MH");
		order.setListOfProducts("Item1");
		order.setTotalOrderValue(11.0);
		order.setShippingCost(5.0);
		order.setShippingAgency("ShipperPrime");
		order.setOrderStatus("pending");
		
		orderService.addOrder(order);
		
		// Displaying all order and checking updates
		orderService.displayAll();
		
		// Updating Order Status using Order ID
		orderService.orderUpdation("ORD1", "delivery");
		
		// -- INVOICE RECORD TESTING
		InvoiceService invoiceDAO = new InvoiceServiceImpl();

		// Viewing All records
		invoiceDAO.displayAll();
		// Searching in with Invoice ID
		invoiceDAO.searchById("");
		// Deleting invoice using Invoice ID
		// Checking record by viewing all records
		invoiceDAO.removeOrder("");
		invoiceDAO.displayAll();
		
		// Sample Invoice object
		Invoice invoice = new Invoice();
		invoice.setInvoiceID("INV1");
		invoice.setInvoicedate(LocalDate.now());
		invoice.setOrderDetails("ORDDetail1");
		invoice.setCustomerDetails("CUST1");
		invoice.setProductList("ProdItem1");
		invoice.setTypeOfGST("CGST");
		invoice.setTotalGSTAmount(19.0);
		invoice.setTotalInvoiceValue(189.0);
		invoice.setStatusOfInvoice("Generated");
		
		// Adding new record in database
		invoiceDAO.addOrder(invoice);
		
		// Checking updated using display all
		invoiceDAO.displayAll();
		
		// Updating an existing record
		invoiceDAO.invoiceStatusUpdation("", "delivery");

		// -- COMPANY RECORD TESTING
		CompanyService cs= new CompanyServiceImpl();
		// Adding company details
		Company c= new Company();
		c.setCompanyName("HSBC");
		c.setAddress("Yerwada Road");
		c.setCity("Pune");
		c.setGstNumber("GST123456");
		
		// Inserting in database
		cs.insertCompany(c);
		

		// -- EMPLOYEE RECORD TESTING
		EmployeeService es= new EmployeeServiceImpl();
		// Adding employee details
		Employee e= new Employee();
		e.setEmployeeId(111);
		e.setUsername("John");
		e.setPassword("john");
		
		// Adding in  database
		es.insertEmployees(e);
		

		// -- PRODUCT RECORD TESTING
		ProductService productService = new ProductServiceImpl();
		Set<Products>  p1=new LinkedHashSet<>();
		p1.add(new Products(6,"Soap",250,"Level 2"));
		productService.insert(p1);
		
	}

}
