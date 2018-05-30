package Mindeft.CFMS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.missing_personBean;
import Mindeft.CFMS.bean.user_typeBean;
import Mindeft.CFMS.dao.missing_personDao;
import Mindeft.CFMS.dao.user_type_Dao;

/**
 * Servlet implementation class missing_person_edit_servlet
 */
public class missing_person_edit_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String missing_person_id=request.getParameter("missing_person_id");
		//System.out.println("User id:" + user_type_id);
    	
	    missing_personBean missing_personBeanObj=missing_personDao.getDatabyPK(missing_person_id);
	    
	    
	    if(missing_personBeanObj!=null)
	    {
	    	request.setAttribute("missing_personBeanObj",missing_personBeanObj);
	    	request.getRequestDispatcher("missing_person_edit.jsp").forward(request, response); 
	    }
	    else
	    {
	    	request.getRequestDispatcher("missing_person_list").forward(request, response);
	    }
	}

}
