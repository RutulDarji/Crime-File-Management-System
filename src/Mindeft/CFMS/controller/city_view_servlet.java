package Mindeft.CFMS.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.cityBean;
import Mindeft.CFMS.dao.cityDao;

/**
 * Servlet implementation class city_view_servlet
 */
public class city_view_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String city_id=request.getParameter("city_id");
		List<cityBean> citylist=new cityDao().viewParticular(city_id);
		request.setAttribute("citylist", citylist);
		request.getRequestDispatcher("city_view.jsp").forward(request, response);
	}

}
