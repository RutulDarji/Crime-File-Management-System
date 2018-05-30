package Mindeft.CFMS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Mindeft.CFMS.bean.countryBean;
import Mindeft.CFMS.dao.countryDao;

/**
 * Servlet implementation class country_edit_servlet
 */
public class country_edit_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	String country_id=request.getParameter("country_id");
		System.out.println("id:" + country_id);
    	
	    countryBean countryBeanObj=countryDao.getDatabyPK(country_id);
	    
	    if(countryBeanObj!=null)
	    {
	    	request.setAttribute("countryBeanObj",countryBeanObj);
	    	request.getRequestDispatcher("country_edit_jsp.jsp").forward(request, response); 
	    	//response.sendRedirect("registerList");
	    }
	    else
	    {
	    	request.getRequestDispatcher("countryList").forward(request, response);
	    }	
    }

}
