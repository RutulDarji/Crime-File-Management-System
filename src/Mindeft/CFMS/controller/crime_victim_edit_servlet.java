package Mindeft.CFMS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.crime_victimBean;
import Mindeft.CFMS.bean.crime_witnessBean;
import Mindeft.CFMS.dao.crime_victimDao;
import Mindeft.CFMS.dao.crime_witnessDao;

/**
 * Servlet implementation class crime_victim_edit_servlet
 */
public class crime_victim_edit_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String crime_victim_id=request.getParameter("crime_victim_id");
		//System.out.println("User id:" + user_type_id);
    	
	    crime_victimBean crime_victimBeanObj=crime_victimDao.getDatabyPK(crime_victim_id);
	    
	    
	    if(crime_victimBeanObj!=null)
	    {
	    	request.setAttribute("crime_victimBeanObj",crime_victimBeanObj);
	    	request.getRequestDispatcher("crime_victim_edit.jsp").forward(request, response); 
	    }
	    else
	    {
	    	request.getRequestDispatcher("crime_victim_list").forward(request, response);
	    }
		
	}

}
