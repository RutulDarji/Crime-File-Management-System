package Mindeft.CFMS.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.complainBean;
import Mindeft.CFMS.bean.user_typeBean;
import Mindeft.CFMS.dao.complainDao;
import Mindeft.CFMS.dao.user_type_Dao;

/**
 * Servlet implementation class complain_list_servlet
 */
public class complain_list_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<complainBean> complainBeanlist=new complainDao().select();
		request.setAttribute("complainBeanlist", complainBeanlist);
		request.getRequestDispatcher("complain_list_jsp.jsp").forward(request, response);
		
	}

}
