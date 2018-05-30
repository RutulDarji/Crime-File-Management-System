package Mindeft.CFMS.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.evidenceBean;
import Mindeft.CFMS.dao.evidenceDao;

/**
 * Servlet implementation class evidence_view_servlet
 */
public class evidence_view_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String evidence_id=request.getParameter("evidence_id");
		System.out.println("evidence_id:" + evidence_id);
		
		List<evidenceBean> evidenceBeanlist=new evidenceDao().view_particular(evidence_id);
		request.setAttribute("evidenceBeanlist", evidenceBeanlist);
		request.getRequestDispatcher("evidence_view.jsp").forward(request, response);
		
	}

}
