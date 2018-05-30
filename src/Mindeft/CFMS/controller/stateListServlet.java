package Mindeft.CFMS.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.countryBean;
import Mindeft.CFMS.bean.stateBean;
import Mindeft.CFMS.dao.countryDao;
import Mindeft.CFMS.dao.stateDao;

/**
 * Servlet implementation class stateListServlet
 */

public class stateListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<stateBean> statelist=new stateDao().select();
		request.setAttribute("statelist", statelist);
		request.getRequestDispatcher("statelist_jsp.jsp").forward(request, response);
		
		
	}

}
