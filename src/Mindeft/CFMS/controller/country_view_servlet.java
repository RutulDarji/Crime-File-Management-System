package Mindeft.CFMS.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.countryBean;
import Mindeft.CFMS.dao.countryDao;

/**
 * Servlet implementation class country_view_servlet
 */
public class country_view_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String country_id=request.getParameter("country_id");
		List<countryBean> countrylist=new countryDao().view_particular(country_id);
		request.setAttribute("countrylist", countrylist);
		request.getRequestDispatcher("country_view.jsp").forward(request, response);
	}

}
