<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OnlineGame</title>

<style>
/* Body Styling */
body {
    background-image: url('bg.jpg');
    background-size: cover;
    background-repeat: no-repeat;
    background-position: center;
    font-family: 'Arial', sans-serif;
    margin: 0;
    padding: 0;
    color: #333;
}
.container {
    max-width: 1200px;
    margin: 0 auto;
    padding: 20px;
}
.text-center {
    text-align: center;
}
.header, .footer {
    background: linear-gradient(135deg, #333, #555);
    color: #fff;
    padding: 20px 0;
    text-align: center;
    text-shadow: 1px 1px 5px rgba(0, 0, 0, 0.3);
}
.main-content {
    margin: 20px auto;
    padding: 20px;
    background-color: rgba(223, 129, 129, 0.2);
    border-radius: 10px;
    box-shadow: 0 0 15px rgba(0, 0, 0, 0.3);
    max-width: 100%;
    transition: all 0.3s ease;
}

.main-content:hover {
    transform: translateY(-5px);
    box-shadow: 0 5px 15px rgba(0, 0, 0, 0.5);
}
.table-responsive {
    margin-top: 20px;
    margin-bottom: 20px;
    overflow-x: auto;
}

table {
    width: 150%;
    border-collapse: collapse;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
}

table th, table td, table tr {
    border: 1px solid #ddd;
    padding: 12px;
    text-align: left;
}

table th {
    background-color: #f4f4f4;
    color: #333;
    font-weight: bold;
}

table tr:hover {
    background-color: #f1f1f1;
}
.cx {
    margin: 20px auto;
    padding: 30px;
    background-color: rgba(173, 216, 230, 0.8);
    border-radius: 12px;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
    max-width: 100%;
}
@media (max-width: 1200px) {
    .container {
        padding: 15px;
    }

    .header, .footer {
        padding: 15px 0;
    }
}

@media (max-width: 768px) {
    .header, .footer {
        padding: 10px 0;
        font-size: 14px;
    }

    .main-content {
        padding: 15px;
    }

    .btn {
        padding: 10px 20px;
        font-size: 14px;
    }
}

@media (max-width: 480px) {
    .header, .footer {
        font-size: 12px;
    }

    .main-content {
        padding: 10px;
    }

    table th, table td {
        padding: 8px;
    }
}



</style>
</head>

<body>
<div class="header">
    <jsp:include page="header.jsp"></jsp:include>
</div>

<div class="container">
    <input type="hidden" value="<%= session.getAttribute("userID") %>" name="userID">
    <!-- Main content wrapper -->
    <div class="main-content">
        <div class="container text-left">
            <a href="<%=request.getContextPath()%>/newPaymentUser" class="btn btn-success">Add New Payment</a>
        
            <!-- Main content here -->
            <h3 class="text-center">List of Payments</h3>
        </div>
      
        <div class="cx">
            <div class="table-responsive text-center">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>Payment ID</th>
                            <th>User ID</th>
                            <th>Payment Method</th>
                            <th>Card Holder Name</th>
                            <th>Email Address</th>
                            <th>Amount</th>
                            <th>Card Number</th>
                            <th>Expiry Date</th>
                            <th>CVV</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="payment" items="${listPaymentsUser}">
                            <tr>
                                 <td>${payment.paymentID}</td>
                                 <td>${payment.userID}</td>
                				 <td>${payment.paymentMethod}</td>
               					 <td>${payment.cardHolderName}</td>
                				 <td>${payment.emailAddress}</td>
                				 <td>${payment.amount}</td>
                				 <td>${payment.cardNumber}</td>
                				 <td>${payment.expiryDate}</td>
                				 <td>${payment.cvv}</td>
                                 <td>
                                    <a href="<%=request.getContextPath()%>/editPaymentUser?paymentID=<c:out value='${payment.paymentID}' />" class="btn btn-dark">Edit</a>
                                    <a href="<%=request.getContextPath()%>/deletePaymentUser?paymentID=<c:out value='${payment.paymentID}' />" class="btn btn-danger">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<div class="footer">
    <jsp:include page="footer.jsp"></jsp:include>
</div>
</body>
</html>
