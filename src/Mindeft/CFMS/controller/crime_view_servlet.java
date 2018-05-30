package Mindeft.CFMS.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.crimeBean;
import Mindeft.CFMS.dao.crimeDao;

/**
 * Servlet implementation class crime_view_servlet
 */
public class crime_view_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String crime_id=request.getParameter("crime_id");

		List<crimeBean> crimeBeanlist=new crimeDao().view_particular(crime_id);
		request.setAttribute("crimeBeanlist", crimeBeanlist);
		request.getRequestDispatcher("crime_view_jsp.jsp").forward(request, response);
	}

}
