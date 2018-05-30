package Mindeft.CFMS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.AreaBean;
import Mindeft.CFMS.dao.areaDao;
import Mindeft.CFMS.util.StringValidationUtility;
import Mindeft.CFMS.util.ZipCodeValidationUtility;
import Mindeft.CFMS.util.area_name_validation_utility;
import Mindeft.CFMS.util.nameValidationUtility;

/**
 * Servlet implementation class area_update_servlet
 */
public class area_update_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	String area_name,area_id,zipcode,city_id;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		area_id=request.getParameter("area_id");
		area_name=request.getParameter("area_name");
		zipcode=request.getParameter("zipcode");
		city_id=request.getParameter("city_id");
		
		boolean isError=false;

		//areaBean areaBeanObj=new areaBean(); 
		AreaBean areaBeanObj=new AreaBean();
		
		System.out.println("Area name::" + area_name);
		System.out.println("Zipcode::" + zipcode);
		System.out.println("City id::" + city_id);
		
		if(area_name_validation_utility.isEmpty(area_name))
		{
			request.setAttribute("area_name", "<font color=red>*Enter Valid Area Name</font>");
			isError=true;
		}
		
		if(StringValidationUtility.isEmpty(zipcode))
		{
			request.setAttribute("zipcode", "<font color=red>*Enter Zipcode</font>");
			isError=true;
		}
		else if(ZipCodeValidationUtility.isEmpty(zipcode))
		{
			request.setAttribute("zipcode", "<font color=red>*Invalid Zipcode</font>");
			isError=true;
		}
		
		if(StringValidationUtility.isEmpty(city_id))
		{
			request.setAttribute("city_id", "<font color=red>*Select Any City</font>");
			isError=true;
		}
		
		if(isError)
		{
			request.getRequestDispatcher("area_table_jsp.jsp").forward(request, response);
		}
		else
		{
			areaBeanObj.setArea_id(area_id);
			areaBeanObj.setCity_id(city_id);
			areaBeanObj.setArea_name(area_name);
			areaBeanObj.setZipcode(zipcode);
		
			if(new areaDao().update(areaBeanObj));
			{
				System.out.println("Successful");
				request.getRequestDispatcher("areaList").forward(request, response);
			}
			
		}
	}

}
