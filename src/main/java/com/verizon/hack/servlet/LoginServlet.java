package com.verizon.hack.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.verizon.hack.db.MongoDBDAO;
import com.verizon.hack.domain.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String viewName = null;
		boolean result = false;
		User user = new User();
		RequestDispatcher rd = null;		
		MongoDBDAO mongo = new MongoDBDAO();
		try{
			String userName = request.getParameter("username");
			user.setUserName(userName);
			user.setPassword(request.getParameter("pwd"));			
			result = mongo.checkUser(user);
			if(result){
				viewName = "/home.jsp";
				request.getSession().setAttribute("username", userName);
			}else{
				viewName = "/login.jsp";
				request.setAttribute("error", true);
			}
			
		}catch(Exception e){
			viewName = "/login.jsp";
		}
		rd = request.getRequestDispatcher(viewName);
		rd.forward(request, response);
	}

}
