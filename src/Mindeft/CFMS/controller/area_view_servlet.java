package Mindeft.CFMS.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.AreaBean;
import Mindeft.CFMS.dao.areaDao;

/**
 * Servlet implementation class area_view_servlet
 */
public class area_view_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String area_id=request.getParameter("area_id");	
		List<AreaBean> AreaBeanlist=areaDao.viewParticular(area_id);
	    request.setAttribute("AreaBeanlist", AreaBeanlist);
		request.getRequestDispatcher("area_view.jsp").forward(request, response);
	    
	}

}
