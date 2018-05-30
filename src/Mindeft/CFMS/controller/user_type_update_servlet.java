package Mindeft.CFMS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.user_typeBean;
import Mindeft.CFMS.dao.user_type_Dao;
import Mindeft.CFMS.util.StringValidationUtility;

public class user_type_update_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user_type_id=new String();
		String user_type=new String();
		
		user_type_id=request.getParameter("user_type_id");
		user_type=request.getParameter("user_type");
		
		System.out.println( "type"+user_type+  "id" +user_type_id);
		
		boolean isError=false;

		
		user_typeBean user_typeBeanObj=new user_typeBean(); 
		
		
		System.out.println("User type name::" + user_type);
		
		if(StringValidationUtility.isEmpty(user_type))
		{
			request.setAttribute("user_type", "<font color=red>*Select Any User</font>");
			isError=true;
		}
		
		
		if(isError)
		{
			request.getRequestDispatcher("user_type_table.jsp").forward(request, response);
		}
		else
		{
			user_typeBeanObj.setUser_type_id(user_type_id);
			user_typeBeanObj.setUser_type(user_type);
		
			
			System.out.println("No Problem"+ user_typeBeanObj.getUser_type());
			
			if(user_type_Dao.update(user_typeBeanObj));
			{
				System.out.println("Successful");
				request.getRequestDispatcher("user_typeList").forward(request, response);
			}
			
		}
		
	}

}
