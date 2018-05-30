package Mindeft.CFMS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.dao.security_questionDao;
import Mindeft.CFMS.dao.stateDao;

/**
 * Servlet implementation class security_question_delete_servlet
 */
public class security_question_delete_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String security_question_id=request.getParameter("security_question_id");
		System.out.println("security_question_id::" + security_question_id);
		
		if(new security_questionDao().delete(security_question_id)){
			request.getRequestDispatcher("security_question_list").forward(request, response);
		}else{
			request.getRequestDispatcher("security_question_list").forward(request, response);
			
		}
	}

}
