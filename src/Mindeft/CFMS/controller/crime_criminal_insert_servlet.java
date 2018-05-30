package Mindeft.CFMS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.AreaBean;
import Mindeft.CFMS.bean.crime_criminalBean;
import Mindeft.CFMS.dao.areaDao;
import Mindeft.CFMS.dao.crime_criminalDao;
import Mindeft.CFMS.util.StringValidationUtility;
import Mindeft.CFMS.util.ZipCodeValidationUtility;
import Mindeft.CFMS.util.nameValidationUtility;

/**
 * Servlet implementation class crime_criminal_insert_servlet
 */
public class crime_criminal_insert_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String crime_criminal_id,crime_id,criminal_id;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		crime_id=request.getParameter("crime_id");
		criminal_id=request.getParameter("criminal_id");
				
		System.out.println("Crime id:"+crime_id);
		System.out.println("Criminal id:"+criminal_id);
		
		boolean isError=false;

		//areaBean areaBeanObj=new areaBean(); 
		crime_criminalBean crime_criminalBeanObj=new crime_criminalBean();
		
		
		if(StringValidationUtility.isEmpty(crime_id))
		{
			request.setAttribute("crime_id", "<font color=red>*Select Any Crime</font>");
			isError=true;
		}
		
		if(StringValidationUtility.isEmpty(criminal_id))
		{
			request.setAttribute("criminal_id", "<font color=red>*Select Any Criminal</font>");
			isError=true;
		}
		if(isError)
		{
			request.getRequestDispatcher("crime_criminal_table.jsp").forward(request, response);
		}
		else
		{
			crime_criminalBeanObj.setCrime_id(crime_id);
			crime_criminalBeanObj.setCriminal_id(criminal_id);
			
			System.out.println(crime_criminalBeanObj.getCrime_id());
			System.out.println(crime_criminalBeanObj.getCriminal_id());
			
			if(crime_criminalDao.insert(crime_criminalBeanObj))
			{
				System.out.println("Insert");
				request.getRequestDispatcher("crime_criminal_list").forward(request, response);
			}
			
		}
		
	}

}
