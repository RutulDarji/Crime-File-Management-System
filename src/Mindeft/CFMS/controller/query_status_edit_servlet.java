package Mindeft.CFMS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.complain_status_Bean;
import Mindeft.CFMS.bean.query_status_Bean;
import Mindeft.CFMS.dao.complain_status_Dao;
import Mindeft.CFMS.dao.query_status_Dao;

/**
 * Servlet implementation class query_status_edit_servlet
 */
public class query_status_edit_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  @Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	  String query_status_id=request.getParameter("query_status_id");
		System.out.println("query_status_id:" + query_status_id);
  	
		query_status_Bean query_status_BeanObj=query_status_Dao.getDatabyPK(query_status_id);
	    
	    if(query_status_BeanObj!=null)
	    {
	    	request.setAttribute("query_status_BeanObj",query_status_BeanObj);
	    	request.getRequestDispatcher("query_status_edit_jsp.jsp").forward(request, response); 
	    	//response.sendRedirect("registerList");
	    }
	    else
	    {
	    	request.getRequestDispatcher("query_status_list").forward(request, response);
	    }
  }

}
