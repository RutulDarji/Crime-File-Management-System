package Mindeft.CFMS.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.CrimeTypeBean;
import Mindeft.CFMS.dao.CrimeTypeDao;

/**
 * Servlet implementation class CrimeType_view_servlet
 */
public class CrimeType_view_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String CrimeType_id=request.getParameter("CrimeType_id");
		System.out.println("CrimeType_id:" + CrimeType_id);
		
		List<CrimeTypeBean> CrimeTypelist=new CrimeTypeDao().view_particular(CrimeType_id);
		request.setAttribute("CrimeTypelist", CrimeTypelist);
		request.getRequestDispatcher("Crime_Type_view_jsp_.jsp").forward(request, response);
		
	}

}
