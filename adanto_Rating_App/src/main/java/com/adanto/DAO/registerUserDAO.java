package com.adanto.DAO;

import java.sql.Connection;
import java.sql.*;

import com.adanto.Database.DBConnection;
import com.adanto.UserBean.userBean;

public class registerUserDAO {
	public int k;
	public int insert(userBean ub) {
		try {
			Connection con = DBConnection.getConn();
			PreparedStatement ps = con.prepareStatement
					("insert into users values(?,?,?)");
			ps.setString(1, ub.getUserName());
			ps.setString(2, ub.getUserMail());
			ps.setString(3, ub.getUserPass());			
			
			k = ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return k;
	}

}
