package Mindeft.CFMS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.dao.complain_status_Dao;
import Mindeft.CFMS.dao.query_status_Dao;

public class query_status_delete_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String query_status_id=request.getParameter("query_status_id");
		
		System.out.println("query_status_id is: " + query_status_id);
		
		if(new query_status_Dao().delete(query_status_id)){
			request.getRequestDispatcher("query_status_list").forward(request, response);
		}else{
			request.getRequestDispatcher("query_status_list").forward(request, response);
			
		}
	}

}
