package com.adanto.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.adanto.Database.DBConnection;
import com.adanto.UserBean.storeOwnerBean;


public class registerStroreOwnerDAO {
	public int k;
	public int insert(storeOwnerBean sb) {
		try {
			Connection con = DBConnection.getConn();
			PreparedStatement ps = con.prepareStatement
					("insert into store_owner values(?,?,?)");
			ps.setString(1, sb.getStoreOwnerName());
			ps.setString(2, sb.getStoreOwnerMail());
			ps.setString(3, sb.getStoreOwnerPass());			
			
			k = ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return k;
	}

}
