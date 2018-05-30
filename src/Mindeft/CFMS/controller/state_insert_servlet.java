package Mindeft.CFMS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.countryBean;
import Mindeft.CFMS.bean.stateBean;
import Mindeft.CFMS.dao.countryDao;
import Mindeft.CFMS.dao.stateDao;
import Mindeft.CFMS.util.StringValidationUtility;
import Mindeft.CFMS.util.nameValidationUtility;
import Mindeft.CFMS.util.state_name_validation_utility;

/**
 * Servlet implementation class state_insert_servlet
 */
public class state_insert_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	String state_id,state_name,country_id;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		state_name=request.getParameter("state_name");
		country_id=request.getParameter("country_name");
		
		boolean isError=false;
		
		stateBean stateBeanobj=new stateBean();
		
		System.out.println("State name::" + state_name);
		
		if(state_name_validation_utility.isEmpty(state_name))
		{
			//System.out.println("C name::" + country_name);
			request.setAttribute("state_name", "<font color=red>*Enter Valid  State Name</font>");
			isError=true;
			stateBeanobj.setState_name(state_name);
		}
		else
		{
			stateBeanobj.setState_name(state_name);
		}
		
		if(StringValidationUtility.isEmpty(country_id))
		{
			//System.out.println("C name::" + country_name);
			request.setAttribute("country_name", "<font color=red>*Select Country</font>");
			isError=true;
		}
		
		
		if(isError)
		{
			request.setAttribute("stateBeanobj",stateBeanobj);
			request.getRequestDispatcher("state_table_jsp.jsp").forward(request, response);
		}
		else
		{
			stateBeanobj.setState_name(state_name);
			stateBeanobj.setCountry_id(country_id);
			
			if(stateDao.insert(stateBeanobj));
			{
				System.out.println("Successful");
				request.getRequestDispatcher("stateList").forward(request, response);
			}
			
		}
		
		
	}
}
