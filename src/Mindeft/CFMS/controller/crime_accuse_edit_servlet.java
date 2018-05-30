package Mindeft.CFMS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.crime_accuseBean;
import Mindeft.CFMS.bean.crime_victimBean;
import Mindeft.CFMS.dao.crime_accuseDao;
import Mindeft.CFMS.dao.crime_victimDao;

/**
 * Servlet implementation class crime_accuse_edit_servlet
 */
public class crime_accuse_edit_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String crime_accuse_id=request.getParameter("crime_accuse_id");
		//System.out.println("User id:" + user_type_id);
    	
	    crime_accuseBean crime_accuseBeanObj=crime_accuseDao.getDatabyPK(crime_accuse_id);
	    
	    
	    if(crime_accuseBeanObj!=null)
	    {
	    	request.setAttribute("crime_accuseBeanObj",crime_accuseBeanObj);
	    	request.getRequestDispatcher("crime_accuse_edit.jsp").forward(request, response); 
	    }
	    else
	    {
	    	request.getRequestDispatcher("crime_accuse_list").forward(request, response);
	    }
		
	}

}
