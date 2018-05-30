package Mindeft.CFMS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.crimeBean;
import Mindeft.CFMS.bean.user_typeBean;
import Mindeft.CFMS.dao.crimeDao;
import Mindeft.CFMS.dao.user_type_Dao;

/**
 * Servlet implementation class crime_edit_servlet
 */
public class crime_edit_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String crime_id=request.getParameter("crime_id");
		//System.out.println("User id:" + user_type_id);
    	
	    crimeBean crimeBeanObj=crimeDao.getDatabyPK(crime_id);
	    
	    
	    if(crimeBeanObj!=null)
	    {
	    	request.setAttribute("crimeBeanObj",crimeBeanObj);
	    	request.getRequestDispatcher("crime_edit_jsp.jsp").forward(request, response); 
	    }
	    else
	    {
	    	request.getRequestDispatcher("crime_list").forward(request, response);
	    }
		
	}

}
