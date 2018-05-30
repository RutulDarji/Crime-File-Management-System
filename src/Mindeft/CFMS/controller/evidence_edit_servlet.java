package Mindeft.CFMS.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.AreaBean;
import Mindeft.CFMS.bean.evidenceBean;
import Mindeft.CFMS.dao.areaDao;
import Mindeft.CFMS.dao.evidenceDao;

/**
 * Servlet implementation class evidence_edit_servlet
 */
public class evidence_edit_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String evidence_id=request.getParameter("evidence_id");
		//System.out.println("User id:" + user_type_id);
    	
	    evidenceBean evidenceBeanObj=evidenceDao.getDatabyPK(evidence_id);
	    
	    
	    if(evidenceBeanObj!=null)
	    {
	    	request.setAttribute("evidenceBeanObj",evidenceBeanObj);
	    	request.getRequestDispatcher("evidence_edit.jsp").forward(request, response); 
	    }
	    else
	    {
	    	request.getRequestDispatcher("evidence_list").forward(request, response);
	    }
		
	}

}
