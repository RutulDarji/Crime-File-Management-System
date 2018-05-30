package Mindeft.CFMS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.AreaBean;
import Mindeft.CFMS.bean.user_typeBean;
import Mindeft.CFMS.dao.areaDao;
import Mindeft.CFMS.dao.user_type_Dao;

/**
 * Servlet implementation class area_edit_servlet
 */
public class area_edit_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String area_id=request.getParameter("area_id");
		//System.out.println("User id:" + user_type_id);
    	
	    AreaBean AreaBeanObj=areaDao.getDatabyPK(area_id);
	    
	    
	    if(AreaBeanObj!=null)
	    {
	    	request.setAttribute("AreaBeanObj",AreaBeanObj);
	    	request.getRequestDispatcher("area_edit_jsp.jsp").forward(request, response); 
	    }
	    else
	    {
	    	request.getRequestDispatcher("areaList").forward(request, response);
	    }
	}

}
