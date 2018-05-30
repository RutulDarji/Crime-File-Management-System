package Mindeft.CFMS.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.userBean;
import Mindeft.CFMS.dao.userDao;

/**
 * Servlet implementation class user_profile_view_servlet
 */
public class user_profile_view_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String user_id=request.getParameter("user_id");
		System.out.println("Pass USer Id is::" + user_id);
		
		List<userBean> userBeanlist=new userDao().view_particular(user_id);
		request.setAttribute("userBeanlist", userBeanlist);
		//request.getRequestDispatcher("user_profile_page.jsp").forward(request, response);
		
	}

}
