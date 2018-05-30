package Mindeft.CFMS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.AreaBean;
import Mindeft.CFMS.bean.police_station_map;
import Mindeft.CFMS.dao.police_station_search_Dao;
import Mindeft.CFMS.util.StringValidationUtility;
import Mindeft.CFMS.util.area_name_validation_utility;

/**
 * Servlet implementation class police_station_search_servlet
 */
public class police_station_search_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	
	String country_name,state,city,area_id,police_station_id;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		country_name=request.getParameter("country_name");
		state=request.getParameter("state");
		city=request.getParameter("city");
		area_id=request.getParameter("area_id");
		police_station_id=request.getParameter("police_station_id");
		
		
		boolean isError=false;

		police_station_map police_station_mapObj=null; 
		
		if(StringValidationUtility.isEmpty(country_name))
		{
			request.setAttribute("country_name", "<font color=red>*Select Any Country</font>");
			isError=true;
		}
		
		if(StringValidationUtility.isEmpty(state))
		{
			request.setAttribute("state", "<font color=red>*Select Any State</font>");
			isError=true;
		}
		
		if(StringValidationUtility.isEmpty(city))
		{
			request.setAttribute("city", "<font color=red>*Select Any city</font>");
			isError=true;
		}
		
		if(StringValidationUtility.isEmpty(area_id))
		{
			request.setAttribute("area_id", "<font color=red>*Select Any area</font>");
			isError=true;
		}
		
		if(StringValidationUtility.isEmpty(police_station_id))
		{
			request.setAttribute("police_station_id", "<font color=red>*Select Any police station </font>");
			isError=true;
		}
		
		if(isError)
		{
			request.getRequestDispatcher("police_station_search.jsp").forward(request, response);
		}
		else
		{
			police_station_mapObj=police_station_search_Dao.find(police_station_id);
			
			if(police_station_mapObj!=null)
			{
				request.setAttribute("police_station_mapObj", police_station_mapObj);
				request.getRequestDispatcher("maps.jsp").forward(request, response);
			}
			else
			{
				System.out.println("NO SUCH RECORD");
			}
			
			
		}
		
		
		
	}

}
