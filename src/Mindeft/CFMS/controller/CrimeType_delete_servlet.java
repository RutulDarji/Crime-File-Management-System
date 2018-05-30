package Mindeft.CFMS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.dao.CrimeTypeDao;
import Mindeft.CFMS.dao.complain_status_Dao;

/**
 * Servlet implementation class CrimeType_delete_servlet
 */
public class CrimeType_delete_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String CrimeType_id=request.getParameter("CrimeType_id");
		
		System.out.println("CrimeType_id is: " + CrimeType_id);
		
		if(new CrimeTypeDao().delete(CrimeType_id)){
			request.getRequestDispatcher("CrimeType_list").forward(request, response);
		}else{
			request.getRequestDispatcher("CrimeType_list").forward(request, response);
			
		}
		
	}

}
