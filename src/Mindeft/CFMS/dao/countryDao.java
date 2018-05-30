package Mindeft.CFMS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



import Mindeft.CFMS.bean.countryBean;
import Mindeft.CFMS.util.DatabaseConnection;

public class countryDao {

	public  static boolean insert(countryBean countryBeanobj) {
		// TODO Auto-generated method stub
		Connection conn=DatabaseConnection.getDbConnection();
		boolean status=false;
		String country_name=new String();
		int result;
		PreparedStatement pstmt=null;
			
		
		country_name=countryBeanobj.getCountry_name();
		
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("insert into country(country_name) values(?)");
				
				pstmt.setString(1, country_name);
				
				
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
	
	
	public  static List<countryBean> select() {
		// TODO Auto-generated method stub
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		countryBean countryBeanobj=null;
		List<countryBean> countrylist=new ArrayList<countryBean>(); 
		

		PreparedStatement pstmt=null;
		
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("select * from country");
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					countryBeanobj=new countryBean();
					
					countryBeanobj.setCountry_id(rs.getInt("country_id"));
					countryBeanobj.setCountry_name(rs.getString("country_name"));
					
					
					countrylist.add(countryBeanobj);
				}
				
				
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		return countrylist;
	}
	
	
	public boolean delete(String country_id){
		Connection conn=DatabaseConnection.getDbConnection();
		boolean result=false;
		PreparedStatement pstmt=null;
		
		if(conn!=null){
			//String insertSQL = "DELETE FROM STUDENT WHERE STUDENTID = ?";
			try {
				pstmt = conn.prepareStatement("DELETE FROM country WHERE country_id = ?");

				pstmt.setString(1,country_id);
				
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


	public static countryBean getDatabyPK(String country_id) {
		// TODO Auto-generated method stub
		countryBean countryBeanObj=null;
		
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		PreparedStatement pstmt=null;
		if(conn!=null){
			
			try {
				pstmt=conn.prepareStatement("SELECT * from country WHERE country_id = ?");

				pstmt.setString(1,country_id);
				rs=pstmt.executeQuery();
				
				
				while(rs.next())
				{
					countryBeanObj=new countryBean();
					
					countryBeanObj.setCountry_id(rs.getInt("country_id"));
					countryBeanObj.setCountry_name(rs.getString("country_name"));
					System.out.println("Inside pk id:" + countryBeanObj.getCountry_id());
					
				}

				
				
			} catch (Exception e) {
				e.printStackTrace();
			
				
				
			}
			
		}
		
		
		return countryBeanObj;
	}


	public boolean update(countryBean countryBeanobj) {
		// TODO Auto-generated method stub
		Connection conn=DatabaseConnection.getDbConnection();
		boolean status=false;
		
		
		int result;
		PreparedStatement pstmt=null;
		
		
		int country_id=countryBeanobj.getCountry_id();
		String country_name=countryBeanobj.getCountry_name();
		
	
		System.out.println("id"+country_id);
		System.out.println("name"+country_name);
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("update country set country_name=? WHERE country_id = ?");
				
				pstmt.setString(1, country_name);
				pstmt.setInt(2, country_id);
				
				
				
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


	public List<countryBean> view_particular(String country_id) {
		// TODO Auto-generated method stub
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		countryBean countryBeanobj=null;
		List<countryBean> countrylist=new ArrayList<countryBean>(); 
		

		PreparedStatement pstmt=null;
		
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("SELECT * from country WHERE country_id = ?");

				pstmt.setString(1,country_id);
	
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					countryBeanobj=new countryBean();
					
					countryBeanobj.setCountry_id(rs.getInt("country_id"));
					countryBeanobj.setCountry_name(rs.getString("country_name"));
					
					
					countrylist.add(countryBeanobj);
				}
				
				
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		return countrylist;
	}
	
	
	
}




