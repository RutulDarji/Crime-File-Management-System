package Mindeft.CFMS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Mindeft.CFMS.dao.countryDao;

/**
 * Servlet implementation class country_delete_servlet
 */
public class country_delete_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String country_id=request.getParameter("country_id");
		System.out.println("Country id::" + country_id);
		
		if(new countryDao().delete(country_id)){
			request.getRequestDispatcher("countryList").forward(request, response);
		}else{
			request.getRequestDispatcher("countryList").forward(request, response);
			
		}
		
	}

}
