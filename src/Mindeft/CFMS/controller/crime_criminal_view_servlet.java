package Mindeft.CFMS.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.crime_criminalBean;
import Mindeft.CFMS.dao.crime_criminalDao;

/**
 * Servlet implementation class crime_criminal_view_servlet
 */
public class crime_criminal_view_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String crime_criminal_id=request.getParameter("crime_criminal_id");
		List<crime_criminalBean> crime_criminalBeanlist=new crime_criminalDao().view_particular(crime_criminal_id);
		request.setAttribute("crime_criminalBeanlist", crime_criminalBeanlist);
		request.getRequestDispatcher("crime_criminal_view.jsp").forward(request, response);
		
	}

}
