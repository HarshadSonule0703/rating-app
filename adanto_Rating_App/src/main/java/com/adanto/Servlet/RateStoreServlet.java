package com.adanto.Servlet;

import java.io.IOException;
import java.sql.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/RateStoreServlet")
public class RateStoreServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {

        int storeId = Integer.parseInt(req.getParameter("storeId"));
        int ratingValue = Integer.parseInt(req.getParameter("rating"));
        int userId = (int) req.getSession().getAttribute("userId"); // Assuming you stored userId in session at login
        System.out.println(userId+" "+ratingValue);
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger"
            );

            PreparedStatement pst = con.prepareStatement(
                "INSERT INTO ratings (rating_id, store_id, user_id, rating) VALUES (rating_seq.nextval, ?, ?, ?)"
            );
            pst.setInt(1, storeId);
            pst.setInt(2, userId);
            pst.setInt(3, ratingValue);

            pst.executeUpdate();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        res.sendRedirect("StoreListServlet");
    }
}
