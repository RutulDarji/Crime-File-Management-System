package Mindeft.CFMS.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.criminalBean;
import Mindeft.CFMS.dao.criminalDao;

/**
 * Servlet implementation class user_criminal_view_servlet
 */
public class user_criminal_view_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String criminal_id=request.getParameter("criminal_id");
		System.out.println("criminal_id:" + criminal_id);
		
		List<criminalBean> criminalBeanlist=new criminalDao().view_particular(criminal_id);
		request.setAttribute("criminalBeanlist", criminalBeanlist);
		request.getRequestDispatcher("user_criminal_view.jsp").forward(request, response);
		
	}

}
