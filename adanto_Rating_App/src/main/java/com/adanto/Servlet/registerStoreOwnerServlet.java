package com.adanto.Servlet;

import java.io.IOException;

import com.adanto.DAO.registerStroreOwnerDAO;
import com.adanto.UserBean.storeOwnerBean;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/jsp/RegisterStoreOwnerServlet")
public class registerStoreOwnerServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		storeOwnerBean sb = new storeOwnerBean();
		
		sb.setStoreOwnerName(req.getParameter("ownerName"));
		sb.setStoreOwnerMail(req.getParameter("email"));
		sb.setStoreOwnerPass(req.getParameter("password"));
		int k = new registerStroreOwnerDAO().insert(sb);
		if(k>0) {
			req.setAttribute("msg", "User Registered Successfully!!<br>");
			req.getRequestDispatcher("RegSuccess.jsp").forward(req, res);
		}
		
	}

}
