package Mindeft.CFMS.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.AreaBean;
import Mindeft.CFMS.bean.CrimeTypeBean;
import Mindeft.CFMS.dao.CrimeTypeDao;
import Mindeft.CFMS.dao.areaDao;

/**
 * Servlet implementation class areaList_servlet
 */
public class areaList_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<AreaBean> AreaBeanlist=new areaDao().select();
		request.setAttribute("AreaBeanlist", AreaBeanlist);
		request.getRequestDispatcher("area_list_jsp.jsp").forward(request, response);
	
	}
	

}
