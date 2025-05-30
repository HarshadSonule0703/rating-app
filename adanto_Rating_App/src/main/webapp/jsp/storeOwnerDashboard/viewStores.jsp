<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>View All Stores</title>
    <style>
        body { font-family: Arial, sans-serif; padding: 30px; background-color: #f5f5f5; }
        h2 { color: #333; }
        table { border-collapse: collapse; width: 80%; margin-top: 20px; background: #fff; }
        th, td { padding: 12px; border: 1px solid #ccc; text-align: left; }
        th { background-color: #f2f2f2; }
    </style>
</head>
<body>

    <h2>All Available Stores</h2>

    <table>
        <tr>
            <th>Store ID</th>
            <th>Store Name</th>
            <th>Store Location</th>
        </tr>

        <%
            Connection con = null;
            PreparedStatement pst = null;
            ResultSet rs = null;

            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");

                String query = "SELECT * FROM store ORDER BY store_id";
                pst = con.prepareStatement(query);
                rs = pst.executeQuery();

                while (rs.next()) {
        %>
        <tr>
            <td><%= rs.getInt("store_id") %></td>
            <td><%= rs.getString("store_name") %></td>
            <td><%= rs.getString("store_location") %></td>
        </tr>
        <%
                }
            } catch(Exception e) {
                out.println("Error: " + e.getMessage());
            } finally {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (con != null) con.close();
            }
        %>

    </table>

</body>
</html>
