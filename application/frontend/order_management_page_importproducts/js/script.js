// js/script.js
// Sample data for orders
const ordersData = [
    {
        orderId: 1,
        customerName: "John Doe",
        orderDate: "2023-09-12",
        orderValue: "$100.00",
        customerCity: "New York",
        status: "Approved",
        invoiceUrl: "invoice1.html"
    },
    {
        orderId: 2,
        customerName: "Jane Smith",
        orderDate: "2023-09-13",
        orderValue: "$75.50",
        customerCity: "Los Angeles",
        status: "Completed",
        invoiceUrl: "invoice2.html"
    },
    {
        orderId: 3,
        customerName: "Bob Johnson",
        orderDate: "2023-09-14",
        orderValue: "$55.25",
        customerCity: "Chicago",
        status: "Pending"
    }
];

// Sample employee information
const employeeInfo = {
    employeeId: 12345,
    lastLoggedIn: "2023-09-11 14:30:00"
};

// Function to populate the employee information
function populateEmployeeInfo() {
    const employeeInfoDiv = document.getElementById("employee-info");
    employeeInfoDiv.innerHTML = `
        <p>Employee ID: ${employeeInfo.employeeId}</p>
        <p>Last Logged In: ${employeeInfo.lastLoggedIn}</p>
    `;
}

// Function to populate the order list
function populateOrderList() {
    const ordersList = document.getElementById("orders");
    ordersData.forEach(order => {
        const listItem = document.createElement("li");
        listItem.innerHTML = `
            Order ID: ${order.orderId}<br>
            Customer Name: ${order.customerName}<br>
            Order Date: ${order.orderDate}<br>
            Order Value: ${order.orderValue}<br>
            Customer City: ${order.customerCity}<br>
            Status: ${order.status}<br>
        `;
        if (order.status === "Approved" || order.status === "Completed") {
            const viewInvoiceBtn = document.createElement("a");
            viewInvoiceBtn.href = order.invoiceUrl;
            viewInvoiceBtn.textContent = "View Invoice";
            listItem.appendChild(viewInvoiceBtn);
        }
        ordersList.appendChild(listItem);
    });
}

// Call functions to populate employee info and order list
populateEmployeeInfo();
populateOrderList();
