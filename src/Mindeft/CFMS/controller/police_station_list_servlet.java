package Mindeft.CFMS.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.police_station_Bean;
import Mindeft.CFMS.bean.user_typeBean;
import Mindeft.CFMS.dao.police_stationDao;
import Mindeft.CFMS.dao.user_type_Dao;

/**
 * Servlet implementation class police_station_list_servlet
 */
public class police_station_list_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<police_station_Bean> police_stationlist=new police_stationDao().select();
		request.setAttribute("police_stationlist", police_stationlist);
		request.getRequestDispatcher("police_station_list_jsp.jsp").forward(request, response);
		
	}

}
