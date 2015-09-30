package com.verizon.hack.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.verizon.hack.db.MongoDBDAO;
import com.verizon.hack.domain.ADDetail;

/**
 * Servlet implementation class Step1Servlet
 */
public class Step1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Step1Servlet() {
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
		RequestDispatcher rd = null;
		MongoDBDAO mongoDAO = new MongoDBDAO();
		try{
				ADDetail ad = new ADDetail();
				ad.setBusinessName(request.getParameter("orgName"));
				ad.setAddr1(request.getParameter("addr1"));
				ad.setAddr2(request.getParameter("addr2"));
				ad.setAddr3(request.getParameter("addr3"));
				ad.setCity(request.getParameter("city"));
				ad.setState(request.getParameter("state"));
				ad.setCountry(request.getParameter("country"));
				ad.setPincode(request.getParameter("zip"));
				ad.setDesc(request.getParameter("desc"));
				ad.setUsername(request.getParameter("username"));
				ad.setPhone(request.getParameter("phone"));
				ad.setCategory(request.getParameter("category"));
				request.getSession().setAttribute("ad", ad);
				result =  mongoDAO.insertADDDetails(ad);
				if(result){
					viewName = "/success.jsp";
				}else{
					viewName = "/error.jsp";
				}
				//viewName="/step2.jsp";				
			}
			catch(Exception e){
				viewName = "/error.jsp";
			}
			rd = request.getRequestDispatcher(viewName);
			rd.forward(request, response);		
		
	}

}
