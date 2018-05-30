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
 * Servlet implementation class user_query_insert_servlet
 */
public class user_query_insert_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String query_id,query_details,query_date,query_status_id,user_id;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		query_details=request.getParameter("query_details");
		query_date=java.time.LocalDate.now()+"";
		query_date=query_date.trim();
		query_status_id="1";
		//user_id="1";
		user_id=request.getParameter("user_id");	
		
		System.out.println("USer Id is:" + user_id);
		
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
			request.getRequestDispatcher("user_query_page.jsp").forward(request, response);
		}
		else
		{
			queryBeanObj.setQuery_details(query_details);
			queryBeanObj.setQuery_status_id(query_status_id);
			queryBeanObj.setQuery_date(query_date);
			queryBeanObj.setUser_id(user_id);
			
			
			if(queryDao.insert(queryBeanObj));
			{
				System.out.println("Successful");
				request.getRequestDispatcher("home_page_after.jsp").forward(request, response);
			}
			
		}
		
	}

}
