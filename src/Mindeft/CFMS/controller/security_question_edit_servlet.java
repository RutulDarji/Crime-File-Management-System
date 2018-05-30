package Mindeft.CFMS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.security_questionBean;
import Mindeft.CFMS.bean.user_typeBean;
import Mindeft.CFMS.dao.security_questionDao;
import Mindeft.CFMS.dao.user_type_Dao;

/**
 * Servlet implementation class security_question_edit_servlet
 */
public class security_question_edit_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String security_question_id=request.getParameter("security_question_id");
		//System.out.println("User id:" + user_type_id);
    	
	    security_questionBean security_questionBeanObj=security_questionDao.getDatabyPK(security_question_id);
	    
	    
	    if(security_questionBeanObj!=null)
	    {
	    	request.setAttribute("security_questionBeanObj",security_questionBeanObj);
	    	request.getRequestDispatcher("security_question_edit_jsp.jsp").forward(request, response); 
	    }
	    else
	    {
	    	request.getRequestDispatcher("security_question_list").forward(request, response);
	    }
		
	}

}
