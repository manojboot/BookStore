package com.mybook.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.mybook.dao.LoginDAO;
import com.mybook.dbutil.PasswordDigestUtil;

public class LoginController extends HttpServlet
	{
	static final Logger LOGGER = Logger.getLogger(LoginController.class);
		public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
		{	
			LOGGER.info("Inside the LoginController");
			 response.setContentType("text/html");  
		        PrintWriter out = response.getWriter();  
			String username = request.getParameter("username");
			String password = request.getParameter("password");		
			password=PasswordDigestUtil.generateMD5HashString(password);
			HttpSession session = request.getSession(false);
	        if(session!=null)
	        session.setAttribute("username", username);
			
			if(LoginDAO.validate(username, password))
			{
				RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");
				rd.forward(request, response);
				LOGGER.info("Login Successful for:--" +username);
			}
			else{  
	            RequestDispatcher rd=request.getRequestDispatcher("error.jsp");  
	            rd.include(request,response);  
	        }  
		}
}
