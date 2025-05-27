<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Login Choice</title>
  <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
  <style>
    * { margin: 0; padding: 0; box-sizing: border-box; font-family: 'Roboto', sans-serif; }
    body {
      background: #f0f4f8;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }
    .choice-container {
      text-align: center;
    }
    h1 {
      margin-bottom: 30px;
      color: #333;
    }
    .choices {
      display: flex;
      gap: 30px;
      justify-content: center;
    }
    .card {
      background: #fff;
      padding: 40px 30px;
      border-radius: 12px;
      box-shadow: 0 8px 20px rgba(0,0,0,0.1);
      width: 220px;
      transition: 0.3s;
      cursor: pointer;
    }
    .card:hover {
      transform: translateY(-8px);
      box-shadow: 0 12px 25px rgba(0,0,0,0.15);
    }
    .card h2 {
      margin-bottom: 10px;
      font-size: 22px;
      color: #444;
    }
    .card p {
      color: #777;
      font-size: 14px;
    }
  </style>
</head>
<body>

<div class="choice-container">
  <h1>Login As</h1>
  <div class="choices">
    <div class="card" onclick="loginChoice('user')">
      <h2>User</h2>
      <p>Login to rate and review stores.</p>
    </div>
    <div class="card" onclick="loginChoice('store')">
      <h2>Store Owner</h2>
      <p>Manage your store ratings and reviews.</p>
    </div>
  </div>
</div>

<script>
  function loginChoice(choice) {
    if(choice === 'user') {
      window.location.href = 'userLogin.jsp';
    } else if(choice === 'store') {
      window.location.href = 'storeOwnerLogin.jsp';
    }
  }
</script>

</body>
</html>
