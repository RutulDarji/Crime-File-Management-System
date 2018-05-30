package Mindeft.CFMS.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.crime_accuseBean;
import Mindeft.CFMS.dao.crime_accuseDao;

/**
 * Servlet implementation class crime_accuse_view_servlet
 */
public class crime_accuse_view_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String crime_accuse_id=request.getParameter("crime_accuse_id");
		List<crime_accuseBean> crime_accuseBeanlist=new crime_accuseDao().view_particular(crime_accuse_id);
		request.setAttribute("crime_accuseBeanlist", crime_accuseBeanlist);
		request.getRequestDispatcher("crime_accuse_view.jsp").forward(request, response);
		
	}

}
