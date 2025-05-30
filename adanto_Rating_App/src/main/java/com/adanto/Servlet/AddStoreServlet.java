package com.adanto.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/jsp/storeOwnerDashboard/AddStoreServlet")
public class AddStoreServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Database connection parameters
    String url = "jdbc:oracle:thin:@localhost:1521:xe";
    String username = "system";  // <-- replace with your Oracle username
    String password = "tiger";  // <-- replace with your Oracle password

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get parameters from form
        String storeName = request.getParameter("storeName");
        String storeLocation = request.getParameter("storeLocation");

        // Optional: check session if needed
        HttpSession session = request.getSession(false);
        if (session == null) {
            response.getWriter().println("Session expired. Please login again.");
            return;
        }

        try {
            // Load Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Connect to DB
            Connection con = DriverManager.getConnection(url, username, password);

            // Insert query (store_id will auto-increment using sequence+trigger)
            String query = "INSERT INTO store (store_name, store_location) VALUES (?, ?)";
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, storeName);
            pst.setString(2, storeLocation);
            System.out.println(storeName+" "+storeLocation);
            int result = pst.executeUpdate();
            con.close();
            System.out.println(result);
            if (result > 0) {
                response.sendRedirect("storeOwnerDashboard.jsp");  // redirect back to dashboard after adding
            } else {
                response.getWriter().println("Failed to add store.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}
