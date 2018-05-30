package Mindeft.CFMS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.queryBean;
import Mindeft.CFMS.dao.queryDao;
import Mindeft.CFMS.util.StringValidationUtility;

/**
 * Servlet implementation class query_update_servlet
 */
public class query_update_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	String query_id,query_details,query_date,query_status_id,user_id;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		query_details=request.getParameter("query_details");
		query_date=request.getParameter("query_date");
		query_status_id=request.getParameter("query_status_id");
		user_id=request.getParameter("user_id");
		query_id=request.getParameter("query_id");
		
		boolean isError=false;

		//SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		//System.out.println(java.time.LocalDate.now());  
		
		queryBean queryBeanObj=new queryBean();
		
		
		System.out.println("query_details::" + query_details);
		
		if(StringValidationUtility.isEmpty(query_details))
		{
			request.setAttribute("query_details", "<font color=red>*Enter Query</font>");
			isError=true;
		}
		
		
		if(isError)
		{
			request.getRequestDispatcher("query_table_jsp.jsp").forward(request, response);
		}
		else
		{
			queryBeanObj.setQuery_details(query_details);
			queryBeanObj.setQuery_status_id(query_status_id);
			queryBeanObj.setQuery_date(query_date);
			queryBeanObj.setUser_id(user_id);
			queryBeanObj.setQuery_id(query_id);
			
			if(queryDao.update(queryBeanObj));
			{
				System.out.println("Successful");
				request.getRequestDispatcher("query_select").forward(request, response);
			}
			
		}
		
	}

}
