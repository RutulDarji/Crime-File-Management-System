package Mindeft.CFMS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.dao.crime_accuseDao;
import Mindeft.CFMS.dao.crime_victimDao;

/**
 * Servlet implementation class crime_accuse_delete_servlet
 */
public class crime_accuse_delete_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String crime_accuse_id=request.getParameter("crime_accuse_id");
		System.out.println("crime_accuse_id::" + crime_accuse_id);
		
		
		if(new crime_accuseDao().delete(crime_accuse_id)){
			//req.getRequestDispatcher("crime_victim_list").forward(req, resp);
			request.getRequestDispatcher("crime_accuse_list").forward(request, response);
		}else{
			request.getRequestDispatcher("crime_accuse_list").forward(request, response);
			
		}
		
	}

}
