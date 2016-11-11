package com.mybook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.mybook.bean.Users;
import com.mybook.dbutil.DBConnectionManager;

public class RegistrationDAO 
	{	
	static final Logger LOGGER = Logger.getLogger(LoginDAO.class);
		public String registerUser(Users user)
		{			
			LOGGER.info("Inside the RegistrationDAO ");
			Connection con = null;
			PreparedStatement ps = null;
			String password=user.getPassword();
			try {
				con = DBConnectionManager.getConnection();
				ps = con.prepareStatement("INSERT INTO HR.USERS(USERNAME,PASSWORD,FIRSTNAME,LASTNAME,EMAIL_ID) VALUES(?,?,?,?,?)");
				ps.setString(1, user.getUsername());
				ps.setString(2, user.getPassword());
				ps.setString(3, user.getFirstName());
				ps.setString(4, user.getLastName());
				ps.setString(5,user.getEmail());
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
