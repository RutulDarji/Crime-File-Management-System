package Mindeft.CFMS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.util.StringValidationUtility;

/**
 * Servlet implementation class otp_check_servlet
 */
public class otp_check_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		boolean isError=false;
		
		String original_otp=send_otp.getotp();
		String otp=request.getParameter("otp");
		String email=request.getParameter("email");
		
		System.out.println("Original" + original_otp);
		System.out.println("OTP" + otp);
		
		
		if(StringValidationUtility.isEmpty(email))
		{
			//System.out.println("C name::" + country_name);
			request.setAttribute("email", "<font color=red>*Enter Valid  OTP</font>");
			isError=true;
		}
		
		if(StringValidationUtility.isEmpty(otp))
		{
			//System.out.println("C name::" + country_name);
			request.setAttribute("otp", "<font color=red>*Enter Valid  email</font>");
			isError=true;
		}
		else
		{
			if(original_otp.equals(otp))
			{
				System.out.println("valid");
				//response.sendRedirect("user_table.jsp");
			}
			else
			{
				request.setAttribute("otp", "<font color=red>*Enter Valid  OTP</font>");
				isError=true;
				System.out.println("Invalid");
			}
		}
		
		if(isError)
		{
			request.getRequestDispatcher("user_email_verification.jsp").forward(request, response);
		}
		else
		{
				System.out.println("valid");
				response.sendRedirect("user_table.jsp");
			
		}
		
		
		
		
		
	}

}
