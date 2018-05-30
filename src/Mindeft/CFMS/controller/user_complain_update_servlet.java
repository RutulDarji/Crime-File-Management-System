package Mindeft.CFMS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.complainBean;
import Mindeft.CFMS.dao.complainDao;
import Mindeft.CFMS.util.StringValidationUtility;
import Mindeft.CFMS.util.date_validation_utility;

/**
 * Servlet implementation class user_complain_update_servlet
 */
public class user_complain_update_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String complain_details,complain_id;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		complain_details=request.getParameter("complain_details");
		complain_id=request.getParameter("complain_id");
				
		boolean isError=false;
		complainBean complainBeanObj=new complainBean(); 
		
		
		if(StringValidationUtility.isEmpty(complain_details))
		{
			request.setAttribute("complain_details", "<font color=red>*Enter Details</font>");
			isError=true;
		}
		
		if(isError)
		{
			request.getRequestDispatcher("user_complain_edit.jsp").forward(request, response);
		}
		else
		{
			//crime_id,police_station_id,complain_date,complain_details,complain_status_id,user_id
			
			complainBeanObj.setComplain_details(complain_details);
			complainBeanObj.setComplain_id(complain_id);
			
			if(complainDao.update_details(complainBeanObj));
			{
				System.out.println("Successful");
				request.getRequestDispatcher("user_complain_list.jsp").forward(request, response);
			}
			
		}
		
	}

}
