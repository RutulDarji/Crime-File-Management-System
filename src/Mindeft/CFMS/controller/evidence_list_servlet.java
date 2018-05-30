package Mindeft.CFMS.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.evidenceBean;
import Mindeft.CFMS.bean.user_typeBean;
import Mindeft.CFMS.dao.evidenceDao;
import Mindeft.CFMS.dao.user_type_Dao;

/**
 * Servlet implementation class evidence_list_servlet
 */
public class evidence_list_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<evidenceBean> evidenceBeanlist=new evidenceDao().select();
		request.setAttribute("evidenceBeanlist", evidenceBeanlist);
		request.getRequestDispatcher("evidence_list.jsp").forward(request, response);
	}

}
