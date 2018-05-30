package Mindeft.CFMS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.query_response_Bean;
import Mindeft.CFMS.dao.query_response_Dao;
import Mindeft.CFMS.util.StringValidationUtility;

/**
 * Servlet implementation class query_response_update_servlet
 */
public class query_response_update_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String query_response_id,query_response_details,query_id,query_response_date;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		query_response_details=request.getParameter("query_response_details");
		query_id=request.getParameter("query_id");
		query_response_date=request.getParameter("query_response_date");
		query_response_id=request.getParameter("query_response_id");
		
		boolean isError=false;

		query_response_Bean query_response_BeanObj=new query_response_Bean();
		
		
		System.out.println("query_response_details::" + query_response_details);
		
		if(StringValidationUtility.isEmpty(query_response_details))
		{
			request.setAttribute("query_response_details", "<font color=red>*Enter Query Response</font>");
			isError=true;
		}
		
		if(StringValidationUtility.isEmpty(query_id))
		{
			request.setAttribute("query_id", "<font color=red>*Select Any Query</font>");
			isError=true;
		}
		
		if(isError)
		{
			request.getRequestDispatcher("query_response_table.jsp").forward(request, response);
		}
		else
		{	
			query_response_BeanObj.setQuery_response_details(query_response_details);
			query_response_BeanObj.setQuery_response_date(query_response_date);
			query_response_BeanObj.setQuery_id(query_id);
			query_response_BeanObj.setQuery_response_id(query_response_id);
			
			if(query_response_Dao.update(query_response_BeanObj));
			{
				System.out.println("Successful");
				request.getRequestDispatcher("query_response_list").forward(request, response);
			}
			
		}
		
	}

}
