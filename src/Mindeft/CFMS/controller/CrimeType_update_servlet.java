package Mindeft.CFMS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.CrimeTypeBean;
import Mindeft.CFMS.dao.CrimeTypeDao;
import Mindeft.CFMS.util.StringValidationUtility;
import Mindeft.CFMS.util.crime_type_validation_utility;
import Mindeft.CFMS.util.nameValidationUtility;

/**
 * Servlet implementation class CrimeType_update_servlet
 */
public class CrimeType_update_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String CrimeType_id=request.getParameter("CrimeType_id");
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
			CrimeTypeBeanObj.setCrimeTypeId(Integer.parseInt(CrimeType_id));
			
			if(new CrimeTypeDao().update(CrimeTypeBeanObj));
			{
				System.out.println("Successful");
				request.getRequestDispatcher("CrimeType_list").forward(request, response);
			}
			
		}
		
	}

}
