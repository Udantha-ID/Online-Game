<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<style>
        body {
          
	background-image: url('bg.jpg');
	background-size: cover;
	background-repeat: no-repeat;
	background-position: center;
        }

        footer {
            width: 100%;
            background-color: #333333;
            color: white;
            text-align: center;
            padding: 10px 0;
            margin-top: 120px;
        }

        .card-body {
            background-color: white;
            padding: 20px; 
           
          
        }
      
      
    </style>
<title>OnlineGame</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: #333333">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand"> Game Management </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list_paymentUser"
					class="nav-link">Payment</a></li>
			</ul>
		</nav>
	</header>
	<br>
	
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${Payment != null}">
					<form action="updatePaymentUser" method="post">
				</c:if>
				<c:if test="${Payment == null}">
					<form action="insertPaymentUser" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${Payment != null}">
            			Edit Payment
            		</c:if>
						<c:if test="${Payment == null}">
            			Add New Payment
            		</c:if>
					</h2>
				</caption>

				<c:if test="${Payment != null}">
					<input type="hidden" name="paymentID" value="<c:out value='${Payment.paymentID}' />" />
				</c:if>

				<fieldset class="form-group">
				        <label>User ID</label>
				        <input type="number" class="form-control" name="userID" value="<%= session.getAttribute("userID") %>" readonly>
    			</fieldset>

					    <fieldset class="form-group">
					        <label for="card-holder-name">Card Holder Name:</label>
					        <input type="text" class="form-control" name="name" value="<%= session.getAttribute("name") %>" readonly required>
					    </fieldset>
					
					    <fieldset class="form-group">
					        <label for="email-address">Email:</label>
					        <input type="text" class="form-control" name="email-address" value="<%= session.getAttribute("email") %>" readonly required>
					    </fieldset>
					
					    <fieldset class="form-group">
					        <label for="paymentMethod">Payment Method</label>
					        <select class="form-control" name="paymentMethod" required>
					            <option value="Credit Card" <c:if test="${Payment.paymentMethod eq 'Credit Card'}">selected</c:if>>Credit Card</option>
					            <option value="PayPal" <c:if test="${Payment.paymentMethod eq 'PayPal'}">selected</c:if>>PayPal</option>
					            <option value="Debit Card" <c:if test="${Payment.paymentMethod eq 'Debit Card'}">selected</c:if>>Debit Card</option>
					        </select>
					    </fieldset>
					
					    <fieldset class="form-group">
					        <label for="card-number">Card Number:</label>
					        <input type="text" class="form-control" name="card-number" value="<c:out value='${Payment.cardNumber}' />" required>
					    </fieldset>
					
					    <fieldset class="form-group">
					        <label for="expiry-date">Expiry Date:</label>
					        <input type="date" class="form-control" name="expiry-date" value="<c:out value='${Payment.expiryDate}' />" required>
					    </fieldset>
					
					    <fieldset class="form-group">
					        <label for="cvv">CVV:</label>
					        <input type="text" class="form-control" name="cvv" value="<c:out value='${Payment.cvv}' />" required>
					    </fieldset>
					
					    <fieldset class="form-group">
					        <label for="amount">Amount:</label>
					        <input type="text" class="form-control" name="amount" value="<c:out value='${Payment.amount}' />" required>
					    </fieldset>
					
					    <button type="submit" class="btn btn-success">Save</button>
					</form>
			</div>
		</div>
	</div>
	<footer>
        <!-- Footer content here -->
        <p>&copy; 2024 ONlineGame Application</p>
    </footer>
</body>
</html>