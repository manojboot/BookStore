package com.mybook.controller;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.mybook.bean.Users;
import com.mybook.dao.RegistrationDAO;
import com.mybook.dbutil.MailUtils;
import com.mybook.dbutil.PasswordDigestUtil;

/**
 * Servlet implementation class RegistrationController
 */
@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger LOGGER = Logger.getLogger(RegistrationController.class);
	
	    private String host;
	    private String port;
	    private String user;
	    private String pass;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LOGGER.info("Inside the RegistrationController");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String email=request.getParameter("email");
		
		
		ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
     //   user = context.getInitParameter("user");
        pass = context.getInitParameter("pass");
        
		Users user=new Users();
		user.setUsername(username);
		user.setPassword(PasswordDigestUtil.generateMD5HashString(password));	
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		
		String subject="Registration Complete";
		String content="Dear User your registration has been completed";
		RegistrationDAO registerDAO=new RegistrationDAO();
	//	registerDAO.registerUser(user);
		if(registerDAO.registerUser(user).equals("SUCCESS"))   //On success, you can display a message to user on Home page
		 {
			LOGGER.info("User Registered Successfully");
			/*try {
				//MailUtils.sendEmail(host, port, username, pass, email, subject,content);
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			LOGGER.info("Registraion completer for:--" +firstName + " " +lastName +" " +username + " " +email + " " +user.getPassword());
		 }
		
	}

}
