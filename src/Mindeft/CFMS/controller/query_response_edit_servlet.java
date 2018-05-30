package Mindeft.CFMS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.queryBean;
import Mindeft.CFMS.bean.query_response_Bean;
import Mindeft.CFMS.dao.queryDao;
import Mindeft.CFMS.dao.query_response_Dao;

/**
 * Servlet implementation class query_response_edit_servlet
 */
public class query_response_edit_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String query_response_id=request.getParameter("query_response_id");
		//System.out.println("User id:" + user_type_id);
    	
	    query_response_Bean query_response_BeanObj=query_response_Dao.getDatabyPK(query_response_id);
	    
	    
	    if(query_response_BeanObj!=null)
	    {
	    	request.setAttribute("query_response_BeanObj",query_response_BeanObj);
	    	request.getRequestDispatcher("query_response_edit.jsp").forward(request, response); 
	    }
	    else
	    {
	    	request.getRequestDispatcher("query_response_list").forward(request, response);
	    }
	}

}
