package Mindeft.CFMS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.dao.crime_witnessDao;
import Mindeft.CFMS.dao.missing_personDao;

/**
 * Servlet implementation class crime_witness_delete_servlet
 */
public class crime_witness_delete_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String crime_witness_id=request.getParameter("crime_witness_id");
		System.out.println("crime_witness_id::" + crime_witness_id);
		
		
		if(new crime_witnessDao().delete(crime_witness_id)){
			request.getRequestDispatcher("crime_witness_list").forward(request, response);
		}else{
			request.getRequestDispatcher("crime_witness_list").forward(request, response);
			
		}
	}

}
