package Mindeft.CFMS.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.stateBean;
import Mindeft.CFMS.dao.stateDao;

/**
 * Servlet implementation class state_view_servlet
 */
public class state_view_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String state_id=request.getParameter("state_id");
		List<stateBean> statelist=new stateDao().view_particular(state_id);
		request.setAttribute("statelist", statelist);
		request.getRequestDispatcher("state_view_jsp.jsp").forward(request, response);
		
	}

}
