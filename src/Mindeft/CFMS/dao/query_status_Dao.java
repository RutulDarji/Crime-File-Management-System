package Mindeft.CFMS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Mindeft.CFMS.bean.complain_status_Bean;
import Mindeft.CFMS.bean.query_status_Bean;
import Mindeft.CFMS.util.DatabaseConnection;

public class query_status_Dao {

	public static boolean insert(query_status_Bean query_status_Bean_obj) {
		Connection conn=DatabaseConnection.getDbConnection();
		boolean status=false;
		String query_status_type=new String();
		int result;
		PreparedStatement pstmt=null;
			
		query_status_type=query_status_Bean_obj.getQuery_status_type();
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("insert into query_status(query_status_type) values(?)");
				
				pstmt.setString(1, query_status_type);
				
				
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

	public List<query_status_Bean> select() {
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		query_status_Bean query_status_Beanobj=null;
		List<query_status_Bean> query_status_list=new ArrayList<query_status_Bean>(); 
		

		PreparedStatement pstmt=null;
		
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("select * from query_status");
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					query_status_Beanobj=new query_status_Bean();
					
					System.out.println(rs.getInt("query_status_id"));
					System.out.println(rs.getString("query_status_type"));
					
					query_status_Beanobj.setQuery_status_id(rs.getInt("query_status_id"));
					query_status_Beanobj.setQuery_status_type(rs.getString("query_status_type"));
					
					query_status_list.add(query_status_Beanobj);
				}
				
				
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		return query_status_list;
	}

	public boolean delete(String query_status_id) {
		Connection conn=DatabaseConnection.getDbConnection();
		boolean result=false;
		PreparedStatement pstmt=null;
		
		if(conn!=null){
		
			try {
				pstmt = conn.prepareStatement("DELETE FROM query_status WHERE query_status_id = ?");

				pstmt.setString(1,query_status_id);
				
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

	public static query_status_Bean getDatabyPK(String query_status_id) {
		query_status_Bean query_status_BeanObj=null;
		
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		PreparedStatement pstmt=null;
		if(conn!=null){
			
			try {
				pstmt=conn.prepareStatement("SELECT * from query_status WHERE query_status_id = ?");

				pstmt.setString(1,query_status_id);
				rs=pstmt.executeQuery();
				
				
				while(rs.next())
				{
					query_status_BeanObj=new query_status_Bean();
				
					query_status_BeanObj.setQuery_status_id(rs.getInt("query_status_id"));
					query_status_BeanObj.setQuery_status_type(rs.getString("query_status_type"));
					
					System.out.println("Inside pk id:" + query_status_BeanObj.getQuery_status_id());
					
				}

				
				
			} catch (Exception e) {
				e.printStackTrace();
			
				
				
			}
			
		}
		
		
		return query_status_BeanObj;
	}

	public static boolean update(query_status_Bean query_status_Bean_obj) {
		Connection conn=DatabaseConnection.getDbConnection();
		boolean status=false;
		
		
		int result;
		PreparedStatement pstmt=null;
		
		int query_status_id=query_status_Bean_obj.getQuery_status_id();
		String query_status_type=query_status_Bean_obj.getQuery_status_type();
		
	
		System.out.println("query_status_id::"+query_status_id);
		System.out.println("query_status_type::"+query_status_type);
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("update query_status set query_status_type=? WHERE query_status_id = ?");
				
				pstmt.setString(1, query_status_type);
				pstmt.setInt(2, query_status_id);
				
				
				
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

	public List<query_status_Bean> view_particular(String query_status_id) {
		// TODO Auto-generated method stub
		
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		query_status_Bean query_status_Beanobj=null;
		List<query_status_Bean> query_status_list=new ArrayList<query_status_Bean>(); 
		

		PreparedStatement pstmt=null;
		
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("SELECT * from query_status WHERE query_status_id = ?");

				pstmt.setString(1,query_status_id);
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					query_status_Beanobj=new query_status_Bean();
					
					System.out.println(rs.getInt("query_status_id"));
					System.out.println(rs.getString("query_status_type"));
					
					query_status_Beanobj.setQuery_status_id(rs.getInt("query_status_id"));
					query_status_Beanobj.setQuery_status_type(rs.getString("query_status_type"));
					
					query_status_list.add(query_status_Beanobj);
				}
				
				
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		return query_status_list;
		
	}

}
