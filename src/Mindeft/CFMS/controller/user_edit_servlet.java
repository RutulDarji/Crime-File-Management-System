package Mindeft.CFMS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.AreaBean;
import Mindeft.CFMS.bean.userBean;
import Mindeft.CFMS.dao.areaDao;
import Mindeft.CFMS.dao.userDao;

/**
 * Servlet implementation class user_edit_servlet
 */
public class user_edit_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String user_id=request.getParameter("user_id");
		
    	
	    userBean userBeanObj=userDao.getDatabyPK(user_id);
	    
	    
	    if(userBeanObj!=null)
	    {
	    	request.setAttribute("userBeanObj",userBeanObj);
	    	request.getRequestDispatcher("user_profile_edit.jsp").forward(request, response); 
	    }
	    else
	    {
	    	request.getRequestDispatcher("user_list").forward(request, response);
	    }
	}

}
