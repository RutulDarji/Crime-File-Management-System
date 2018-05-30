package Mindeft.CFMS.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.crime_witnessBean;
import Mindeft.CFMS.dao.crime_witnessDao;

/**
 * Servlet implementation class crime_witness_view_servlet
 */
public class crime_witness_view_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String crime_witness_id=request.getParameter("crime_witness_id");
	
		List<crime_witnessBean> crime_witnessBeanlist=new crime_witnessDao().view_particular(crime_witness_id);
		request.setAttribute("crime_witnessBeanlist", crime_witnessBeanlist);
		request.getRequestDispatcher("crime_witness_view.jsp").forward(request, response);
	}

}
