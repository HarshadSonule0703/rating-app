package com.adanto.Servlet;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.adanto.UserBean.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
@WebServlet("/StoreListServlet")
public class StoreListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        List<storeBean> storeList = new ArrayList<>();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger"
            );

            PreparedStatement pst = con.prepareStatement("SELECT * FROM store");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                storeBean s = new storeBean();
                s.setId(rs.getInt("store_id"));
                s.setName(rs.getString("store_name"));
                s.setLocation(rs.getString("store_location"));
                storeList.add(s);
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        req.setAttribute("storeList", storeList);
        req.getRequestDispatcher("jsp/userDashboard/userDashboard.jsp").forward(req, res);
    }
}
