package Mindeft.CFMS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Mindeft.CFMS.bean.queryBean;
import Mindeft.CFMS.bean.user_typeBean;
import Mindeft.CFMS.util.DatabaseConnection;

public class queryDao {

	public static boolean insert(queryBean queryBeanObj) {
		
		Connection conn=DatabaseConnection.getDbConnection();
		boolean status=false;
		String query_id,query_details,query_date,query_status_id,user_id;
		int result;
		PreparedStatement pstmt=null;
		
		query_details=queryBeanObj.getQuery_details();
		query_date=queryBeanObj.getQuery_date();
		query_status_id=queryBeanObj.getQuery_status_id();
		user_id=queryBeanObj.getUser_id();
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("insert into query(query_details,query_date,query_status_id,user_id) values(?,?,?,?)");
				
				pstmt.setString(1, query_details);
				pstmt.setString(2, query_date);
				pstmt.setString(3, query_status_id);
				pstmt.setString(4,user_id);
				
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

	public List<queryBean> select() {
		
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		queryBean queryBeanObj=null;
		List<queryBean> queryBeanlist=new ArrayList<queryBean>(); 
		

		PreparedStatement pstmt=null;
		
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("select * from query");
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					queryBeanObj=new queryBean();
					
					queryBeanObj.setQuery_id(rs.getString("query_id"));
					queryBeanObj.setQuery_details(rs.getString("query_details"));
					queryBeanObj.setQuery_date(rs.getString("query_date"));
					queryBeanObj.setQuery_status_id(rs.getString("query_status_id"));
					queryBeanObj.setUser_id(rs.getString("user_id"));
				
					
					System.out.println(queryBeanObj.getQuery_id());
					
					queryBeanlist.add(queryBeanObj);
				}
				
				
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		return queryBeanlist;
		
	}

	public boolean delete(String query_id) {
		
		Connection conn=DatabaseConnection.getDbConnection();
		boolean result=false;
		PreparedStatement pstmt=null;
		
		if(conn!=null){
			
			try {
				pstmt = conn.prepareStatement("DELETE FROM query WHERE query_id = ?");

				pstmt.setString(1,query_id);
				
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

	public static queryBean getDatabyPK(String query_id) {
		
		queryBean queryBeanObj=null;
		
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		PreparedStatement pstmt=null;
		if(conn!=null){
			
			try {
				pstmt=conn.prepareStatement("SELECT * from query WHERE query_id = ?");
				pstmt.setString(1,query_id);
				rs=pstmt.executeQuery();
				
				
				while(rs.next())
				{
					queryBeanObj=new queryBean();
					
					queryBeanObj.setQuery_id(rs.getString("query_id"));
					queryBeanObj.setQuery_details(rs.getString("query_details"));
					queryBeanObj.setQuery_date(rs.getString("query_date"));
					queryBeanObj.setQuery_status_id(rs.getString("query_status_id"));
					queryBeanObj.setUser_id(rs.getString("user_id"));
					
				}
					
			} catch (Exception e) {
				e.printStackTrace();
					
			}
			
		}
		
		return queryBeanObj;
		
	}

	public static boolean update(queryBean queryBeanObj) {
		
		Connection conn=DatabaseConnection.getDbConnection();
		boolean status=false;
		String query_id,query_details,query_date,query_status_id,user_id;	
		
		int result;
		PreparedStatement pstmt=null;
	
		query_id=queryBeanObj.getQuery_id();
		query_details=queryBeanObj.getQuery_details();
		query_date=queryBeanObj.getQuery_date();
		query_status_id=queryBeanObj.getQuery_status_id();
		user_id=queryBeanObj.getUser_id();
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("update query set query_details=?,query_date=?,query_status_id=?,user_id=? WHERE query_id = ?");
				
				pstmt.setString(1,query_details);
				pstmt.setString(2, query_date);
				pstmt.setString(3,query_status_id);
				pstmt.setString(4, user_id);
				pstmt.setString(5, query_id);
				
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

	public List<queryBean> view_particular(String query_id) {
		
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		queryBean queryBeanObj=null;
		List<queryBean> queryBeanlist=new ArrayList<queryBean>(); 
		

		PreparedStatement pstmt=null;
		
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("SELECT * from query WHERE query_id = ?");
				pstmt.setString(1,query_id);
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					queryBeanObj=new queryBean();
					
					queryBeanObj.setQuery_id(rs.getString("query_id"));
					queryBeanObj.setQuery_details(rs.getString("query_details"));
					queryBeanObj.setQuery_date(rs.getString("query_date"));
					queryBeanObj.setQuery_status_id(rs.getString("query_status_id"));
					queryBeanObj.setUser_id(rs.getString("user_id"));
					
					queryBeanlist.add(queryBeanObj);
				}
				
				
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		return queryBeanlist;	
		
	}

}
