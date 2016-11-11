package com.mybook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.mybook.bean.Users;
import com.mybook.dbutil.DBConnectionManager;

public class LoginDAO {
	
	static final Logger LOGGER = Logger.getLogger(LoginDAO.class);
	
	public static boolean validate(String username, String password) {
		LOGGER.info("Inside the LoginDAO ");
		boolean login=false;
		Connection con = null;
		PreparedStatement ps = null;
	//	String dbUsername,dbPassword;
		Users user=new Users();
		try {
			con = DBConnectionManager.getConnection();
			ps = con.prepareStatement("SELECT USERNAME,PASSWORD FROM HR.USERS WHERE USERNAME = ? AND PASSWORD = ?");
			ps.setString(1, username);
			ps.setString(2, password);

		    ResultSet rs = ps.executeQuery();
		    System.out.println(user.getPassword());
		    System.out.println(rs.getString("PASSWORD"));
		    while(rs.next())
		    {	 
		    	System.out.println(rs.getString("PASSWORD"));
		    	String usernameDb=rs.getString("USERNAME");
		    	String passwordDb=rs.getString("PASSWORD");
		    	if(password.equals(passwordDb))
		    	{
		    		return login=true;
		    	}
		    }
		}
		 catch (SQLException ex) {
			System.out.println("Login error -->" + ex.getMessage());
			return false;
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return login;
	}
}
