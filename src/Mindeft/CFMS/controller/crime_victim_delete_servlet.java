package Mindeft.CFMS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.dao.crime_victimDao;
import Mindeft.CFMS.dao.crime_witnessDao;

/**
 * Servlet implementation class crime_victim_delete_servlet
 */
public class crime_victim_delete_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String crime_victim_id=request.getParameter("crime_victim_id");
		System.out.println("crime_victim_id::" + crime_victim_id);
		
		
		if(new crime_victimDao().delete(crime_victim_id)){
			//req.getRequestDispatcher("crime_victim_list").forward(req, resp);
			request.getRequestDispatcher("crime_victim_list").forward(request, response);
		}else{
			request.getRequestDispatcher("crime_victim_list").forward(request, response);
			
		}
		
	}

}
