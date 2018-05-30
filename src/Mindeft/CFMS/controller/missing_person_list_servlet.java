package Mindeft.CFMS.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.missing_personBean;
import Mindeft.CFMS.bean.user_typeBean;
import Mindeft.CFMS.dao.missing_personDao;
import Mindeft.CFMS.dao.user_type_Dao;

/**
 * Servlet implementation class missing_person_list_servlet
 */
public class missing_person_list_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<missing_personBean> missing_personBeanlist=new missing_personDao().select();
		request.setAttribute("missing_personBeanlist", missing_personBeanlist);
		request.getRequestDispatcher("missing_person_list.jsp").forward(request, response);
		
	}

}
