package Mindeft.CFMS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Mindeft.CFMS.bean.crimeBean;
import Mindeft.CFMS.dao.crimeDao;
import Mindeft.CFMS.util.StringValidationUtility;
import Mindeft.CFMS.util.date_validation_utility;

/**
 * Servlet implementation class user_crime_page_servlet
 */
public class user_crime_page_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String CrimeType_Id,area_id,crime_date,crime_details,location_description,crime_id;
	String country_name,state,city;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		CrimeType_Id=request.getParameter("CrimeType_Id");
		area_id=request.getParameter("area_id");
		crime_date=request.getParameter("crime_date");
		crime_details=request.getParameter("crime_details");
		location_description=request.getParameter("location_description");
		country_name=request.getParameter("country_name");
		state=request.getParameter("state");
		city=request.getParameter("city");
		
		boolean isError=false;
		
		crimeBean crimeBeanObj=new crimeBean(); 
		
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
			request.setAttribute("city", "<font color=red>*Select Any City</font>");
			isError=true;
		}
		
		
		if(date_validation_utility.isEmpty(crime_date))
		{
			request.setAttribute("crime_date", "<font color=red>*Select Valid Date</font>");
			isError=true;
		}
		
		if(StringValidationUtility.isEmpty(CrimeType_Id))
		{
			request.setAttribute("CrimeType_Id", "<font color=red>*Select Any Crime</font>");
			isError=true;
		}
		
		
		
		if(StringValidationUtility.isEmpty(area_id))
		{
			request.setAttribute("area_id", "<font color=red>*Select Any Area</font>");
			isError=true;
		}
		
		if(StringValidationUtility.isEmpty(crime_details))
		{
			request.setAttribute("crime_details", "<font color=red>*Enter Crime Details</font>");
			isError=true;
			crimeBeanObj.setCrime_details(crime_details);
		}
		else
		{
			crimeBeanObj.setCrime_details(crime_details);
		}
		
		
		if(StringValidationUtility.isEmpty(location_description))
		{
			request.setAttribute("location_description", "<font color=red>*Enter Location Description</font>");
			isError=true;
			crimeBeanObj.setLocation_description(location_description);
		}
		else
		{
			crimeBeanObj.setLocation_description(location_description);
		}
		
		if(isError)
		{
			request.setAttribute("crimeBeanObj", crimeBeanObj);
			request.getRequestDispatcher("user_crime_page.jsp").forward(request, response);
		}
		else
		{

			crimeBeanObj.setCrimeType_Id(CrimeType_Id);
			crimeBeanObj.setArea_id(area_id);
			crimeBeanObj.setCrime_date(crime_date);
			crimeBeanObj.setCrime_details(crime_details);
			crimeBeanObj.setLocation_description(location_description);
			
			
			if(crimeDao.insert(crimeBeanObj));
			{
				HttpSession crimeObj=request.getSession();
				crimeObj.setAttribute("crimeObj", crimeBeanObj);
				System.out.println("Successful");
				request.getRequestDispatcher("user_complain.jsp").forward(request, response);
			}
			
		}
		
		
	}

}
