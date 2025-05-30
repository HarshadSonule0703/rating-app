<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
 <style>
        body {
            font-family: Arial, sans-serif;
            background: #f0f2f5;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .success-container {
            background: white;
            padding: 30px 50px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.2);
            text-align: center;
        }
        h2 {
            color: green;
            margin-bottom: 20px;
        }
        a {
            display: inline-block;
            margin-top: 15px;
            text-decoration: none;
            color: #fff;
            background: #007bff;
            padding: 10px 20px;
            border-radius: 5px;
        }
        a:hover {
            background: #0056b3;
        }
    </style>
<body>
<div class="success-container">
        <h2><%= (String)request.getAttribute("msg") %></h2>
        <a href="storeOwnerLogin.jsp">Go to Login Page</a>
    </div>

</body>
</html>