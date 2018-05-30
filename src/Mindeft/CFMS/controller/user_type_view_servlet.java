package Mindeft.CFMS.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.user_typeBean;
import Mindeft.CFMS.dao.user_type_Dao;

/**
 * Servlet implementation class user_type_view_servlet
 */
public class user_type_view_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String user_type_id=request.getParameter("user_type_id");
		List<user_typeBean> user_typelist=new user_type_Dao().view_particular(user_type_id);
		request.setAttribute("user_typelist", user_typelist);
		request.getRequestDispatcher("user_type_view_jsp.jsp").forward(request, response);
	}

}
