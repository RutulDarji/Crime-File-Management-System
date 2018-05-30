package Mindeft.CFMS.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.dao.police_stationDao;
import Mindeft.CFMS.dao.user_type_Dao;

/**
 * Servlet implementation class police_station_delete_servlet
 */
public class police_station_delete_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String police_station_id=request.getParameter("police_station_id");
		System.out.println("police_station_id::" + police_station_id);
	
	
		if(new police_stationDao().delete(police_station_id)){
			request.getRequestDispatcher("police_station_list").forward(request, response);
		}else{
			request.getRequestDispatcher("police_station_list").forward(request, response);
		
		}
	
	
	}
	
}

