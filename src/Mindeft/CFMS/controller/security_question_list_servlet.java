package Mindeft.CFMS.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.complain_status_Bean;
import Mindeft.CFMS.bean.security_questionBean;
import Mindeft.CFMS.dao.complain_status_Dao;
import Mindeft.CFMS.dao.security_questionDao;

/**
 * Servlet implementation class security_question_list_servlet
 */
public class security_question_list_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<security_questionBean> security_question_list=new security_questionDao().select();
		request.setAttribute("security_question_list", security_question_list);
		request.getRequestDispatcher("security_question_list_jsp.jsp").forward(request, response);
		
	}

}
