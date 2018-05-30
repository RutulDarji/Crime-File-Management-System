package Mindeft.CFMS.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.AreaBean;
import Mindeft.CFMS.bean.userBean;
import Mindeft.CFMS.dao.areaDao;
import Mindeft.CFMS.dao.userDao;

public class user_list_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<userBean> userBeanlist=new userDao().select();
		request.setAttribute("userBeanlist", userBeanlist);
		request.getRequestDispatcher("user_list_jsp.jsp").forward(request, response);
		
	}

}
