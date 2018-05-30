package Mindeft.CFMS.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.complain_status_Bean;
import Mindeft.CFMS.bean.countryBean;
import Mindeft.CFMS.dao.complain_status_Dao;
import Mindeft.CFMS.dao.countryDao;

/**
 * Servlet implementation class complain_status_list
 */
public class complain_status_list extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		List<complain_status_Bean> complain_status_list=new complain_status_Dao().select();
		request.setAttribute("complain_status_list", complain_status_list);
		request.getRequestDispatcher("complain_status_list_jsp.jsp").forward(request, response);
		
		
	}

}
