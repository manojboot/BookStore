package com.mybook.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;

import com.mybook.dao.ExcelReadDAO;
import com.mybook.dao.LoginDAO;

/**
 * Servlet implementation class FileUploadController
 */
@WebServlet("/FileUploadController")
public class FileUploadController extends HttpServlet {
	static final Logger LOGGER = Logger.getLogger(FileUploadController.class);
	private static final long serialVersionUID = 1L;
    private final String UPLOAD_DIRECTORY = "C:/Users/mpatelia/J2EE/BookHouse/resource";   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUploadController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LOGGER.info("Inside the FileUpload Controller");
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);

        // process only if its multipart content
        if (isMultipart) {
                // Create a factory for disk-based file items
                FileItemFactory factory = new DiskFileItemFactory();

                // Create a new file upload handler
                ServletFileUpload upload = new ServletFileUpload(factory);
                try {
                    // Parse the request
                    List<FileItem> multiparts = upload.parseRequest(request);

                   for (FileItem item : multiparts) 
                   {
                	   if (!item.isFormField())
                   		{
	                   String name = new File(item.getName()).getName();
	                   item.write(new File(UPLOAD_DIRECTORY + File.separator + name));
	                   LOGGER.info("File is:" +item);
	                   
                   		}
                   }
                        
                // File uploaded successfully
                request.setAttribute("message", "Your file has been uploaded!");
                
                // Call To Invoke Apache POI Library to insert excel file content in database.
                ExcelReadDAO excelDAO=new ExcelReadDAO();
         //       excelDAO.writeExcelData("C:/Users/mpatelia/J2EE/BookHouse/resource/Matrix.xlsx");
               
                } 
                catch (Exception e) 
                {
                 request.setAttribute("message", "File Upload Failed due to " + e);
                }
        } else 
        {
        request.setAttribute("message", "This Servlet only handles file upload request");
        }
        request.getRequestDispatcher("/welcome.jsp").forward(request, response);
}
	}


