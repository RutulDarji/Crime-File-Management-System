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
import Mindeft.CFMS.util.StringValidationUtility;
import Mindeft.CFMS.util.city_name_validation_utility;
import Mindeft.CFMS.util.nameValidationUtility;

/**
 * Servlet implementation class city_insert_servlet
 */
public class city_insert_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	String city_name,city_id,state_id;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		city_name=request.getParameter("city_name");
		state_id=request.getParameter("state_name");
		
		boolean isError=false;
		
		cityBean cityBeanobj=new cityBean();
		
		System.out.println("City name::" + city_name);
		
		if(city_name_validation_utility.isEmpty(city_name))
		{
	
			request.setAttribute("city_name", "<font color=red>*Enter Valid city Name</font>");
			isError=true;
			cityBeanobj.setCity_name(city_name);
		}
		else
		{
			cityBeanobj.setCity_name(city_name);
		}
		
		if(StringValidationUtility.isEmpty(state_id))
		{
			//System.out.println("C name::" + country_name);
			request.setAttribute("state_name", "<font color=red>*Select State</font>");
			isError=true;
		}
		
		
		if(isError)
		{
			
			request.setAttribute("cityBeanobj",cityBeanobj);
			request.getRequestDispatcher("city_table_jsp.jsp").forward(request, response);
		}
		else
		{

			cityBeanobj.setCity_name(city_name);
			cityBeanobj.setState_id(state_id);
			
			if(cityDao.insert(cityBeanobj));
			{
				System.out.println("Successful");
				request.getRequestDispatcher("cityList").forward(request, response);
			}
			
		}
		
		
	}

}
