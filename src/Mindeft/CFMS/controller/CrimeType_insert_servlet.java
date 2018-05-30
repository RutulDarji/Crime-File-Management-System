package Mindeft.CFMS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.CrimeTypeBean;
import Mindeft.CFMS.dao.CrimeTypeDao;
import Mindeft.CFMS.dao.cityDao;
import Mindeft.CFMS.util.StringValidationUtility;
import Mindeft.CFMS.util.crime_type_validation_utility;
import Mindeft.CFMS.util.nameValidationUtility;

/**
 * Servlet implementation class CrimeType_insert_servlet
 */
public class CrimeType_insert_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	int CrimeTypeId;
	//String CrimeType=new String();
	//String CrimeDetails=new String();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Crimetypes=request.getParameter("CrimeTypes");
		String Crimedetails=request.getParameter("CrimeDetails");
		
		System.out.println("Details "+Crimedetails);
		CrimeTypeBean CrimeTypeBeanObj = new CrimeTypeBean();

		boolean isError = false;
		
		
		if(crime_type_validation_utility.isEmpty(Crimetypes))
		{
			//System.out.println("C name::" + country_name);
			request.setAttribute("CrimeType","<font color=red>* Enter Valid Crime</font>");
			isError = true;
		}
		
		if(StringValidationUtility.isEmpty(Crimedetails))
		{
			//System.out.println("C name::" + country_name);
			request.setAttribute("CrimeDetail","<font color=red>* Details Required</font>");
			isError = true;
		}
		
		
		if(isError)
		{
			
			request.getRequestDispatcher("CrimeTypes_jsp.jsp").forward(request, response);
		}
		else
		{
			CrimeTypeBeanObj.setCrimeType(Crimetypes);
			CrimeTypeBeanObj.setCrimeDetails(Crimedetails);
			
			if(new CrimeTypeDao().insert(CrimeTypeBeanObj));
			{
				System.out.println("Successful");
				request.getRequestDispatcher("CrimeType_list").forward(request, response);
			}
			
		}
		
		
	
		
		
		
		
		
	}

}
