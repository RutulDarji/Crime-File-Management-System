package Mindeft.CFMS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.dao.areaDao;
import Mindeft.CFMS.dao.crime_criminalDao;

/**
 * Servlet implementation class crime_criminal_delete_servlet
 */
public class crime_criminal_delete_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String crime_criminal_id=request.getParameter("crime_criminal_id");
		
		System.out.println("crime_criminal_id is: " + crime_criminal_id);
		
		if(new crime_criminalDao().delete(crime_criminal_id)){
			request.getRequestDispatcher("crime_criminal_list").forward(request, response);
		}else{
			request.getRequestDispatcher("crime_criminal_list").forward(request, response);
		}
		
	}

}
