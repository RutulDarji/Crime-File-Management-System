package Mindeft.CFMS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.crime_witnessBean;
import Mindeft.CFMS.bean.missing_personBean;
import Mindeft.CFMS.dao.crime_witnessDao;
import Mindeft.CFMS.dao.missing_personDao;

/**
 * Servlet implementation class crime_witness_edit_servlet
 */
public class crime_witness_edit_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String crime_witness_id=request.getParameter("crime_witness_id");
		//System.out.println("User id:" + user_type_id);
    	
	    crime_witnessBean crime_witnessBeanObj=crime_witnessDao.getDatabyPK(crime_witness_id);
	    
	    
	    if(crime_witnessBeanObj!=null)
	    {
	    	request.setAttribute("crime_witnessBeanObj",crime_witnessBeanObj);
	    	request.getRequestDispatcher("crime_witness_edit.jsp").forward(request, response); 
	    }
	    else
	    {
	    	request.getRequestDispatcher("crime_witness_list").forward(request, response);
	    }
	}

}
