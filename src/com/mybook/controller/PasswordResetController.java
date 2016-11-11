package com.mybook.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.mybook.bean.Users;
import com.mybook.dao.RegistrationDAO;
import com.mybook.dao.UpdatePasswordDAO;

public class PasswordResetController extends HttpServlet
	{
	private static final long serialVersionUID = 1L;
	static final Logger LOGGER = Logger.getLogger(PasswordResetController.class);
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LOGGER.info("Inside the PasswordResetController");
		String password=request.getParameter("password");
		String retypepassword=request.getParameter("retypepassword");
		Users user=new Users();
		if(password.equals(retypepassword))
		{
			UpdatePasswordDAO updatePWDDAO=new UpdatePasswordDAO();
			//	registerDAO.registerUser(user);
				if(updatePWDDAO.updateUserPassword(user).equals("SUCCESS"))   //On success, you can display a message to user on Home page
				 {
					LOGGER.info("Password Resset Successfully");
					RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);
				 }
				
			}
		}
	}
	
	
