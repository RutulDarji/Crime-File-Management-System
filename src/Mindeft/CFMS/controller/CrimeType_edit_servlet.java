package Mindeft.CFMS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.CrimeTypeBean;
import Mindeft.CFMS.bean.complain_status_Bean;
import Mindeft.CFMS.dao.CrimeTypeDao;
import Mindeft.CFMS.dao.complain_status_Dao;

/**
 * Servlet implementation class CrimeType_edit_servlet
 */
public class CrimeType_edit_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String CrimeType_id=request.getParameter("CrimeType_id");
		System.out.println("CrimeType_id:" + CrimeType_id);
    	
		CrimeTypeBean CrimeTypeBeanObj=CrimeTypeDao.getDatabyPK(CrimeType_id);
	     
	    
	    if(CrimeTypeBeanObj!=null)
	    {
	    	request.setAttribute("CrimeTypeBeanObj",CrimeTypeBeanObj);
	    	request.getRequestDispatcher("CrimeType_edit_jsp.jsp").forward(request, response); 
	    }
	    else
	    {
	    	request.getRequestDispatcher("CrimeType_list").forward(request, response);
	    }
		
	}

}
