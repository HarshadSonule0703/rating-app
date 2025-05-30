<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add New Store</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            padding: 40px;
            background-color: #f5f5f5;
        }
        h2 {
            color: #333;
        }
        form {
            background: #fff;
            padding: 20px;
            border-radius: 10px;
            max-width: 400px;
        }
        label {
            display: block;
            margin-top: 10px;
        }
        input[type="text"],
        input[type="submit"] {
            padding: 8px;
            margin-top: 5px;
            width: 100%;
        }
        input[type="submit"] {
            background: #4CAF50;
            color: white;
            border: none;
        }
        input[type="submit"]:hover {
            background: #45a049;
        }
    </style>
</head>
<body>

    <h2>Add New Store</h2>

    <form action="AddStoreServlet" method="post">
        <label for="storeName">Store Name:</label>
        <input type="text" name="storeName" id="storeName" required>

        <label for="storeLocation">Store Location:</label>
        <input type="text" name="storeLocation" id="storeLocation" required>

        <input type="submit" value="Add Store">
    </form>

</body>
</html>
