package com.adanto.Servlet;

import java.io.IOException;

import com.adanto.DAO.loginStoreOwnerDAO;

import com.adanto.UserBean.storeOwnerBean;


import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
@WebServlet("/jsp/StoreOwnerLoginServlet")
public class loginStoreOwnerServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException,IOException{
		
		String eMail = req.getParameter("email");
		String password = req.getParameter("password");
		System.out.println(eMail+"  "+password);
		storeOwnerBean sb = new loginStoreOwnerDAO().login(eMail, password);
		
		System.out.println(sb);
		if(sb == null) {
			req.setAttribute("msg", "invalid Login Process.....<br>");
			req.getRequestDispatcher("storeOwnerMsg.jsp").forward(req, res);
		}else {
			Cookie ck = new Cookie("fname", sb.getStoreOwnerName());
			ServletContext sct = req.getServletContext();
				//accessing Servletcotext Object reference
			sct.setAttribute("ubean", sb);
			res.addCookie(ck);
				//adding cookie is response
			req.getRequestDispatcher("storeOwnerDashboard/storeOwnerDashboard.jsp").forward(req, res);
	}
		
	}
	

}
