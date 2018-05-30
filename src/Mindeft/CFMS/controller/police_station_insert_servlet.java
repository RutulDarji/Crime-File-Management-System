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
import Mindeft.CFMS.util.StringValidationUtility;
import Mindeft.CFMS.util.nameValidationUtility;
import Mindeft.CFMS.util.policeStation_contact_utility;
import Mindeft.CFMS.util.police_station_name_validation_utility;

/**
 * Servlet implementation class police_station_insert_servlet
 */
public class police_station_insert_servlet extends HttpServlet {
	
	String police_station_name,area_id,contact;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		police_station_name=request.getParameter("police_station_name");
		area_id=request.getParameter("area_id");
		contact=request.getParameter("contact");
		
		System.out.println(police_station_name);
		System.out.println(area_id);
		System.out.println(contact);
		
		boolean isError=false;
		
		police_station_Bean police_station_BeanObj=new police_station_Bean();
		
		if(police_station_name_validation_utility.isEmpty(police_station_name))
		{
			request.setAttribute("police_station_name", "<font color=red>*Enter Valid Police Station</font>");
			isError=true;
			police_station_BeanObj.setPolice_station_name(police_station_name);
		}
		else
		{
			police_station_BeanObj.setPolice_station_name(police_station_name);
		}
		
		if(StringValidationUtility.isEmpty(area_id))
		{
			request.setAttribute("area_id", "<font color=red>*Select Any Area</font>");
			isError=true;
		}
		
		if(policeStation_contact_utility.isEmpty(contact))
		{
			request.setAttribute("contact", "<font color=red>*Enter Valid Contact Number</font>");
			isError=true;
			police_station_BeanObj.setContact(contact);
		}
		else
		{
			police_station_BeanObj.setContact(contact);
		}
		
		if(isError)
		{
			request.setAttribute("police_station_BeanObj",police_station_BeanObj);
			request.getRequestDispatcher("police_station_jsp.jsp").forward(request, response);
		}
		else
		{
			police_station_BeanObj.setArea_id(area_id);
			police_station_BeanObj.setPolice_station_name(police_station_name);
			police_station_BeanObj.setContact(contact);
			
			
			
			if(police_stationDao.insert(police_station_BeanObj));
			{
				System.out.println("Successful");
				request.getRequestDispatcher("police_station_list").forward(request, response);
			}
			
		}
		
		
		
	}

}
