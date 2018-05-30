package Mindeft.CFMS.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.queryBean;
import Mindeft.CFMS.dao.queryDao;

/**
 * Servlet implementation class query_view_servlet
 */
public class query_view_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String query_id=request.getParameter("query_id");
		List<queryBean> queryBeanlist=new queryDao().view_particular(query_id);
		request.setAttribute("queryBeanlist", queryBeanlist);
		request.getRequestDispatcher("query_view_jsp.jsp").forward(request, response);
	
	
	}

}
