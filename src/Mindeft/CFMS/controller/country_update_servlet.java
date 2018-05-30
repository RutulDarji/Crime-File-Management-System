package Mindeft.CFMS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.countryBean;
import Mindeft.CFMS.dao.countryDao;
import Mindeft.CFMS.util.StringValidationUtility;
import Mindeft.CFMS.util.country_name_validation_utility;
import Mindeft.CFMS.util.nameValidationUtility;

/**
 * Servlet implementation class country_update_servlet
 */
public class country_update_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String country_id=request.getParameter("country_id");
		String country_name=new String();
		country_name=request.getParameter("country_name");
		
		boolean isError=false;
		
		countryBean countryBeanobj=new countryBean();
		
		System.out.println("C name::" + country_name);
		
		if(country_name_validation_utility.isEmpty(country_name))
		{
			//System.out.println("C name::" + country_name);
			request.setAttribute("country_name", "<font color=red>*Enter Valid  Country Name</font>");
			isError=true;
		}
		
		
		if(isError)
		{
			
			request.getRequestDispatcher("country_table_jsp.jsp").forward(request, response);
		}
		else
		{
			System.out.println("id" + country_id);
			int id=Integer.parseInt(country_id);
			countryBeanobj.setCountry_name(country_name);
			countryBeanobj.setCountry_id(id);
			
			
			if(new countryDao().update(countryBeanobj));
			{
				request.getRequestDispatcher("countryList").forward(request, response);
			}
			
		}
		
	}

}
