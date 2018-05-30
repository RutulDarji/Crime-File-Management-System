package Mindeft.CFMS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.dao.areaDao;
import Mindeft.CFMS.dao.criminalDao;

/**
 * Servlet implementation class criminal_delete_servlet
 */
public class criminal_delete_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String criminal_id=request.getParameter("criminal_id");
		
		System.out.println("criminal_id is: " + criminal_id);
		
		if(new criminalDao().delete(criminal_id)){
			request.getRequestDispatcher("criminal_list").forward(request, response);
		}else{
			request.getRequestDispatcher("criminal_list").forward(request, response);
		}
		
	}

}
