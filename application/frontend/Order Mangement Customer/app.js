const jsonData = {
  "quotes": [
      {
          "id": 1,
          "date": "2023-08-15",
          "shippingCost": 10,
          "totalValue": 100,
          "status": "Pending"
      },
      {
          "id": 2,
          "date": "2023-08-20",
          "shippingCost": 12,
          "totalValue": 150,
          "status": "Pending"
      },
      {
          "id": 3,
          "date": "2023-08-05",
          "shippingCost": 8,
          "totalValue": 90,
          "status": "Pending"
      }
  ],
  "orders": [
      {
          "id": 101,
          "date": "2023-08-10",
          "shippingCost": 8,
          "totalValue": 120,
          "status": "Approved"
      },
      {
          "id": 102,
          "date": "2023-08-02",
          "shippingCost": 7,
          "totalValue": 110,
          "status": "Approved"
      },
      {
          "id": 103,
          "date": "2023-09-01",
          "shippingCost": 9,
          "totalValue": 130,
          "status": "Approved"
      }
  ]
};
async function fetchData() {
    try {
      const response = await fetch('data.json'); // Adjust the path if needed
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      const jsonData = await response.json();
      return jsonData;
    } catch (error) {
      console.error('Error fetching JSON data:', error);
      return null; // Handle the error gracefully
    }
  }

// Function to render quote items
function renderQuoteItems(quotes) {
  const quoteList = document.getElementById('quoteList');
  quoteList.innerHTML = '';

  quotes.forEach(quote => {
      const listItem = document.createElement('li');
      listItem.innerHTML = `
          Order ID: ${quote.id}<br>
          Date: ${quote.date}<br>
          Shipping Cost: $${quote.shippingCost}<br>
          Total Order Value: $${quote.totalValue}<br>
          Status: ${quote.status}<br>
          <button onclick="approveQuote(${quote.id})">Approve</button>
          <button onclick="showQuoteDetails(${quote.id})">Details</button>
      `;
      quoteList.appendChild(listItem);
  });
}

// Function to approve a quote
function approveQuote(quoteId) {
  const currentDate = new Date();
  const quote = jsonData.quotes.find(q => q.id === quoteId);

  if (!quote) {
      alert('Quote not found.');
      return;
  }

  const orderDate = new Date(quote.date);

  if (quote.status === 'Pending') {
      if (currentDate - orderDate > 30 * 24 * 60 * 60 * 1000) {
          // Approval falls and status is set to expired
          quote.status = 'Expired';
      } else {
          // Order is approved
          quote.status = 'Approved';

          // Remove the quote from the quotes list and add it to the orders list
          jsonData.orders.push(quote);
          jsonData.quotes = jsonData.quotes.filter(q => q.id !== quoteId);
      }

      // Re-render the lists
      renderQuoteItems(jsonData.quotes);
      renderOrderItems(jsonData.orders);
  }
}

// Function to show quote details (next screen)
function showQuoteDetails(quoteId) {
  // Implement the logic to navigate to the detailed view of the quote
}

// Function to render order items
function renderOrderItems(orders) {
  const orderList = document.getElementById('orderList');
  orderList.innerHTML = '';

  orders.forEach(order => {
      const listItem = document.createElement('li');
      listItem.innerHTML = `
          Order ID: ${order.id}<br>
          Date: ${order.date}<br>
          Shipping Cost: $${order.shippingCost}<br>
          Total Order Value: $${order.totalValue}<br>
          Status: ${order.status}<br>
          ${order.status !== 'Approved' && !isSameDay(new Date(), new Date(order.date)) ? `<button onclick="showInvoice(${order.id})">Show Invoice</button>` : ''}
      `;
      orderList.appendChild(listItem);
  });
}

// Function to show the invoice screen
function showInvoice(orderId) {
  // Implement the logic to display the invoice screen
}

// Function to check if two dates are the same day
function isSameDay(date1, date2) {
  return (
      date1.getFullYear() === date2.getFullYear() &&
      date1.getMonth() === date2.getMonth() &&
      date1.getDate() === date2.getDate()
  );
}

// Initial rendering of the page with JSON data
const quotes = jsonData.quotes;
const orders = jsonData.orders;

renderQuoteItems(quotes);
renderOrderItems(orders);

