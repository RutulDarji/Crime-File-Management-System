package Mindeft.CFMS.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.crime_victimBean;
import Mindeft.CFMS.dao.crime_victimDao;

/**
 * Servlet implementation class crime_victim_view_servlet
 */
public class crime_victim_view_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String crime_victim_id=request.getParameter("crime_victim_id");
		List<crime_victimBean> crime_victimBeanlist=new crime_victimDao().view_particular(crime_victim_id);
		request.setAttribute("crime_victimBeanlist", crime_victimBeanlist);
		request.getRequestDispatcher("crime_victim_view.jsp").forward(request, response);
	}

}
