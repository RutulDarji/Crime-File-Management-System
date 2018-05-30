package Mindeft.CFMS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Mindeft.CFMS.bean.userBean;
import Mindeft.CFMS.dao.areaDao;
import Mindeft.CFMS.dao.forgot_passwordDao;
import Mindeft.CFMS.util.StringValidationUtility;
import Mindeft.CFMS.util.area_name_validation_utility;

/**
 * Servlet implementation class login_check_servlet
 */
public class login_check_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String user_email,user_password;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		user_email=request.getParameter("user_email");
		user_password=request.getParameter("user_password");
		HttpSession session=request.getSession();
		
		boolean isError=false;
		userBean session_userBeanObj=null; 
		
		if(StringValidationUtility.isEmpty(user_email))
		{
			request.setAttribute("user_email", "<font color=red>*Enter Valid email</font>");
			isError=true;
		}
		
		if(StringValidationUtility.isEmpty(user_password))
		{
			request.setAttribute("user_password", "<font color=red>*Enter Valid password</font>");
			isError=true;
		}
		
		if(isError)
		{
			request.getRequestDispatcher("login_page.jsp").forward(request, response);
		}
		else
		{
			session_userBeanObj=forgot_passwordDao.Email_Check(user_email);
			
			if(session_userBeanObj==null)
			{
				request.setAttribute("valid", "<font color=red>*Not Found</font>");
				isError=true;
				request.getRequestDispatcher("login_page.jsp").forward(request, response);
			}
			else
			{
				if(!session_userBeanObj.getPassword().trim().equals(user_password.trim()))
				{
					request.setAttribute("user_password", "<font color=red>*Enter Valid password</font>");
					request.getRequestDispatcher("login_page.jsp").forward(request, response);
				}
				else
				{
					System.out.println("Valid");
					
					if(session_userBeanObj.getEmail().equals(user_email) && session_userBeanObj.getPassword().equals(user_password) && session_userBeanObj.getUser_type_id().equals("1"))
					{
						//HttpSession login_session=request.getSession();
						session.setAttribute("session_userBeanObj", session_userBeanObj);	
						request.getRequestDispatcher("index.jsp").forward(request, response);
					}
					else 
					{
						if(session_userBeanObj.getIsActive().equals("true"))
						{
							System.out.println("User");
						//HttpSession login_session=request.getSession();
							session.setAttribute("session_userBeanObj", session_userBeanObj);
							request.getRequestDispatcher("home_page_after.jsp").forward(request, response);
						}
						else
						{
							request.setAttribute("user_password", "<font color=red>*User Currently Block</font>");
							request.getRequestDispatcher("login_page.jsp").forward(request, response);
						}
						
					}
					
				}
				
			}//main else
					
			
		}
		
		
	}

}
