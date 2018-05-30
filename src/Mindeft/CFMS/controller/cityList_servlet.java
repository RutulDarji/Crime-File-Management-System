package Mindeft.CFMS.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.cityBean;
import Mindeft.CFMS.bean.stateBean;
import Mindeft.CFMS.dao.cityDao;
import Mindeft.CFMS.dao.stateDao;

/**
 * Servlet implementation class cityList_servlet
 */
public class cityList_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<cityBean> citylist=new cityDao().select();
		request.setAttribute("citylist", citylist);
		request.getRequestDispatcher("citylist_jsp.jsp").forward(request, response);
		
	}

}
