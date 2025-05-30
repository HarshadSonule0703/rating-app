<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .message-box {
            background: #ffffff;
            padding: 30px 50px;
            border-radius: 15px;
            text-align: center;
            box-shadow: 0 0 20px rgba(0,0,0,0.1);
        }
        h2 {
            color: #dc3545;
            margin-bottom: 20px;
        }
        p {
            font-size: 18px;
            color: #333333;
            margin-bottom: 30px;
        }
        a {
            text-decoration: none;
            color: #ffffff;
            background-color: #007bff;
            padding: 12px 24px;
            border-radius: 8px;
            transition: background-color 0.3s ease;
        }
        a:hover {
            background-color: #0056b3;
        }
    </style>
    <script>
        window.onload = function() {
            console.log("Message page loaded");
        }
    </script>
</head>
<body>
	<div class="message-box">
        <h2>Notification</h2>
        <p><%= request.getAttribute("msg") %></p>
        <a href="storeOwnerLogin.jsp">Go to Login</a>
    </div>
</body>
</html>