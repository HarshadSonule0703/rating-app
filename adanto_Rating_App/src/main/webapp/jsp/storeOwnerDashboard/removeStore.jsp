<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Remove Store</title>
    <style>
        body { font-family: Arial, sans-serif; padding: 30px; background-color: #f5f5f5; }
        h2 { color: #333; }
        form { background: #fff; padding: 20px; border-radius: 10px; max-width: 400px; }
        label { display: block; margin-top: 10px; }
        input[type="number"], input[type="submit"] { padding: 8px; margin-top: 5px; width: 100%; }
        input[type="submit"] { background: #f44336; color: white; border: none; }
        input[type="submit"]:hover { background: #d32f2f; }
    </style>
</head>
<body>

    <h2>Remove Store</h2>

    <form action="RemoveStoreServlet" method="post">
        <label for="storeId">Enter Store ID to Remove:</label>
        <input type="number" name="storeId" id="storeId" required>

        <input type="submit" value="Remove Store">
    </form>

</body>
</html>
