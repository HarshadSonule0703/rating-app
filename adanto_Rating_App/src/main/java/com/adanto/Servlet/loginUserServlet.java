package com.adanto.Servlet;

import java.io.IOException;

import com.adanto.DAO.loginUserDAO;
import com.adanto.UserBean.userBean;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/jsp/UserLoginServlet")
public class loginUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String eMail = req.getParameter("email");
        String password = req.getParameter("password");
        userBean ub = new loginUserDAO().login(eMail, password);

        if (ub == null) {
            req.setAttribute("msg", "Invalid Login Credentials!<br>");
            req.getRequestDispatcher("userMsg.jsp").forward(req, res);
        } else {
            // Setting cookie and ServletContext
            Cookie ck = new Cookie("fname", ub.getUserName());
            res.addCookie(ck);

            ServletContext sct = req.getServletContext();
            sct.setAttribute("ubean", ub);

            // Add userId to session for later use
            HttpSession session = req.getSession();
            session.setAttribute("userId", ub.getUser_id());  // <-- Store userId in session
            session.setAttribute("userName", ub.getUserName()); // Optional: store username too

            // Redirect to StoreListServlet to show stores after login
            res.sendRedirect(req.getContextPath() + "/StoreListServlet");
        }
    }
}
