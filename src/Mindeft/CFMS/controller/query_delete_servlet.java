package Mindeft.CFMS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.dao.queryDao;
import Mindeft.CFMS.dao.user_type_Dao;

/**
 * Servlet implementation class query_delete_servlet
 */
public class query_delete_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String query_id=request.getParameter("query_id");
		System.out.println("query_id::" + query_id);
		
		
		if(new queryDao().delete(query_id)){
			request.getRequestDispatcher("query_select").forward(request, response);
		}else{
			request.getRequestDispatcher("query_select").forward(request, response);
			
		}
		
	}

}
