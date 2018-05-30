package Mindeft.CFMS.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.queryBean;
import Mindeft.CFMS.bean.user_typeBean;
import Mindeft.CFMS.dao.queryDao;
import Mindeft.CFMS.dao.user_type_Dao;

/**
 * Servlet implementation class query_select_servlet
 */
public class query_select_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String query_id=request.getParameter("query_id");
		
		List<queryBean> queryBeanlist=new queryDao().select();
		request.setAttribute("queryBeanlist", queryBeanlist);
		request.getRequestDispatcher("query_list_jsp.jsp").forward(request, response);
	}

}
