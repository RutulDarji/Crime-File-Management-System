package Mindeft.CFMS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Mindeft.CFMS.bean.userBean;
import Mindeft.CFMS.dao.forgot_passwordDao;
import Mindeft.CFMS.util.StringValidationUtility;
import Mindeft.CFMS.util.area_name_validation_utility;

/**
 * Servlet implementation class forgot_password_email_check_servlet
 */
public class forgot_password_email_check_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	String email;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		boolean isError=false;
		
		email=request.getParameter("email");
		
		if(StringValidationUtility.isEmpty(email))
		{
			request.setAttribute("email", "<font color=red>*Enter Valid email</font>");
			isError=true;
		}
		
		userBean userBeanObj=null; 
		
		if(isError)
		{
			request.getRequestDispatcher("forgot_password_jsp.jsp").forward(request, response);
		}
		else
		{
			userBeanObj=forgot_passwordDao.Email_Check(email);
		
			if(userBeanObj!=null)
			{
				System.out.println("Valid");
				HttpSession forgot_session=request.getSession();
				forgot_session.setAttribute("userBeanObj", userBeanObj);
				
				request.setAttribute("userBeanObj", userBeanObj);
				request.getRequestDispatcher("forgot_pass_to_security_question.jsp").forward(request, response);
				
			}
			else
			{
				request.setAttribute("email", "<font color=red>*Enter Valid email</font>");
				System.out.println("InValid");
				request.getRequestDispatcher("forgot_password_jsp.jsp").forward(request, response);
			}
			
		}
		
		
		
		
	}

}
