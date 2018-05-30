package Mindeft.CFMS.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.query_response_Bean;
import Mindeft.CFMS.dao.query_response_Dao;

/**
 * Servlet implementation class query_response_view_servlet
 */
public class query_response_view_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String query_response_id=request.getParameter("query_response_id");
		List<query_response_Bean> query_response_Beanlist=new query_response_Dao().view_individual(query_response_id);
		request.setAttribute("query_response_Beanlist", query_response_Beanlist);
		request.getRequestDispatcher("query_response_view.jsp").forward(request, response);
	}

}
