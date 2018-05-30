package Mindeft.CFMS.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.missing_personBean;
import Mindeft.CFMS.dao.missing_personDao;

/**
 * Servlet implementation class user_missing_person_view_servlet
 */
public class user_missing_person_view_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String missing_person_id=request.getParameter("missing_person_id");
		List<missing_personBean> missing_personBeanlist=new missing_personDao().view_particular(missing_person_id);
		request.setAttribute("missing_personBeanlist", missing_personBeanlist);
		request.getRequestDispatcher("user_missing_person_view.jsp").forward(request, response);
		
	}

}
