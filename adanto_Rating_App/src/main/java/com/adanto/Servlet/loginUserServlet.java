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
@SuppressWarnings("serial")
@WebServlet("/jsp/UserLoginServlet")
public class loginUserServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException,IOException{
		
		String eMail = req.getParameter("email");
		String password = req.getParameter("password");
		userBean ub = new loginUserDAO().login(eMail, password);
		
		if(ub == null) {
			req.setAttribute("msg", "invalid Login Process.....<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}else {
			Cookie ck = new Cookie("fname", ub.getUserName());
			ServletContext sct = req.getServletContext();
				//accessing Servletcotext Object reference
			sct.setAttribute("ubean", ub);
			res.addCookie(ck);
				//adding cookie is response
			req.getRequestDispatcher("logSuccess.jsp").forward(req, res);
	}
	
	}
}
