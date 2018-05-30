package Mindeft.CFMS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.dao.countryDao;
import Mindeft.CFMS.dao.user_type_Dao;

public class user_type_delete_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String user_type_id=request.getParameter("user_type_id");
		System.out.println("user_type id::" + user_type_id);
		
		
		if(new user_type_Dao().delete(user_type_id)){
			request.getRequestDispatcher("user_typeList").forward(request, response);
		}else{
			request.getRequestDispatcher("user_typeList").forward(request, response);
			
		}
		
	}

}
