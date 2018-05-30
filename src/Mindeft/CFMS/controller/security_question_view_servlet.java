package Mindeft.CFMS.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.security_questionBean;
import Mindeft.CFMS.dao.security_questionDao;

/**
 * Servlet implementation class security_question_view_servlet
 */
public class security_question_view_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String security_question_id=request.getParameter("security_question_id");
		List<security_questionBean> security_question_list=new security_questionDao().view_particular(security_question_id);
		request.setAttribute("security_question_list", security_question_list);
		request.getRequestDispatcher("security_question_view_jsp.jsp").forward(request, response);
		
	}

}
