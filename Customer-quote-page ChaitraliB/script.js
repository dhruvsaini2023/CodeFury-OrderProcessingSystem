// To store data of existing customers

const customerObj = [
    {
        name: "Anita",
        address: "Narayan Peth, Varad vishnu apartment",
        city: "Pune",
        phone: "98012345613",
        email: "anita13@gmail.com",
        pin: 211030
    },
    {
        name: "Sarita",
        address: "Near jwellery market, Dadar",
        city: "Mumbai",
        phone: "8892308761",
        email: "SaritaGokhale@gmail.com",
        pin: 900121
    }
]
 //To automatically display data of a customer existing in the system
function autopopulate() {
    const date = new Date();
    const dateForm = document.getElementById("date").value;
    var year = dateForm[0] + dateForm[1] + dateForm[2] + dateForm[3];
    var month = dateForm[5] + dateForm[6];
    var day = dateForm[8] + dateForm[9];
    var fullDate = year + "," + month + "," + day;

    // To prevent customer from entering a future date
    const dateSub = new Date(fullDate);
    if (date < dateSub) {
        alert("You have entered a future date");
        return;
    }

    var formName = document.getElementById("cusid").value;

     // To search a customer from a list of customers based on customer name
    let record = customerObj.find(record => record.name === formName);
    console.log(record);
    document.getElementById("address").textContent = "Customer address: " + record.address;
    document.getElementById("city").textContent = "Customer city: " + record.city;
    document.getElementById("pin").textContent = "Customer pin code: " + record.pin;
    document.getElementById("phone").textContent = "Customer phone number: " + record.phone;
    document.getElementById("email").textContent = "Customer Email address: " + record.email;

    document.getElementById("address").style.display = "block";
    document.getElementById("city").style.display = "block";
    document.getElementById("pin").style.display = "block";
    document.getElementById("phone").style.display = "block";
    document.getElementById("email").style.display = "block";

    document.getElementById("button").style.display = "none";
    document.getElementById("button2").style.display = "block";

}

//Clear the entered data and allow the customer to generate a new quote
function clearinfo() {
    alert("Quote created successfully!");
    document.getElementById("address").style.display = "none";
    document.getElementById("city").style.display = "none";
    document.getElementById("pin").style.display = "none";
    document.getElementById("phone").style.display = "none";
    document.getElementById("email").style.display = "none";

    document.getElementById("button").style.display = "block";
    document.getElementById("button2").style.display = "none";
    document.getElementById("date").value = "";
    document.getElementById("quantity").value = "";

    document.getElementById("heading").textContent = "Generate New Quote"
}
