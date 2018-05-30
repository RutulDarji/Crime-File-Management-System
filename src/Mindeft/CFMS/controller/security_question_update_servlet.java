package Mindeft.CFMS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.security_questionBean;
import Mindeft.CFMS.dao.security_questionDao;
import Mindeft.CFMS.util.StringValidationUtility;

/**
 * Servlet implementation class security_question_update_servlet
 */
public class security_question_update_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	String security_question_type,security_question_id;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		security_question_type=request.getParameter("security_question_type");
		security_question_id=request.getParameter("security_question_id");
		
		boolean isError=false;
		
		security_questionBean security_questionBeanObj=new security_questionBean(); 
		
		System.out.println("security_question_type::" + security_question_type);
		
		if(StringValidationUtility.isEmpty(security_question_type))
		{
			request.setAttribute("security_question_type", "<font color=red>*Enter Security Question</font>");
			isError=true;
		}
				
		if(isError)
		{
			
			request.getRequestDispatcher("security_question_table_jsp.jsp").forward(request, response);
		}
		else
		{

			security_questionBeanObj.setSecurity_question_type(security_question_type);
			security_questionBeanObj.setSecurity_question_id(security_question_id);	
			
			if(security_questionDao.update(security_questionBeanObj));
			{
				System.out.println("Successful");
				request.getRequestDispatcher("security_question_list").forward(request, response);
			}
			
		}
		
	}

}
