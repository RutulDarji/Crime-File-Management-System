package Mindeft.CFMS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.complain_status_Bean;
import Mindeft.CFMS.dao.complain_status_Dao;
import Mindeft.CFMS.util.StringValidationUtility;

/**
 * Servlet implementation class complain_status_insert_servlet
 */
public class complain_status_insert_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int complain_status_id;
		String complain_status_type=new String();
		
		complain_status_type=request.getParameter("complain_status_type");
		
		//System.out.println("Type::" + complain_status_type);
		boolean isError=false;
		
		complain_status_Bean complain_status_Bean_obj=new complain_status_Bean(); 
		
		if(StringValidationUtility.isEmpty(complain_status_type))
		{
			
			request.setAttribute("complain_status_type", "<font color=red>*Select Complain Status Type</font>");
			isError=true;
			complain_status_Bean_obj.setComplain_status_type(complain_status_type);
		}
		else
		{
			complain_status_Bean_obj.setComplain_status_type(complain_status_type);
		}
		
		if(isError)
		{
			request.setAttribute("complain_status_Bean_obj", complain_status_Bean_obj);
			request.getRequestDispatcher("Complain_status_table.jsp").forward(request, response);
		}
		else
		{			
			//System.out.println("No Error");
			complain_status_Bean_obj.setComplain_status_type(complain_status_type);
			
			if(complain_status_Dao.insert(complain_status_Bean_obj))
			{
				//System.out.println("Insertion complate Check Table");
				request.getRequestDispatcher("complain_status_list").forward(request, response);
			}
			
		}
		
		
		
	}

}
