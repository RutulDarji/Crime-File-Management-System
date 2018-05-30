package Mindeft.CFMS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.cityBean;
import Mindeft.CFMS.bean.stateBean;
import Mindeft.CFMS.dao.cityDao;
import Mindeft.CFMS.dao.stateDao;

/**
 * Servlet implementation class city_edit_servlet
 */
public class city_edit_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String city_id=request.getParameter("city_id");
		System.out.println("City id:" + city_id);
    	
	    cityBean cityBeanObj=cityDao.getDatabyPK(city_id);
	    
	    if(cityBeanObj!=null)
	    {
	    	request.setAttribute("cityBeanObj",cityBeanObj);
	    	request.getRequestDispatcher("city_edit_jsp.jsp").forward(request, response); 	
	    }
	    else
	    {
	    	request.getRequestDispatcher("cityList").forward(request, response);
	    }
		
	}

}
