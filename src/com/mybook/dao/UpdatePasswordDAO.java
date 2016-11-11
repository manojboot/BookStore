package com.mybook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.mybook.bean.Users;
import com.mybook.dbutil.DBConnectionManager;

public class UpdatePasswordDAO 
	{
	static final Logger LOGGER = Logger.getLogger(UpdatePasswordDAO.class);
	public String updateUserPassword(Users user)
	{			
		LOGGER.info("Inside the UpdatePasswordDAO ");
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DBConnectionManager.getConnection();
			ps = con.prepareStatement("UPDATE HR.USERS SET PASSWORD=? where USERNAME='mike123'");
			ps.setString(1, user.getPassword());
			LOGGER.info("Query executed successfully");
		    
			int i=ps.executeUpdate();
			if(i!=0)
			{
				return "SUCCESS";
			}
            }
		 catch (SQLException ex) {
			System.out.println("Login error -->" + ex.getMessage());
			
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "Something wrong wtasdf";
	}
}
