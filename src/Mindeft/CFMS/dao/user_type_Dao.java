package Mindeft.CFMS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Mindeft.CFMS.bean.countryBean;
import Mindeft.CFMS.bean.user_typeBean;
import Mindeft.CFMS.util.DatabaseConnection;

public class user_type_Dao {

	public  static boolean insert(user_typeBean user_typeBeanObj) {
		// TODO Auto-generated method stub
		Connection conn=DatabaseConnection.getDbConnection();
		boolean status=false;
		String user_type=new String();
		int result;
		PreparedStatement pstmt=null;
			
		
		user_type=user_typeBeanObj.getUser_type();
		
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("insert into user_type(user_type) values(?)");
				
				pstmt.setString(1, user_type);
				
				
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

	public List<user_typeBean> select() {
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		user_typeBean user_typeBeanObj=null;
		List<user_typeBean> user_typelist=new ArrayList<user_typeBean>(); 
		

		PreparedStatement pstmt=null;
		
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("select * from user_type");
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					user_typeBeanObj=new user_typeBean();
					
					System.out.println("User_type_id" + rs.getString("user_id"));
					System.out.println("User_type" + rs.getString("user_type"));
					
					user_typeBeanObj.setUser_type_id(rs.getString("user_id"));
					user_typeBeanObj.setUser_type(rs.getString("user_type"));
					
					
					
					user_typelist.add(user_typeBeanObj);
				}
				
				
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		return user_typelist;
	}

	public boolean delete(String user_type_id) {
		Connection conn=DatabaseConnection.getDbConnection();
		boolean result=false;
		PreparedStatement pstmt=null;
		
		if(conn!=null){
			//String insertSQL = "DELETE FROM STUDENT WHERE STUDENTID = ?";
			try {
				pstmt = conn.prepareStatement("DELETE FROM user_type WHERE user_id = ?");

				pstmt.setString(1,user_type_id);
				
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

	public static user_typeBean getDatabyPK(String user_type_id) {
		user_typeBean user_typeBeanObj=null;
		
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		PreparedStatement pstmt=null;
		if(conn!=null){
			
			try {
				pstmt=conn.prepareStatement("SELECT * from user_type WHERE user_id = ?");
				pstmt.setString(1,user_type_id);
				rs=pstmt.executeQuery();
				
				
				while(rs.next())
				{
					user_typeBeanObj=new user_typeBean();
					
					user_typeBeanObj.setUser_type_id(rs.getString("user_id"));
					user_typeBeanObj.setUser_type(rs.getString("user_type"));
					System.out.println("Inside pk User id:" + user_typeBeanObj.getUser_type_id());
					
				}

				
				
			} catch (Exception e) {
				e.printStackTrace();
			
				
				
			}
			
		}
		
		
		return user_typeBeanObj;
	}

	public static boolean update(user_typeBean user_typeBeanObj) {
		Connection conn=DatabaseConnection.getDbConnection();
		boolean status=false;
		
		
		int result;
		PreparedStatement pstmt=null;
		
		String user_type_id=user_typeBeanObj.getUser_type_id();
		String user_type=user_typeBeanObj.getUser_type();
		
	
		System.out.println("User id"+user_type_id);
		System.out.println("user type"+user_type);
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("update user_type set user_type=? WHERE user_id = ?");
				
				pstmt.setString(1,user_type);
				pstmt.setString(2, user_type_id);
				
				
				
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

	public List<user_typeBean> view_particular(String user_type_id) {
		// TODO Auto-generated method stub
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		user_typeBean user_typeBeanObj=null;
		List<user_typeBean> user_typelist=new ArrayList<user_typeBean>(); 
		

		PreparedStatement pstmt=null;
		
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("SELECT * from user_type WHERE user_id = ?");
				pstmt.setString(1,user_type_id);
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					user_typeBeanObj=new user_typeBean();
					
					System.out.println("User_type_id" + rs.getString("user_id"));
					System.out.println("User_type" + rs.getString("user_type"));
					
					user_typeBeanObj.setUser_type_id(rs.getString("user_id"));
					user_typeBeanObj.setUser_type(rs.getString("user_type"));
					
					
					
					user_typelist.add(user_typeBeanObj);
				}
				
				
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		return user_typelist;
		
	}
	
	
	
	
}
