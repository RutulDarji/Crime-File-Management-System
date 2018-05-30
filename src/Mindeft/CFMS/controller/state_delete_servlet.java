package Mindeft.CFMS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.dao.countryDao;
import Mindeft.CFMS.dao.stateDao;

/**
 * Servlet implementation class state_delete_servlet
 */
public class state_delete_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String state_id=request.getParameter("state_id");
		System.out.println("State id::" + state_id);
		
		if(new stateDao().delete(state_id)){
			request.getRequestDispatcher("stateList").forward(request, response);
		}else{
			request.getRequestDispatcher("stateList").forward(request, response);
			
		}
	}

}
