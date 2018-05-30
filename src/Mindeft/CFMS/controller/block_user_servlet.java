package Mindeft.CFMS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.dao.block_user_Dao;

/**
 * Servlet implementation class block_user_servlet
 */
public class block_user_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String user_id=request.getParameter("user_id");
		String isActive=request.getParameter("isActive");
		
		System.out.println("Useer :: "+user_id);
		System.out.println("User Status :: "+isActive);
		
		if(isActive.equals("true"))
		{
			isActive="0";
		}
		else if(isActive.equals("false"))
		{
			isActive="1";
		}
			
		if(block_user_Dao.blockOrUnblock(user_id,isActive))
		{
			request.getRequestDispatcher("user_list").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("user_list").forward(request, response);
		}
		
		
	}

}
