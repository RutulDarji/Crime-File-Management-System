package Mindeft.CFMS.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.complain_status_Bean;
import Mindeft.CFMS.dao.complain_status_Dao;

/**
 * Servlet implementation class complain_view_servlet
 */
public class complain_status_view_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String complain_status_id=request.getParameter("complain_status_id");
		System.out.println("complain_status_id:" + complain_status_id);
    	
		List<complain_status_Bean> complain_status_list=new complain_status_Dao().view_particular(complain_status_id);
		request.setAttribute("complain_status_list", complain_status_list);
		request.getRequestDispatcher("complain_status_view.jsp").forward(request, response);
		
		
	}

}
