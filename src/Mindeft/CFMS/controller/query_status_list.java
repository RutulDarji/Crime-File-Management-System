package Mindeft.CFMS.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mindeft.CFMS.bean.complain_status_Bean;
import Mindeft.CFMS.bean.query_status_Bean;
import Mindeft.CFMS.dao.complain_status_Dao;
import Mindeft.CFMS.dao.query_status_Dao;

public class query_status_list extends HttpServlet {
	private static final long serialVersionUID = 1L;
@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	List<query_status_Bean> query_status_list=new query_status_Dao().select();
	request.setAttribute("query_status_list", query_status_list);
	request.getRequestDispatcher("query_status_list_jsp.jsp").forward(request, response);
	}
}
