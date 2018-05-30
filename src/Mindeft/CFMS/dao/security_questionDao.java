package Mindeft.CFMS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Mindeft.CFMS.bean.query_status_Bean;
import Mindeft.CFMS.bean.security_questionBean;
import Mindeft.CFMS.bean.user_typeBean;
import Mindeft.CFMS.util.DatabaseConnection;

public class security_questionDao {

	public  static boolean insert(security_questionBean security_questionBeanObj) {
		// TODO Auto-generated method stub
		Connection conn=DatabaseConnection.getDbConnection();
		boolean status=false;
		String security_question_type=new String();
		int result;
		PreparedStatement pstmt=null;
		
		security_question_type=security_questionBeanObj.getSecurity_question_type();
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("insert into security_question(security_question_type) values(?)");
				
				pstmt.setString(1, security_question_type);
				
				
				result=pstmt.executeUpdate();
				
				if(result>0)
				{
					System.out.println("-----------Inserted ---------");
					status=true;
				}
				else
				{
					System.out.println("-----------Insertion Fail ---------");
				}
				
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	
		return status;
	}

	public List<security_questionBean> select() {
		
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;

		security_questionBean security_questionBeanObj=null;
		List<security_questionBean> security_question_list=new ArrayList<security_questionBean>(); 
		

		PreparedStatement pstmt=null;
		
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("select * from security_question");
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					security_questionBeanObj=new security_questionBean();
					
					
					//System.out.println(rs.getInt("query_status_id"));
					System.out.println(rs.getString("security_question_type"));
				
					security_questionBeanObj.setSecurity_question_id(rs.getString("security_question_id"));
					security_questionBeanObj.setSecurity_question_type(rs.getString("security_question_type"));
					
					security_question_list.add(security_questionBeanObj);
				}
				
				
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		return security_question_list;
		
	}

	public boolean delete(String security_question_id) {
		Connection conn=DatabaseConnection.getDbConnection();
		boolean result=false;
		PreparedStatement pstmt=null;
		
		if(conn!=null){
		
			try {
				pstmt = conn.prepareStatement("DELETE FROM security_question WHERE security_question_id = ?");

				pstmt.setString(1,security_question_id);
				
				int rowsAffacted  = pstmt.executeUpdate();
				

				if(rowsAffacted > 0){
					System.out.println(rowsAffacted+" Row(s) Deleted......");
					result=true;
				}else{
					System.out.println(rowsAffacted+"Row(s) Deleted......");					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				
			}
			
		}
		
	
		return result;
		
		
	}

	public static security_questionBean getDatabyPK(String security_question_id) {
		
		security_questionBean security_questionBeanObj=null; 
		
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		PreparedStatement pstmt=null;
		if(conn!=null){
			
			try {
				pstmt=conn.prepareStatement("SELECT * from security_question WHERE security_question_id = ?");

				pstmt.setString(1,security_question_id);
				rs=pstmt.executeQuery();
				
				
				while(rs.next())
				{
					security_questionBeanObj=new security_questionBean();

					security_questionBeanObj.setSecurity_question_id(rs.getString("security_question_id"));
					security_questionBeanObj.setSecurity_question_type(rs.getString("security_question_type"));
				}

				
				
			} catch (Exception e) {
				e.printStackTrace();
			
				
				
			}
			
		}
		
		
		return security_questionBeanObj;
		
	}

	public static boolean update(security_questionBean security_questionBeanObj) {
		
		Connection conn=DatabaseConnection.getDbConnection();
		boolean status=false;
		
		int result;
		PreparedStatement pstmt=null;
		
		String security_question_id=security_questionBeanObj.getSecurity_question_id();
		String security_question_type=security_questionBeanObj.getSecurity_question_type();
		
		System.out.println("security_question_id"+security_question_id);
		System.out.println("security_question_type"+security_question_type);
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("update security_question set security_question_type =? WHERE security_question_id = ?");
				
				pstmt.setString(1,security_question_type);
				pstmt.setString(2, security_question_id);
				
				
				
				result=pstmt.executeUpdate();
				
				if(result>0)
				{
					System.out.println("-----------Updated ---------");
					status=true;
				}
				else
				{
					System.out.println("-----------Updation Fail ---------");
				}
				
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}



		return status;
		
	}

	public List<security_questionBean> view_particular(String security_question_id) {
		// TODO Auto-generated method stub
		
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;

		security_questionBean security_questionBeanObj=null;
		List<security_questionBean> security_question_list=new ArrayList<security_questionBean>(); 
		

		PreparedStatement pstmt=null;
		
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("SELECT * from security_question WHERE security_question_id = ?");

				pstmt.setString(1,security_question_id);
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					security_questionBeanObj=new security_questionBean();
					
					
					//System.out.println(rs.getInt("query_status_id"));
					System.out.println(rs.getString("security_question_type"));
				
					security_questionBeanObj.setSecurity_question_id(rs.getString("security_question_id"));
					security_questionBeanObj.setSecurity_question_type(rs.getString("security_question_type"));
					
					security_question_list.add(security_questionBeanObj);
				}
				
				
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		return security_question_list;
		
	}
	
}
