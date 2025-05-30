<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Store Owner Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f2f5;
            text-align: center;
            padding: 50px;
        }
        h1 {
            color: #333;
        }
        .button-container {
            margin-top: 30px;
        }
        .dashboard-button {
            display: inline-block;
            margin: 15px;
            padding: 15px 30px;
            font-size: 18px;
            border: none;
            border-radius: 10px;
            background-color: #4CAF50;
            color: white;
            text-decoration: none;
            transition: background-color 0.3s ease;
        }
        .dashboard-button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

    <h1>Welcome, Store Owner!</h1>

    <div class="button-container">
        <a href="addStore.jsp" class="dashboard-button">Add Store</a>
        <a href="removeStore.jsp" class="dashboard-button">Remove Store</a>
        <a href="viewStores.jsp" class="dashboard-button">View All Stores</a>
    </div>

</body>
</html>
