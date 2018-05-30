package Mindeft.CFMS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.countryBean;
import Mindeft.CFMS.bean.stateBean;
import Mindeft.CFMS.dao.countryDao;
import Mindeft.CFMS.dao.stateDao;

/**
 * Servlet implementation class state_edit_servlet
 */
public class state_edit_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String state_id=request.getParameter("state_id");
		System.out.println("id:" + state_id);
    	
	    stateBean stateBeanObj=stateDao.getDatabyPK(state_id);
	    
	    if(stateBeanObj!=null)
	    {
	    	request.setAttribute("stateBeanObj",stateBeanObj);
	    	request.getRequestDispatcher("state_edit_jsp.jsp").forward(request, response); 
	    	//response.sendRedirect("registerList");
	    }
	    else
	    {
	    	request.getRequestDispatcher("stateList").forward(request, response);
	    }
	
	}
	

}
