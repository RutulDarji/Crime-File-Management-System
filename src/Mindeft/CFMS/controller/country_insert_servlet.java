package Mindeft.CFMS.controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.util.StringValidationUtility;
import Mindeft.CFMS.util.country_name_validation_utility;
import Mindeft.CFMS.util.nameValidationUtility;
import Mindeft.CFMS.bean.countryBean;
import Mindeft.CFMS.dao.countryDao;

/**
 * Servlet implementation class country_insert_servlet
 */
public class country_insert_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			int  country_id;
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
				countryBeanobj.setCountry_name(country_name);
			}
			else
			{
				countryBeanobj.setCountry_name(country_name);
			}
			
			
			if(isError)
			{
				
				request.setAttribute("countryBeanobj", countryBeanobj);
				request.getRequestDispatcher("country_table_jsp.jsp").forward(request, response);
			}
			else
			{
				countryBeanobj.setCountry_name(country_name);
				
				if(countryDao.insert(countryBeanobj));
				{
					request.getRequestDispatcher("countryList").forward(request, response);
				}
				
			}
			
			
	}

}
