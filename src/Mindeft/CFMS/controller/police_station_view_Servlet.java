package Mindeft.CFMS.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.police_station_Bean;
import Mindeft.CFMS.dao.police_stationDao;

/**
 * Servlet implementation class police_station_view_Servlet
 */
public class police_station_view_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String police_station_id=request.getParameter("police_station_id");
		List<police_station_Bean> police_stationlist=new police_stationDao().view_paricular(police_station_id);
		request.setAttribute("police_stationlist", police_stationlist);
		request.getRequestDispatcher("police_station_view.jsp").forward(request, response);
		
	}

}
