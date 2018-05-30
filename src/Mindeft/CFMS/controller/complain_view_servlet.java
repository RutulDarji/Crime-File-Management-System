package Mindeft.CFMS.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.complainBean;
import Mindeft.CFMS.dao.complainDao;

/**
 * Servlet implementation class complain_view_servlet
 */
public class complain_view_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String complain_id=request.getParameter("complain_id");
		System.out.println("complain_id:" + complain_id);
		
		List<complainBean> complainBeanlist=new complainDao().view_particular(complain_id);
		request.setAttribute("complainBeanlist", complainBeanlist);
		request.getRequestDispatcher("complain_view_jsp.jsp").forward(request, response);
	}

}
