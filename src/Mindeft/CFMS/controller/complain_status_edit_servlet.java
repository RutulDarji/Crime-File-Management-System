package Mindeft.CFMS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.complain_status_Bean;
import Mindeft.CFMS.bean.countryBean;
import Mindeft.CFMS.dao.complain_status_Dao;
import Mindeft.CFMS.dao.countryDao;

/**
 * Servlet implementation class complain_status_edit_servlet
 */
public class complain_status_edit_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String complain_status_id=request.getParameter("complain_status_id");
		System.out.println("complain_status_id:" + complain_status_id);
    	
	    complain_status_Bean complain_status_BeanObj=complain_status_Dao.getDatabyPK(complain_status_id);
	    
	    if(complain_status_BeanObj!=null)
	    {
	    	request.setAttribute("complain_status_BeanObj",complain_status_BeanObj);
	    	request.getRequestDispatcher("complain_status_edit_jsp.jsp").forward(request, response); 
	    	//response.sendRedirect("registerList");
	    }
	    else
	    {
	    	request.getRequestDispatcher("complain_status_list").forward(request, response);
	    }
		
	}

}
