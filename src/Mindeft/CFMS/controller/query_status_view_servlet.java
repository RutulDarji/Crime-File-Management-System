package Mindeft.CFMS.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.query_status_Bean;
import Mindeft.CFMS.dao.query_status_Dao;

/**
 * Servlet implementation class query_status_view_servlet
 */
public class query_status_view_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String query_status_id=request.getParameter("query_status_id");
		List<query_status_Bean> query_status_list=new query_status_Dao().view_particular(query_status_id);
		request.setAttribute("query_status_list", query_status_list);
		request.getRequestDispatcher("query_status_view_jsp.jsp").forward(request, response);
		
	}

}
