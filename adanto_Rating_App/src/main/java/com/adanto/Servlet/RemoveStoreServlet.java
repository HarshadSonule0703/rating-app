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

@WebServlet("/jsp/storeOwnerDashboard/RemoveStoreServlet")
public class RemoveStoreServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    String url = "jdbc:oracle:thin:@localhost:1521:xe";
    String username = "system";  // replace
    String password = "tiger";  // replace

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int storeId = Integer.parseInt(request.getParameter("storeId"));

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(url, username, password);

            String query = "DELETE FROM store WHERE store_id = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, storeId);

            int result = pst.executeUpdate();
            con.close();

            if (result > 0) {
                response.sendRedirect("storeOwnerDashboard.jsp");
            } else {
                response.getWriter().println("No store found with that ID.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}
