<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>User Registration</title>
  <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
  <style>
    * {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
      font-family: 'Roboto', sans-serif;
    }
    body {
      background: #f0f4f8;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }
    .form-container {
      background: #fff;
      padding: 40px 30px;
      border-radius: 12px;
      box-shadow: 0 8px 20px rgba(0,0,0,0.1);
      width: 350px;
    }
    h1 {
      text-align: center;
      margin-bottom: 25px;
      color: #333;
    }
    form input {
      width: 100%;
      padding: 12px 15px;
      margin: 10px 0;
      border: 1px solid #ccc;
      border-radius: 8px;
      font-size: 14px;
    }
    form button {
      width: 100%;
      padding: 12px 15px;
      background: #007BFF;
      color: #fff;
      border: none;
      border-radius: 8px;
      font-size: 16px;
      cursor: pointer;
      transition: 0.3s;
    }
    form button:hover {
      background: #0056b3;
    }
    .back-link {
      display: block;
      text-align: center;
      margin-top: 15px;
      color: #007BFF;
      text-decoration: none;
      font-size: 14px;
    }
    .back-link:hover {
      text-decoration: underline;
    }
  </style>
</head>
<body>

<div class="form-container">
  <h1>User Registration</h1>
  <form action="RegisterUserServlet" method="post">
    <input type="text" name="username" placeholder="Enter Your Name" required>
    <input type="email" name="email" placeholder="Enter Your Email" required>
    <input type="password" name="password" placeholder="Enter Your Password" required>
    <button type="submit">Register</button>
  </form>
  <a href="registerChoice.jsp" class="back-link">← Back to Choices</a>
</div>

</body>
</html>
