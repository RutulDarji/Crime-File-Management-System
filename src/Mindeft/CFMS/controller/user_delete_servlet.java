package Mindeft.CFMS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.dao.areaDao;
import Mindeft.CFMS.dao.userDao;

/**
 * Servlet implementation class user_delete_servlet
 */
public class user_delete_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String user_id=request.getParameter("user_id");
		
		System.out.println("user_id is: " + user_id);
		
		if(new userDao().delete(user_id)){
			request.getRequestDispatcher("user_list").forward(request, response);
		}else{
			request.getRequestDispatcher("user_list").forward(request, response);
		}
		
	}

}
