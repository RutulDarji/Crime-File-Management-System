package Mindeft.CFMS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Mindeft.CFMS.bean.cityBean;
import Mindeft.CFMS.bean.crime_criminalBean;
import Mindeft.CFMS.util.DatabaseConnection;

public class crime_criminalDao {

	public static boolean insert(crime_criminalBean crime_criminalBeanObj) {
		// TODO Auto-generated method stub
		Connection conn=DatabaseConnection.getDbConnection();
		boolean status=false;
		int result;
		PreparedStatement pstmt=null;
			
		String crime_criminal_id,crime_id,criminal_id;
		
		crime_id=crime_criminalBeanObj.getCrime_id();
		criminal_id=crime_criminalBeanObj.getCriminal_id();
		
		System.out.println("Crime Id" + crime_id);
		System.out.println("Criminal Id" + criminal_id);
		
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("insert into crime_criminal (crime_id,criminal_id) values(?,?)");
				
				pstmt.setString(1, crime_id);
				pstmt.setString(2, criminal_id);
				
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

	public List<crime_criminalBean> select() {
		// TODO Auto-generated method stub
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		crime_criminalBean crime_criminalBeanobj=null;
		List<crime_criminalBean> crime_criminallist=new ArrayList<crime_criminalBean>(); 
		

		PreparedStatement pstmt=null;
		
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("select * from crime_criminal");
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					crime_criminalBeanobj=new crime_criminalBean();
					
					crime_criminalBeanobj.setCrime_criminal_id(rs.getString("crime_criminal_id"));			
					crime_criminalBeanobj.setCrime_id(rs.getString("crime_id"));
					crime_criminalBeanobj.setCriminal_id(rs.getString("criminal_id"));
					
					crime_criminallist.add(crime_criminalBeanobj);
				}
				
				
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		return crime_criminallist;
	}

	public boolean delete(String crime_criminal_id) {
		// TODO Auto-generated method stub
		Connection conn=DatabaseConnection.getDbConnection();
		boolean result=false;
		PreparedStatement pstmt=null;
		
		if(conn!=null){
			//String insertSQL = "DELETE FROM STUDENT WHERE STUDENTID = ?";
			try {
				pstmt = conn.prepareStatement("DELETE FROM crime_criminal WHERE crime_criminal_id = ?");

				pstmt.setString(1,crime_criminal_id);
				
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

	public static crime_criminalBean getDatabyPK(String crime_criminal_id) {
		// TODO Auto-generated method stub
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		crime_criminalBean crime_criminalBeanObj=null;
		 
		
		PreparedStatement pstmt=null;
		if(conn!=null){
			
			try {
				pstmt=conn.prepareStatement("SELECT * from crime_criminal WHERE crime_criminal_id = ?");

				pstmt.setString(1,crime_criminal_id);
				rs=pstmt.executeQuery();
				
				
				while(rs.next())
				{
					crime_criminalBeanObj=new crime_criminalBean();
					
					crime_criminalBeanObj.setCrime_criminal_id(rs.getString("crime_criminal_id"));			
					crime_criminalBeanObj.setCrime_id(rs.getString("crime_id"));
					crime_criminalBeanObj.setCriminal_id(rs.getString("criminal_id"));
					
				}

				
			} catch (Exception e) {
				e.printStackTrace();
							
			}
			
		}
		
		
		return crime_criminalBeanObj;
	}

	public static boolean update(crime_criminalBean crime_criminalBeanObj) {
		// TODO Auto-generated method stub
		Connection conn=DatabaseConnection.getDbConnection();
		boolean status=false;
		int result;
		PreparedStatement pstmt=null;
			
		String crime_criminal_id,crime_id,criminal_id;
		
		crime_id=crime_criminalBeanObj.getCrime_id();
		criminal_id=crime_criminalBeanObj.getCriminal_id();
		crime_criminal_id=crime_criminalBeanObj.getCrime_criminal_id();
		
		System.out.println("Crime Id" + crime_id);
		System.out.println("Criminal Id" + criminal_id);
		
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("update crime_criminal set crime_id=?,criminal_id=? where crime_criminal_id=?");
				
				pstmt.setString(1, crime_id);
				pstmt.setString(2, criminal_id);
				pstmt.setString(3, crime_criminal_id);
				
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

	public List<crime_criminalBean> view_particular(String crime_criminal_id) {
		// TODO Auto-generated method stub
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		crime_criminalBean crime_criminalBeanobj=null;
		List<crime_criminalBean> crime_criminallist=new ArrayList<crime_criminalBean>(); 
		

		PreparedStatement pstmt=null;
		
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("SELECT * from crime_criminal WHERE crime_criminal_id = ?");
				pstmt.setString(1,crime_criminal_id);
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					crime_criminalBeanobj=new crime_criminalBean();
					
					crime_criminalBeanobj.setCrime_criminal_id(rs.getString("crime_criminal_id"));			
					crime_criminalBeanobj.setCrime_id(rs.getString("crime_id"));
					crime_criminalBeanobj.setCriminal_id(rs.getString("criminal_id"));
					
					crime_criminallist.add(crime_criminalBeanobj);
				}
				
				
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		return crime_criminallist;
	}

}
