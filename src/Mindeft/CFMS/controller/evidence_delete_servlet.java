package Mindeft.CFMS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.dao.evidenceDao;
import Mindeft.CFMS.dao.user_type_Dao;

/**
 * Servlet implementation class evidence_delete_servlet
 */
public class evidence_delete_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String evidence_id=request.getParameter("evidence_id");
		System.out.println("evidence_id::" + evidence_id);
		
		
		if(new evidenceDao().delete(evidence_id)){
			request.getRequestDispatcher("evidence_list").forward(request, response);
		}else{
			request.getRequestDispatcher("evidence_list").forward(request, response);
			
		}
		
	}

}
