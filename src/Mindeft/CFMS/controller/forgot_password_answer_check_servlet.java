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

/**
 * Servlet implementation class forgot_password_answer_check_servlet
 */
public class forgot_password_answer_check_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	String security_answer,original_answer,email,user_password;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean isError=false;
		
		HttpSession forgot_session=request.getSession();
		userBean userBeanObj=(userBean)forgot_session.getAttribute("userBeanObj");
		
		System.out.println("Answer::" + userBeanObj.getSecurity_question_answer());
		System.out.println("Email::" + userBeanObj.getEmail());
		
		
		security_answer=request.getParameter("security_answer");
		security_answer=security_answer.toLowerCase();
		
		original_answer=userBeanObj.getSecurity_question_answer();
		original_answer=original_answer.trim();
		original_answer=original_answer.toLowerCase();
		email=userBeanObj.getEmail();
		email=email.trim();
		user_password=userBeanObj.getPassword();
		user_password=user_password.trim();
		
		
		System.out.println("Original answer ::" + original_answer);
		System.out.println("security_question_answer" + security_answer);
		System.out.println("Email" + email);
		System.out.println("user Password" + user_password);
		
		if(StringValidationUtility.isEmpty(security_answer))
		{
			request.setAttribute("security_answer", "<font color=red>*Enter Valid answer</font>");
			isError=true;
		}
		
		if(isError)
		{
			request.getRequestDispatcher("forgot_pass_to_security_question.jsp").forward(request, response);
		}
		else
		{
			if(original_answer.equals(security_answer))
			{
				System.out.println("Valid");
				String subject="Your Password ";
				send_mail.sendmail(email, subject,user_password);
				request.getRequestDispatcher("login_page.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("security_answer", "<font color=red>*Enter Valid answer</font>");
				request.getRequestDispatcher("forgot_pass_to_security_question.jsp").forward(request, response);
				System.out.println("Invalid");
			}	
			
		}
		
		
		
		
	}

}
