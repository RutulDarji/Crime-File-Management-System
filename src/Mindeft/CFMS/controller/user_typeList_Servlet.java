package Mindeft.CFMS.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.countryBean;
import Mindeft.CFMS.bean.user_typeBean;
import Mindeft.CFMS.dao.countryDao;
import Mindeft.CFMS.dao.user_type_Dao;

public class user_typeList_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<user_typeBean> user_typelist=new user_type_Dao().select();
		request.setAttribute("user_typelist", user_typelist);
		request.getRequestDispatcher("user_typeList_jsp.jsp").forward(request, response);
	}

}
