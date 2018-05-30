package Mindeft.CFMS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.AreaBean;
import Mindeft.CFMS.bean.criminalBean;
import Mindeft.CFMS.dao.areaDao;
import Mindeft.CFMS.dao.criminalDao;

/**
 * Servlet implementation class criminal_edit_servlet
 */
public class criminal_edit_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String criminal_id=request.getParameter("criminal_id");
		System.out.println("criminal_id:" + criminal_id);
    	
	    criminalBean criminalBeanObj=criminalDao.getDatabyPK(criminal_id);
	    
	    
	    if(criminalBeanObj!=null)
	    {
	    	request.setAttribute("criminalBeanObj",criminalBeanObj);
	    	request.getRequestDispatcher("criminal_edit.jsp").forward(request, response); 
	    }
	    else
	    {
	    	request.getRequestDispatcher("criminal_list").forward(request, response);
	    }
	}

}
