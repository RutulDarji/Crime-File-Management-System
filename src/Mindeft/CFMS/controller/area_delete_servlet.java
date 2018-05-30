package Mindeft.CFMS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.AreaBean;
import Mindeft.CFMS.dao.CrimeTypeDao;
import Mindeft.CFMS.dao.areaDao;

/**
 * Servlet implementation class area_delete_servlet
 */
public class area_delete_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String area_id=request.getParameter("area_id");
		
		System.out.println("area_id is: " + area_id);
		
		if(new areaDao().delete(area_id)){
			request.getRequestDispatcher("areaList").forward(request, response);
		}else{
			request.getRequestDispatcher("areaList").forward(request, response);
		}
	}

}
