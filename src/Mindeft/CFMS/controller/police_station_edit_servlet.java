package Mindeft.CFMS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.police_station_Bean;
import Mindeft.CFMS.bean.user_typeBean;
import Mindeft.CFMS.dao.police_stationDao;
import Mindeft.CFMS.dao.user_type_Dao;

/**
 * Servlet implementation class police_station_edit_servlet
 */
public class police_station_edit_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String police_station_id=request.getParameter("police_station_id");
		//System.out.println("User id:" + user_type_id);
    	
	    police_station_Bean police_station_BeanObj=police_stationDao.getDatabyPK(police_station_id);
	    
	    
	    if(police_station_BeanObj!=null)
	    {
	    	request.setAttribute("police_station_BeanObj",police_station_BeanObj);
	    	request.getRequestDispatcher("police_station_edit_jsp.jsp").forward(request, response); 
	    }
	    else
	    {
	    	request.getRequestDispatcher("police_station_list").forward(request, response);
	    }
		
	}

}
