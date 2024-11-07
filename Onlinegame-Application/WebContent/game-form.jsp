<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<style>
body {
	background-color: #E5E1DA !important;
	background-image: url('bg.jpg');
	background-size: cover;
	background-repeat: no-repeat;
	background-position: center;
}

footer {
	bottom: 0;
	width: 100%;
	background-color: #333333;
	color: white;
	text-align: center;
	padding: 10px 0;
}

.card-body {
	background-color: #F2F1EB;
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
				<a href="#" class="navbar-brand">
					Game Management </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list_game"
					class="nav-link">Games</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${Game != null}">
					<form action="updateGame" method="post">
				</c:if>
				<c:if test="${Game == null}">
					<form action="insertGame" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${Game != null}">
            			Edit Game
            		</c:if>
						<c:if test="${Game == null}">
            			Add New Game
            		</c:if>
					</h2>
				</caption>

				<c:if test="${Game != null}">
					<input type="hidden" name="ID"
						value="<c:out value='${Game.ID}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Game Name</label> <input type="text"
						value="<c:out value='${Game.gameName}' />"
						class="form-control" name="gameName" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Description</label>
					<textarea class="form-control" name="Description" rows="5"
						required="required"><c:out
							value="${Game.description}" /></textarea>
				</fieldset>


				<fieldset class="form-group">
					<label>Genre</label> <input type="text"
						value="<c:out value='${Game.genre}' />"
						class="form-control" name="Genre" required="required">
				</fieldset>


				<fieldset class="form-group">
					<label>Price</label> <input type="number"
						value="<c:out value='${Game.price}' />" class="form-control"
						name="price" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Platform</label> <input type="text"
						value="<c:out value='${Game.platform}' />" class="form-control"
						name="Platform" required="required">
				</fieldset>
					<fieldset class="form-group">
					<label>Publisher</label> <input type="text"
						value="<c:out value='${Game.publisher}' />" class="form-control"
						name="Publisher" required="required">
				</fieldset>
					<fieldset class="form-group">
					<label>Modes</label> <input type="text"
						value="<c:out value='${Game.modes}' />" class="form-control"
						name="Modes" required="required">
				</fieldset>

			
				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
	<footer>
		<!-- Footer content here -->
		<p>&copy; 2024 onlineGame Application</p>
	</footer>
</body>
</html>