package Mindeft.CFMS.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.crime_accuseBean;
import Mindeft.CFMS.bean.crime_victimBean;
import Mindeft.CFMS.dao.crime_accuseDao;
import Mindeft.CFMS.dao.crime_victimDao;

/**
 * Servlet implementation class crime_accuse_list_servlet
 */
public class crime_accuse_list_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<crime_accuseBean> crime_accuseBeanlist=new crime_accuseDao().select();
		request.setAttribute("crime_accuseBeanlist", crime_accuseBeanlist);
		request.getRequestDispatcher("crime_accuse_list.jsp").forward(request, response);
		
	}

}
