package Mindeft.CFMS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.complainBean;
import Mindeft.CFMS.dao.complainDao;


public class user_complain_edit_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String complain_id=request.getParameter("complain_id");
		System.out.println("complain_id:" + complain_id);
    	
	    complainBean complainBeanObj=complainDao.getDatabyPK(complain_id);
	    
	    
	    if(complainBeanObj!=null)
	    {
	    	request.setAttribute("complainBeanObj",complainBeanObj);
	    	request.getRequestDispatcher("user_complain_edit.jsp").forward(request, response); 
	    }
	    else
	    {
	    	request.getRequestDispatcher("complain_list").forward(request, response);
	    }
		
	}

}
