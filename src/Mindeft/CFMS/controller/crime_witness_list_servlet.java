package Mindeft.CFMS.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.crime_witnessBean;
import Mindeft.CFMS.bean.missing_personBean;
import Mindeft.CFMS.dao.crime_witnessDao;
import Mindeft.CFMS.dao.missing_personDao;

/**
 * Servlet implementation class crime_witness_list_servlet
 */
public class crime_witness_list_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<crime_witnessBean> crime_witnessBeanlist=new crime_witnessDao().select();
		request.setAttribute("crime_witnessBeanlist", crime_witnessBeanlist);
		request.getRequestDispatcher("crime_witness_list.jsp").forward(request, response);
		
	}

}
