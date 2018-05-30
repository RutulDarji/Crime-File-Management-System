package Mindeft.CFMS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.dao.complainDao;
import Mindeft.CFMS.dao.user_type_Dao;

/**
 * Servlet implementation class complain_delete_servlet
 */
public class complain_delete_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String complain_id=request.getParameter("complain_id");
		System.out.println("complain_id::" + complain_id);
		
		
		if(new complainDao().delete(complain_id)){
			request.getRequestDispatcher("complain_list").forward(request, response);
		}else{
			request.getRequestDispatcher("complain_list").forward(request, response);
			
		}
	}

}
