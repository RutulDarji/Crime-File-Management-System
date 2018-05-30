package Mindeft.CFMS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.countryBean;
import Mindeft.CFMS.bean.user_typeBean;
import Mindeft.CFMS.dao.countryDao;
import Mindeft.CFMS.dao.user_type_Dao;

public class user_type_edit_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user_type_id=request.getParameter("user_type_id");
		//System.out.println("User id:" + user_type_id);
    	
	    user_typeBean user_typeBeanObj=user_type_Dao.getDatabyPK(user_type_id);
	    
	    
	    if(user_typeBeanObj!=null)
	    {
	    	request.setAttribute("user_typeBeanObj",user_typeBeanObj);
	    	request.getRequestDispatcher("user_type_edit_jsp.jsp").forward(request, response); 
	    }
	    else
	    {
	    	request.getRequestDispatcher("user_typeList").forward(request, response);
	    }
		
		
	}

}
