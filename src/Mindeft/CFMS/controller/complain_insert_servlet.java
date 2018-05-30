package Mindeft.CFMS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.complainBean;
import Mindeft.CFMS.bean.user_typeBean;
import Mindeft.CFMS.dao.complainDao;
import Mindeft.CFMS.dao.user_type_Dao;
import Mindeft.CFMS.util.StringValidationUtility;
import Mindeft.CFMS.util.date_validation_utility;

/**
 * Servlet implementation class complain_insert_servlet
 */
public class complain_insert_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String crime_id,police_station_id,complain_date,complain_details,complain_status_id,user_id,complain_id;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		crime_id=request.getParameter("crime_id");
		police_station_id=request.getParameter("police_station_id");
		complain_date=request.getParameter("complain_date");
		complain_details=request.getParameter("complain_details");
		complain_status_id="3";
		user_id="1";
		
				
		boolean isError=false;

		complainBean complainBeanObj=new complainBean(); 
		
	
		if(StringValidationUtility.isEmpty(crime_id))
		{
			request.setAttribute("crime_id", "<font color=red>*Select Any Crime</font>");
			isError=true;
			complainBeanObj.setCrime_id(crime_id);
		}
		
		if(StringValidationUtility.isEmpty(police_station_id))
		{
			request.setAttribute("police_station_id", "<font color=red>*Select Any Police Station</font>");
			isError=true;
			complainBeanObj.setPolice_station_id(police_station_id);
		}
		
		
		if(date_validation_utility.isEmpty(complain_date))
		{
			request.setAttribute("complain_date", "<font color=red>*Select valid Date</font>");
			isError=true;
			complainBeanObj.setComplain_date(complain_date);
		}
		
		if(StringValidationUtility.isEmpty(complain_details))
		{
			request.setAttribute("complain_details", "<font color=red>*Enter Details</font>");
			isError=true;
			
		}
		else
		{
			complainBeanObj.setComplain_details(complain_details);
		}
		
		if(StringValidationUtility.isEmpty(complain_status_id))
		{
			request.setAttribute("complain_status_id", "<font color=red>*Select Status Id</font>");
			isError=true;
		}
		
		if(StringValidationUtility.isEmpty(user_id))
		{
			request.setAttribute("user_id", "<font color=red>*USer Id</font>");
			isError=true;
			
		}
		
		if(isError)
		{
			request.setAttribute("complainBeanObj", complainBeanObj);
			request.getRequestDispatcher("complain_table_jsp.jsp").forward(request, response);
			
		}
		else
		{
			//crime_id,police_station_id,complain_date,complain_details,complain_status_id,user_id
			complainBeanObj.setCrime_id(crime_id);
			complainBeanObj.setPolice_station_id(police_station_id);
			complainBeanObj.setComplain_date(complain_date);
			complainBeanObj.setComplain_details(complain_details);
			complainBeanObj.setComplain_status_id(complain_status_id);
			complainBeanObj.setUser_id(user_id);
			
			
			if(complainDao.insert(complainBeanObj));
			{
				System.out.println("Successful");
				request.getRequestDispatcher("complain_list").forward(request, response);
			}
			
		}
		
		
	}
		
		
	
	
}
