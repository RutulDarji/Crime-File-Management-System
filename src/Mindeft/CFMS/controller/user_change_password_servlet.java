package Mindeft.CFMS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.dao.areaDao;
import Mindeft.CFMS.dao.change_password_Dao;
import Mindeft.CFMS.util.StringValidationUtility;

/**
 * Servlet implementation class user_change_password_servlet
 */
public class user_change_password_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	String old_password,new_password,retype_new_password,user_id,password;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Hi");
		boolean isError=false;
		
		password=request.getParameter("password");
		user_id=request.getParameter("user_id");
		old_password=request.getParameter("old_password");
		new_password=request.getParameter("new_password");
		retype_new_password=request.getParameter("retype_new_password");
		
		if(StringValidationUtility.isEmpty(old_password))
		{
			request.setAttribute("old_password", "<font color=red>*Enter  Old Password</font>");
			isError=true;
		}
		
		if(StringValidationUtility.isEmpty(new_password))
		{
			request.setAttribute("new_password", "<font color=red>*Enter  New Password</font>");
			isError=true;
		}
		
		if(StringValidationUtility.isEmpty(retype_new_password))
		{
			request.setAttribute("retype_new_password", "<font color=red>*Enter Retry New Password</font>");
			isError=true;
		}
		
		if(isError)
		{
			request.getRequestDispatcher("user_change_password.jsp").forward(request, response);	
		}
		else
		{
			if(old_password.equals(password))
			{
				if(new_password.equals(retype_new_password))
				{
					if(change_password_Dao.password_change(user_id,new_password))
					{
						System.out.println("Change");
						request.getRequestDispatcher("home_page_after.jsp").forward(request, response);
					}
				}
				else
				{
					request.setAttribute("retype_new_password", "<font color=red>*Enter Valid Retry New Password</font>");
					request.getRequestDispatcher("user_change_password.jsp").forward(request, response);
				}
			}
			else
			{
				request.setAttribute("old_password", "<font color=red>*Enter Valid Old Password</font>");
				request.getRequestDispatcher("user_change_password.jsp").forward(request, response);
			}
			
		}
		
		
		
		
		
	}

		

}
