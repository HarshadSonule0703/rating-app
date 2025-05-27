package com.adanto.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.adanto.Database.DBConnection;
import com.adanto.UserBean.storeOwnerBean;


public class loginStoreOwnerDAO {
	public storeOwnerBean sb = null;
	public storeOwnerBean login(String usermail,String password) {
		try {
			Connection con = DBConnection.getConn();
			PreparedStatement ps = con.prepareStatement
					("select * from store_owner where store_ownermail=? and store_ownerpassword=?");
			ps.setString(1, usermail);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				sb = new storeOwnerBean();
				sb.setStoreOwnerName(rs.getString(1));
				sb.setStoreOwnerMail(rs.getString(2));
				sb.setStoreOwnerPass(rs.getString(3));
							
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return sb;
		
	}
}
