<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>OnlineGame</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap" rel="stylesheet">
    <style>
        :root {
            --primary-color: #1e88e5;
            --secondary-color: #202020;
            --accent-color: #ff4081;
            --background-color: #f5f5f5;
            --card-background: #ffffff;
            --text-color: #333333;
        }
        
        body {
            font-family: 'Poppins', sans-serif;
            background-color: var(--background-color);
            color: var(--text-color);
            margin: 0;
            padding: 0;
        }
        
        .navbar {
            background-color: var(--secondary-color);
            padding: 1rem 2rem;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }
        
        .navbar-brand {
            color: white;
            font-size: 1.5rem;
            font-weight: 600;
            text-decoration: none;
        }
        
        .container {
            max-width: 1200px;
            margin: 2rem auto;
            padding: 2rem;
        }
        
        h3 {
            color: var(--secondary-color);
            text-align: center;
            margin-bottom: 2rem;
            font-size: 2rem;
            font-weight: 600;
        }
        
        .game-grid {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
            gap: 2rem;
        }
        
        .game-card {
            background-color: var(--card-background);
            border-radius: 12px;
            overflow: hidden;
            transition: transform 0.3s ease, box-shadow 0.3s ease;
            box-shadow: 0 4px 6px rgba(0,0,0,0.1);
            position: relative;
        }
        
        .game-card:hover {
            transform: translateY(-5px);
            box-shadow: 0 8px 15px rgba(0,0,0,0.2);
        }
        
        .game-info {
            padding: 1.5rem;
        }
        
        .game-title {
            font-size: 1.4rem;
            font-weight: 600;
            margin-bottom: 1rem;
            color: var(--secondary-color);
        }
        
        .game-description {
            font-size: 0.9rem;
            color: #666;
            margin-bottom: 1rem;
            height: 60px;
            overflow: hidden;
            text-overflow: ellipsis;
            display: -webkit-box;
            -webkit-line-clamp: 3;
            -webkit-box-orient: vertical;
        }
        
        .game-meta {
            display: grid;
            grid-template-columns: 1fr 1fr;
            gap: 0.5rem;
            margin-bottom: 1rem;
        }
        
        .meta-item {
            font-size: 0.85rem;
            color: #555;
        }
        
        .meta-item i {
            width: 20px;
            color: var(--primary-color);
            margin-right: 5px;
        }
        
        .game-price {
            font-size: 1.4rem;
            font-weight: 600;
            color: var(--accent-color);
            margin-bottom: 1rem;
        }
        
        .add-to-cart {
            display: inline-block;
            padding: 0.75rem 1.5rem;
            background-color: var(--primary-color);
            color: white;
            text-decoration: none;
            border-radius: 25px;
            transition: background-color 0.3s ease;
            font-weight: 600;
            text-transform: uppercase;
            letter-spacing: 0.5px;
        }
        
        .add-to-cart:hover {
            background-color: #1565c0;
        }
        
        footer {
            background-color: var(--secondary-color);
            color: white;
            text-align: center;
            padding: 1rem 0;
            margin-top: 2rem;
        }
    </style>
</head>
<body>
    <nav class="navbar">
        <a href="#" class="navbar-brand">OnlineGame</a>
    </nav>

    <div class="container">
        <h3>Featured Games</h3>
        <div class="game-grid">
            <c:forEach var="Game" items="${listGames}">
                <div class="game-card">
                    <div class="game-info">
                        <h4 class="game-title"><c:out value="${Game.gameName}" /></h4>
                        <p class="game-description"><c:out value="${Game.description}" /></p>
                        <div class="game-meta">
                            <span class="meta-item"><i class="fas fa-gamepad"></i> <c:out value="${Game.genre}" /></span>
                            <span class="meta-item"><i class="fas fa-desktop"></i> <c:out value="${Game.platform}" /></span>
                            <span class="meta-item"><i class="fas fa-building"></i> <c:out value="${Game.publisher}" /></span>
                            <span class="meta-item"><i class="fas fa-users"></i> <c:out value="${Game.modes}" /></span>
                        </div>
                        <div class="game-price">$<c:out value="${Game.price}" /></div>
                        <a href="paymentUser-form.jsp" class="add-to-cart">Add Game</a>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

    <footer>
        <p>&copy; 2024 OnlineGame Application</p>
    </footer>
</body>
</html>