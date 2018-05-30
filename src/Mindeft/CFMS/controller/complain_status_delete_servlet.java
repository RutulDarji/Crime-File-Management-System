package Mindeft.CFMS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.dao.complain_status_Dao;
import Mindeft.CFMS.dao.countryDao;

/**
 * Servlet implementation class complain_status_delete_servlet
 */
public class complain_status_delete_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String complain_status_id=request.getParameter("complain_status_id");
		
		System.out.println("complain_status_id is: " + complain_status_id);
		
		if(new complain_status_Dao().delete(complain_status_id)){
			request.getRequestDispatcher("complain_status_list").forward(request, response);
		}else{
			request.getRequestDispatcher("complain_status_list").forward(request, response);
			
		}
		
	}

}
