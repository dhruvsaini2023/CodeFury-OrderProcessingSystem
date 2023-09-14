// js/customers-script.js
// Sample data for quotes and orders
const quotesData = [
    {
        quoteId: 1,
        date: "2023-09-12",
        shippingCost: "$10.00",
        totalOrderValue: "$100.00"
    },
    // Add more quotes as needed
];

const ordersData = [
    {
        orderId: 1,
        date: "2023-09-12",
        shippingCost: "$10.00",
        totalOrderValue: "$100.00",
        status: "Approved"
    },
    // Add more orders as needed
];

// Sample customer information
const customerInfo = {
    customerId: 123,
    customerName: "Customer Name",
    // Add more customer details as needed
};

// Function to populate customer information
function populateCustomerInfo() {
    const customerInfoDiv = document.getElementById("customer-info");
    customerInfoDiv.innerHTML = `
        <p>Customer ID: ${customerInfo.customerId}</p>
        <p>Customer Name: ${customerInfo.customerName}</p>
        <!-- Add more customer details here -->
    `;
}

// Function to populate the quotes list
function populateQuotesList() {
    const quotesList = document.getElementById("quotes");
    quotesData.forEach(quote => {
        const listItem = document.createElement("li");
        listItem.innerHTML = `
            Quote ID: ${quote.quoteId}<br>
            Date: ${quote.date}<br>
            Shipping Cost: ${quote.shippingCost}<br>
            Total Order Value: ${quote.totalOrderValue}<br>
            <button class="approve-button">Approve</button>
        `;
        quotesList.appendChild(listItem);
    });
}

// Function to populate the orders list
function populateOrdersList() {
    const ordersList = document.getElementById("orders");
    ordersData.forEach(order => {
        const listItem = document.createElement("li");
        listItem.innerHTML = `
            Order ID: ${order.orderId}<br>
            Date: ${order.date}<br>
            Shipping Cost: ${order.shippingCost}<br>
            Total Order Value: ${order.totalOrderValue}<br>
            Status: ${order.status}<br>
            <button class="show-invoice-button">Show Invoice</button>
        `;
        ordersList.appendChild(listItem);
    });
}

// Call functions to populate customer info, quotes list, and orders list
populateCustomerInfo();
populateQuotesList();
populateOrdersList();
