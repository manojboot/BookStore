package com.mybook.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.mybook.bean.Book;
import com.mybook.dao.LoginDAO;
import com.mybook.dao.SearchBookDAO;

/**
 * Servlet implementation class BookSearchController
 */
@WebServlet("/BookSearchController")
public class BookSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger LOGGER = Logger.getLogger(BookSearchController.class);   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookSearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LOGGER.info("In the Book Search Controller");
		String bookTitle=request.getParameter("bookTitle");
		String bookAuthor=request.getParameter("bookAuthor");
		String bookGenre=request.getParameter("bookGenre");
		SearchBookDAO searchBookDAO=new SearchBookDAO();
		if(!(bookTitle==""))
		{
			Book findBook=searchBookDAO.searchByBookTitle(bookTitle);
		//	book.setBookTitle(bookTitle);
		//	book.setBookAuthor(findBook.getBookAuthor());
			
			System.out.println(findBook.getBookAuthor());
			if(bookTitle.equals(findBook.getBookTitle()))
			 {	
				request.setAttribute("findBook", findBook);
				RequestDispatcher rd=request.getRequestDispatcher("bookResult.jsp");
				rd.forward(request, response);
				LOGGER.info("Book searched:--" +bookTitle + " + " +findBook.getBookAuthor() + " " + findBook.getBookGenre());
			 }	
		}
		else if(bookAuthor!=null)
		{
			
			List<Book> findBookAuthor=searchBookDAO.searchByAuthor(bookAuthor);		
		//	System.out.println(((Book) findBookAuthor).getBookAuthor());
		
				request.setAttribute("findBookAuthor", findBookAuthor);
				RequestDispatcher rd=request.getRequestDispatcher("bookResult.jsp");
				rd.forward(request, response);
				LOGGER.info("Book searched:--"  );
		}	
		
		else if(bookGenre!=null)
		{
			List<Book> findBookGenre=searchBookDAO.searchByGenre(bookGenre);	
		//	System.out.println(((Book) findBookAuthor).getBookAuthor());
		
				request.setAttribute("findBookGenre", findBookGenre);
				RequestDispatcher rd=request.getRequestDispatcher("bookResult.jsp");
				rd.forward(request, response);
				LOGGER.info("Book searched By Genre:--"  );
			 }	
		}
		
	}

