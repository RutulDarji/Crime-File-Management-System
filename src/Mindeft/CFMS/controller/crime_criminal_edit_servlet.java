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

/**
 * Servlet implementation class crime_criminal_edit_servlet
 */
public class crime_criminal_edit_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String crime_criminal_id=request.getParameter("crime_criminal_id");
		//System.out.println("User id:" + user_type_id);
    	
	    crime_criminalBean crime_criminalBeanObj=crime_criminalDao.getDatabyPK(crime_criminal_id);
	    
	    
	    if(crime_criminalBeanObj!=null)
	    {
	    	request.setAttribute("crime_criminalBeanObj",crime_criminalBeanObj);
	    	request.getRequestDispatcher("crime_criminal_edit.jsp").forward(request, response); 
	    }
	    else
	    {
	    	request.getRequestDispatcher("crime_criminal_list").forward(request, response);
	    }
		
	}

}
