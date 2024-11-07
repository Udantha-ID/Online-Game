<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>OnlineGame</title>
<!-- Favicon -->
<link rel="icon" type="image/png" sizes="32x32"
	href="assets/images/icons/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="16x16"
	href="assets/images/icons/favicon-16x16.png">
<link rel="shortcut icon" href="assets/images/icons/favicon.ico">
<!-- Stylesheets -->
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/style.css">
<style>
body {
    background-color: #E5E1DA !important;
    background-image: url('bg.jpg'); /* Replace 'path/to/your/image.jpg' with the actual path to your image */
    background-size: cover; /* Cover the entire background */
    background-repeat: no-repeat; /* Prevent the background image from repeating */
    background-position: center; /* Center the background image */
}


.sidebar {
    height: calc(100vh - 60px); /* Adjusted sidebar height */
    width: 250px;
    position: fixed;
    left: 0;
     background-color: rgba(255,68,0,255);
    padding-top: 10px; /* Adjust padding to fit content */
}

.sidebar .nav-link {
    color: #fff; /* White text color */
    transition: color 0.3s ease;
}

.sidebar .nav-link:hover {
    color: #ccc; /* Light gray text color on hover */
}


}

.nav-item {
    margin-bottom: 10px; /* Add space between each navigation item */
}

.nav-link {
    color: #ffffff; /* Text color */
    transition: color 0.3s ease; /* Smooth transition effect for text color */
}

.nav-link:hover {
    color: #ccc; /* Change text color on hover */
}

.nav-link.active {
    font-weight: bold; /* Make the active link bold */
    background-color: #333333; /* Dark background color for active link */
    padding: 8px 15px; /* Padding for active link */
    border-radius: 5px; /* Rounded corners */
}

.sidebar {
    padding: 20px;
    border-right: 1px solid #ccc; /* Add a border to separate sidebar from content */
}


.content {
	padding: 20px;
	color: black;
}

footer {
	position: fixed;
	bottom: 0;
	width: 100%;
	background-color: #333333;
	color: white;
	text-align: center;
	padding: 10px 0;
}
  
        .card-container {
            display: flex;
            justify-content: space-around;
            flex-wrap: wrap;
            margin-top: 20px;
        }
        .card {
            width: 250px;
            height: 250px;
            background-color: rgb(240, 240, 240,0.5);
            border-radius: 10px;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            margin-bottom: 20px;
            text-decoration: none;
            color: #333;
            transition: transform 0.3s ease;
        }
        .card:hover {
            transform: scale(1.05);
            color:green;
        }
        .card img {
            width: 80px;
            height: 80px;
            margin-bottom: 10px;
        }
        .card-title {
            font-size: 18px;
            font-weight: bold;
        }
</style>
</head>
<body>
	<div class="page-wrapper">
		<header>
			<nav class="navbar navbar-expand-md navbar-dark"
				style="background-color: #333333">
				<div>
					<a href="home.jsp" class="logo"
						style="font-size: 24px; font-weight: bold; text-decoration: none; color: #ADD8E6;">
						Online Game </a>
				</div>
				<div class="header-right">
					<ul class="top-menu">
						<li><a href="#">Links</a>
							<ul>
								<li class="nav-item ms-3"><span class="input-group-btn">
										<form action="logout" method="post">
											<button class="nav-link button" data-bs-toggle="modal"
												data-bs-target="#signup-modal" type="submit"
												style="background-color: #ADD8E6; color:black;">Logout</button>

										</form>
								</span></li>
							</ul></li>
					</ul>
					<!-- End .top-menu -->
				</div>
				<!-- End .header-right -->

			</nav>
		</header>
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-2">
					<div class="sidebar">
						<ul class="nav flex-column">
							<li class="nav-item"><a class="nav-link active"
								href="admin-dash.jsp">Dashboard</a></li>
							<li class="nav-item"><a class="nav-link"
								href="<%=request.getContextPath()%>/list_user">Users</a></li>
							<li class="nav-item"><a class="nav-link"
								href="<%=request.getContextPath()%>/list_game">Games</a></li>
						
							<li class="nav-item"><a
								href="<%=request.getContextPath()%>/list_payment"
								class="nav-link">Payments</a></li>
							<li class="nav-item"><a
								href="<%=request.getContextPath()%>/list_feedback"
								class="nav-link">Feedbacks</a></li>
						</ul>
					</div>
				</div>
				<div class="col-md-10">
					<div class="content">
						<h4>Welcome To The Admin Dashbord!  <%=session.getAttribute("name")%></h4>
			<div class="card-container">
            <a href="<%=request.getContextPath()%>/list_feedback" class="card">
                <img src="assets/images/feedback.png" alt="Feedback">
                <span class="card-title">Feedback</span>
            </a>
            <a href="<%=request.getContextPath()%>/list_payment" class="card">
                <img src="assets/images/payment.png" alt="Payment">
                <span class="card-title">Payment</span>
            </a>
            <a href="<%=request.getContextPath()%>/list_game" class="card">
                <img src="assets/images/game.png" alt="Games">
                <span class="card-title">Game</span>
            </a>
            <a href="<%=request.getContextPath()%>/list_user" class="card">
                <img src="assets/images/user.png" alt="Users">
                <span class="card-title">Users</span>
            </a>
        </div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<footer>
		<p>&copy; 2024 OnlineGame   Application</p>
	</footer>
</body>
</html>
