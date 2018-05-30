package Mindeft.CFMS.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.crime_criminalBean;
import Mindeft.CFMS.bean.user_typeBean;
import Mindeft.CFMS.dao.crime_criminalDao;
import Mindeft.CFMS.dao.user_type_Dao;

/**
 * Servlet implementation class crime_criminal_list_servlet
 */
public class crime_criminal_list_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<crime_criminalBean> crime_criminalBeanlist=new crime_criminalDao().select();
		request.setAttribute("crime_criminalBeanlist", crime_criminalBeanlist);
		request.getRequestDispatcher("crime_criminal_list.jsp").forward(request, response);
		
	}

}
