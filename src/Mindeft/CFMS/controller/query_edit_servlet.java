package Mindeft.CFMS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.queryBean;
import Mindeft.CFMS.bean.user_typeBean;
import Mindeft.CFMS.dao.queryDao;
import Mindeft.CFMS.dao.user_type_Dao;

/**
 * Servlet implementation class query_edit_servlet
 */
public class query_edit_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String query_id=request.getParameter("query_id");
		//System.out.println("User id:" + user_type_id);
    	
	    queryBean queryBeanObj=queryDao.getDatabyPK(query_id);
	    
	    
	    if(queryBeanObj!=null)
	    {
	    	request.setAttribute("queryBeanObj",queryBeanObj);
	    	request.getRequestDispatcher("query_edit_jsp.jsp").forward(request, response); 
	    }
	    else
	    {
	    	request.getRequestDispatcher("query_select").forward(request, response);
	    }
		
	}

}
