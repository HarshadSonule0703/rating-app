package com.adanto.Servlet;

import java.io.IOException;

import com.adanto.DAO.registerUserDAO;
import com.adanto.UserBean.userBean;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
@WebServlet("/jsp/RegisterUserServlet")
public class registerUserServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		userBean ub = new userBean();
		ub.setUserName(req.getParameter("username"));
		ub.setUserMail(req.getParameter("email"));
		ub.setUserPass(req.getParameter("password"));
		System.out.println(req.getParameter("username"));
		System.out.println(req.getParameter("email"));
		System.out.println(req.getParameter("password"));
		
		int k = new registerUserDAO().insert(ub);
		System.out.println(k);
		if(k>0) {
			req.setAttribute("msg", "User Registered Successfully!!<br>");
			req.getRequestDispatcher("RegSuccess.jsp").forward(req, res);
		}
		
	}
	

}
