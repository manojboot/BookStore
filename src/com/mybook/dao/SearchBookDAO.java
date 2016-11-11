package com.mybook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.mybook.bean.Book;
import com.mybook.controller.BookSearchController;
import com.mybook.dbutil.DBConnectionManager;

public class SearchBookDAO 
	{	
	static final Logger LOGGER = Logger.getLogger(BookSearchController.class);   
		public Book searchByBookTitle(String bookTitle)
		{	
			LOGGER.info("Inside search Book by Title method");
			Connection con = null;
			PreparedStatement ps = null;
			List<Book> books=new ArrayList<Book>();
			Book book=new Book();
			try {
				con = DBConnectionManager.getConnection();
				ps = con.prepareStatement("SELECT * FROM HR.BOOK_DETAILS WHERE BOOK_TITLE=?");
				ps.setString(1,bookTitle);
				 ResultSet rs = ps.executeQuery();
				 while(rs.next())
				 {		
					 	String bookAuthor=rs.getString("BOOK_AUTHOR");
					 	String bookGenre=rs.getString("BOOK_GENERE");
					 	book.setBookTitle(bookTitle);
					 	book.setBookAuthor(bookAuthor);
					 	book.setBookGenre(bookGenre);;
					 	System.out.println(book.getBookTitle());
					 	System.out.println(book.getBookAuthor());
					 	System.out.println(book.getBookGenre());
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
			return book;			
		}
		
		public List<Book> searchByAuthor(String bookAuthor)
		{	
			LOGGER.info("Inside search Book by Author method");
			Connection con = null;
			PreparedStatement ps = null;
			List<Book> books=new ArrayList<Book>();
			try {
				con = DBConnectionManager.getConnection();
				ps = con.prepareStatement("SELECT * FROM HR.BOOK_DETAILS WHERE BOOK_AUTHOR=?");
				ps.setString(1,bookAuthor);
				 ResultSet rs = ps.executeQuery();
				 while(rs.next())
				 {		Book book=new Book();
					 	String bookTitle=rs.getString("BOOK_TITLE");
					 	String bookGenre=rs.getString("BOOK_GENERE");
					 	book.setBookTitle(bookTitle);
					 	book.setBookAuthor(bookAuthor);
					 	book.setBookGenre(bookGenre);;
					 	System.out.println(book.getBookTitle());
					 	System.out.println(book.getBookAuthor());
					 	System.out.println(book.getBookGenre());
					 	books.add(book);
					 	System.out.println(books.get(0));
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
			return books;			
		}
		
		public List<Book> searchByGenre(String bookGenre)
		{	
			LOGGER.info("Inside search Book by Genre method");
			Connection con = null;
			PreparedStatement ps = null;
			List<Book> books=new ArrayList<Book>();
			
			try {
				con = DBConnectionManager.getConnection();
				ps = con.prepareStatement("SELECT * FROM HR.BOOK_DETAILS WHERE BOOK_GENERE=?");
				ps.setString(1,bookGenre);
				 ResultSet rs = ps.executeQuery();
				 while(rs.next())
				 {		Book book=new Book();
					 	String bookAuthor=rs.getString("BOOK_AUTHOR");
					 	String bookTitle=rs.getString("BOOK_TITLE");
					 	book.setBookTitle(bookTitle);
					 	book.setBookAuthor(bookAuthor);
					 	book.setBookGenre(bookGenre);;
					 	System.out.println(book.getBookTitle());
					 	System.out.println(book.getBookAuthor());
					 	System.out.println(book.getBookGenre());
					 	books.add(book);
					 	
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
			return books;			
		}
}
