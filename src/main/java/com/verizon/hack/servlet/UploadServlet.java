package com.verizon.hack.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.verizon.hack.db.MongoDBDAO;
import com.verizon.hack.domain.ADDetail;	
		
		public class UploadServlet extends HttpServlet {		
		       		  
			protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
						
				int maxFileSize = 5000 * 1024;
				int maxMemSize = 5000 * 1024;		
				String filePath = System.getProperty("user.dir")+"\\";								
				String viewName = null;
				String contentType = request.getContentType();
				boolean result = false;
				MongoDBDAO mongoDAO = new MongoDBDAO();		
				RequestDispatcher rd = null;
				File file;
				try{
					ADDetail ad = (ADDetail)request.getSession().getAttribute("ad");					
					if(null != ad){
						 if ((contentType.indexOf("multipart/form-data") >= 0)) {				 				 				    					   						    					 					  
							   DiskFileItemFactory factory = new DiskFileItemFactory();
							      // maximum size that will be stored in memory
							      factory.setSizeThreshold(maxMemSize);
							      // Location to save data that is larger than maxMemSize.
							      factory.setRepository(new File("c:\\temp"));
							      // Create a new file upload handler
							      ServletFileUpload upload = new ServletFileUpload(factory);
							      // maximum file size to be uploaded.
							      upload.setSizeMax( maxFileSize ); 
							         // Parse the request to get file items.
							         List fileItems = upload.parseRequest(request);
							         // Process the uploaded file items
							         Iterator i = fileItems.iterator();			        
							         while ( i.hasNext () ) 
							         {
							            FileItem fi = (FileItem)i.next();
							            if (null != fi && !fi.isFormField () )	
							            {							            			           
							            String fileName = fi.getName();
							            boolean isInMemory = fi.isInMemory();
							            long sizeInBytes = fi.getSize();
							            // Write the file
							            if(null != fileName && !"".equalsIgnoreCase(fileName.trim())){					            	
							            	String username = null != ad.getUsername() ? ad.getUsername().trim() : "";					            	
							            	long timestamp = System.currentTimeMillis();
							            	
							            	   if( fileName.lastIndexOf("\\") >= 0 ){
							            		   fileName = fileName.substring( fileName.lastIndexOf("\\"));					            		   
										            file = new File( filePath + username+
										            +timestamp+
										            fileName.substring(1));
										            }else{								            									            	
										            file = new File( filePath+username+timestamp+
										            fileName.substring(fileName.lastIndexOf("\\")+1)) ;
										            }
										            fi.write( file ) ;
										            System.out.println(file.getAbsolutePath());
										            ad.setFileFullPath(file.getAbsolutePath());
							            }
							         
							            }
							         }
						   }
						result =  mongoDAO.insertADDDetails(ad);
						if(result){
							viewName = "/success.jsp";
						}else{
							viewName = "/error.jsp";
						}

					}else{
						request.getSession().removeAttribute("ad");
						request.getSession().removeAttribute("username");
						viewName="/login.jsp";
					}				
				
				}catch(Exception e){
					viewName="/error.jsp";
				}
				rd = request.getRequestDispatcher(viewName);
				rd.forward(request, response);
				 	}

	}
