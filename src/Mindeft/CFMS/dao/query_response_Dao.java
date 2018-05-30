package Mindeft.CFMS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Mindeft.CFMS.bean.queryBean;
import Mindeft.CFMS.bean.query_response_Bean;
import Mindeft.CFMS.util.DatabaseConnection;

public class query_response_Dao {

	public static boolean insert(query_response_Bean query_response_BeanObj) {
		
		Connection conn=DatabaseConnection.getDbConnection();
		boolean status=false;
		String query_response_id,query_response_details,query_id,query_response_date;
		int result;
		PreparedStatement pstmt=null;
		
		query_response_details=query_response_BeanObj.getQuery_response_details();
		query_response_date=query_response_BeanObj.getQuery_response_date();
		query_id=query_response_BeanObj.getQuery_id();
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("insert into query_response(query_response_details,query_id,query_response_date) values(?,?,?)");
				
				pstmt.setString(1, query_response_details);
				pstmt.setString(2, query_id);
				pstmt.setString(3, query_response_date);
				
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

	public List<query_response_Bean> select() {
		
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		query_response_Bean query_response_BeanObj=null;
		List<query_response_Bean> query_response_Beanlist=new ArrayList<query_response_Bean>(); 
		

		PreparedStatement pstmt=null;
		
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("select * from query_response");
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					query_response_BeanObj=new query_response_Bean();
					

					query_response_BeanObj.setQuery_response_id(rs.getString("query_response_id"));
					query_response_BeanObj.setQuery_response_details(rs.getString("query_response_details"));
					query_response_BeanObj.setQuery_id(rs.getString("query_id"));
					query_response_BeanObj.setQuery_response_date(rs.getString("query_response_date"));
				
					query_response_Beanlist.add(query_response_BeanObj);
				}
				
				
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		return query_response_Beanlist;
		
		
	}

	public boolean delete(String query_response_id) {
		// TODO Auto-generated method stub
		Connection conn=DatabaseConnection.getDbConnection();
		boolean result=false;
		PreparedStatement pstmt=null;
		
		if(conn!=null){
			
			try {
				pstmt = conn.prepareStatement("DELETE FROM query_response WHERE query_response_id = ?");

				pstmt.setString(1,query_response_id);
				
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

	public static query_response_Bean getDatabyPK(String query_response_id) {
		// TODO Auto-generated method stub
		
		query_response_Bean query_response_BeanObj=null;
		
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		PreparedStatement pstmt=null;
		if(conn!=null){
			
			try {
				pstmt=conn.prepareStatement("SELECT * from query_response WHERE query_response_id = ?");
				pstmt.setString(1,query_response_id);
				rs=pstmt.executeQuery();
				
				
				while(rs.next())
				{
					query_response_BeanObj=new query_response_Bean();
					
					query_response_BeanObj.setQuery_response_id(rs.getString("query_response_id"));
					query_response_BeanObj.setQuery_response_details(rs.getString("query_response_details"));
					query_response_BeanObj.setQuery_id(rs.getString("query_id"));
					query_response_BeanObj.setQuery_response_date(rs.getString("query_response_date"));
					
				}
					
			} catch (Exception e) {
				e.printStackTrace();
					
			}
			
		}
		
		return query_response_BeanObj;
		
	}

	public static boolean update(query_response_Bean query_response_BeanObj) {
		// TODO Auto-generated method stub
		Connection conn=DatabaseConnection.getDbConnection();
		boolean status=false;
		String query_response_id,query_response_details,query_id,query_response_date;;	
		
		int result;
		PreparedStatement pstmt=null;
	
		query_response_id=query_response_BeanObj.getQuery_response_id();
		query_response_details=query_response_BeanObj.getQuery_response_details();
		query_response_date=query_response_BeanObj.getQuery_response_date();
		query_id=query_response_BeanObj.getQuery_id();
		
		if(conn!=null)
		{
			try 	
			{
				pstmt=conn.prepareStatement("update query_response set query_response_details=?,query_response_date=?,query_id=? WHERE query_response_id = ?");
				
				pstmt.setString(1,query_response_details);
				pstmt.setString(2, query_response_date);
				pstmt.setString(3,query_id);
				pstmt.setString(4, query_response_id);
				
				
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

	public List<query_response_Bean> view_individual(String query_response_id) {
		// TODO Auto-generated method stub
		
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		query_response_Bean query_response_BeanObj=null;
		List<query_response_Bean> query_response_Beanlist=new ArrayList<query_response_Bean>(); 
		

		PreparedStatement pstmt=null;
		
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("SELECT * from query_response WHERE query_response_id = ?");
				pstmt.setString(1,query_response_id);
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					query_response_BeanObj=new query_response_Bean();
					

					query_response_BeanObj.setQuery_response_id(rs.getString("query_response_id"));
					query_response_BeanObj.setQuery_response_details(rs.getString("query_response_details"));
					query_response_BeanObj.setQuery_id(rs.getString("query_id"));
					query_response_BeanObj.setQuery_response_date(rs.getString("query_response_date"));
				
					query_response_Beanlist.add(query_response_BeanObj);
				}
				
				
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		return query_response_Beanlist;
		
	}

}
