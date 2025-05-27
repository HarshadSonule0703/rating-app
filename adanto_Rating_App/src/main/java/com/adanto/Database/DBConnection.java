package com.adanto.Database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	
	private static Connection con = null;
	private DBConnection() {
		//constructor
	}
	static{
		
	}
	public static Connection getConn() {
		try {
			Class.forName(DBInfo.driver);
			con = DriverManager.getConnection(DBInfo.dburl , DBInfo.uname , DBInfo.pword);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(con);
		return con;
	}
	

}
