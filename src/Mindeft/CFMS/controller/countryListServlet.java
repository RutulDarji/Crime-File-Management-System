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
 * Servlet implementation class countryListServlet
 */
public class countryListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<countryBean> countrylist=new countryDao().select();
		request.setAttribute("countrylist", countrylist);
		request.getRequestDispatcher("countrylist_jsp.jsp").forward(request, response);
		
	}

}
