package com.adanto.DAO;

import com.adanto.Database.DBConnection;
import com.adanto.UserBean.userBean;
import java.sql.*;

public class loginUserDAO {
	public userBean ub = null;
	public userBean login(String usermail,String password) {
		try {
			Connection con = DBConnection.getConn();
			PreparedStatement ps = con.prepareStatement
					("select * from users where usermail=? and userpassword=?");
			ps.setString(1, usermail);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				ub = new userBean();
				ub.setUserName(rs.getString(1));
				ub.setUserMail(rs.getString(2));
				ub.setUserPass(rs.getString(3));			
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return ub;
		
	}

}
