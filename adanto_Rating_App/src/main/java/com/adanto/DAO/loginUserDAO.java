package com.adanto.DAO;

import com.adanto.Database.DBConnection;
import com.adanto.UserBean.userBean;
import java.sql.*;

public class loginUserDAO {
    public userBean ub = null;

    public userBean login(String usermail, String password) {
        try {
            Connection con = DBConnection.getConn();
            PreparedStatement ps = con.prepareStatement(
                "SELECT user_id, username, usermail, userpassword FROM users WHERE usermail = ? AND userpassword = ?"
            );
            ps.setString(1, usermail);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ub = new userBean();
                ub.setUser_id(rs.getInt("user_id"));      // <-- set userId here
                ub.setUserName(rs.getString("username"));
                ub.setUserMail(rs.getString("usermail"));
                ub.setUserPass(rs.getString("userpassword"));
                System.out.println(ub.getUser_id());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ub;
    }
}

