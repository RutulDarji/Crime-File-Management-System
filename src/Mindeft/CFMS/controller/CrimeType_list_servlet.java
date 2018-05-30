package Mindeft.CFMS.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.CrimeTypeBean;
import Mindeft.CFMS.bean.cityBean;
import Mindeft.CFMS.dao.CrimeTypeDao;
import Mindeft.CFMS.dao.cityDao;

/**
 * Servlet implementation class CrimeType_list_servlet
 */
public class CrimeType_list_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<CrimeTypeBean> CrimeTypelist=new CrimeTypeDao().select();
		request.setAttribute("CrimeTypelist", CrimeTypelist);
		request.getRequestDispatcher("CrimeType_list_jsp.jsp").forward(request, response);
		
	}

}
