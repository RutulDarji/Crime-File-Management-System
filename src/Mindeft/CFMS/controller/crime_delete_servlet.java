package Mindeft.CFMS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.dao.crimeDao;
import Mindeft.CFMS.dao.user_type_Dao;

/**
 * Servlet implementation class crime_delete_servlet
 */
public class crime_delete_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String crime_id=request.getParameter("crime_id");
		System.out.println("crime_id::" + crime_id);
		
		
		if(new crimeDao().delete(crime_id)){
			request.getRequestDispatcher("crime_list").forward(request, response);
		}else{
			request.getRequestDispatcher("crime_list").forward(request, response);
		}
	
	}
	

}
