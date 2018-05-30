package Mindeft.CFMS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.complain_status_Bean;
import Mindeft.CFMS.bean.query_status_Bean;
import Mindeft.CFMS.dao.complain_status_Dao;
import Mindeft.CFMS.dao.query_status_Dao;
import Mindeft.CFMS.util.StringValidationUtility;


public class query_status_insert_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int query_status_id;
		String query_status_type=new String();
		
		query_status_type=request.getParameter("query_status_type");
		
		System.out.println("Type::" + query_status_type);
		boolean isError=false;
		
		query_status_Bean query_status_Bean_obj=new query_status_Bean(); 
		
		if(StringValidationUtility.isEmpty(query_status_type))
		{
			
			request.setAttribute("query_status_type", "<font color=red>*Enter query Status Type</font>");
			isError=true;
		}
		
		
		if(isError)
		{
			request.getRequestDispatcher("query_status_table.jsp").forward(request, response);
		}
		else
		{			
			//System.out.println("No Error");
			query_status_Bean_obj.setQuery_status_type(query_status_type);
			
			if(query_status_Dao.insert(query_status_Bean_obj))
			{
				System.out.println("Insertion complate Check Table");
				request.getRequestDispatcher("query_status_list").forward(request, response);
			}
			
		}
	}

}
