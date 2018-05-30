package Mindeft.CFMS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Mindeft.CFMS.bean.complain_status_Bean;
import Mindeft.CFMS.bean.countryBean;
import Mindeft.CFMS.util.DatabaseConnection;

public class complain_status_Dao {

	public  static boolean insert(complain_status_Bean complain_status_BeanObj) {
		// TODO Auto-generated method stub
		Connection conn=DatabaseConnection.getDbConnection();
		boolean status=false;
		String complain_status_type=new String();
		int result;
		PreparedStatement pstmt=null;
			
		complain_status_type=complain_status_BeanObj.getComplain_status_type();
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("insert into complain_status(complain_status_type) values(?)");
				
				pstmt.setString(1, complain_status_type);
				
				
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

	public List<complain_status_Bean> select() {
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		complain_status_Bean complain_status_Beanobj=null;
		List<complain_status_Bean> complain_status_list=new ArrayList<complain_status_Bean>(); 
		

		PreparedStatement pstmt=null;
		
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("select * from complain_status");
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					complain_status_Beanobj=new complain_status_Bean();
					
					complain_status_Beanobj.setComplain_status_id(rs.getInt("complain_status_id"));
					complain_status_Beanobj.setComplain_status_type(rs.getString("complain_status_type"));
					
					complain_status_list.add(complain_status_Beanobj);
				}
				
				
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		return complain_status_list;
	}

	public boolean delete(String complain_status_id) {
		Connection conn=DatabaseConnection.getDbConnection();
		boolean result=false;
		PreparedStatement pstmt=null;
		
		if(conn!=null){
		
			try {
				pstmt = conn.prepareStatement("DELETE FROM complain_status WHERE complain_status_id = ?");

				pstmt.setString(1,complain_status_id);
				
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

	public static complain_status_Bean getDatabyPK(String complain_status_id) {
		complain_status_Bean complain_status_BeanObj=null;
		
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		PreparedStatement pstmt=null;
		if(conn!=null){
			
			try {
				pstmt=conn.prepareStatement("SELECT * from complain_status WHERE complain_status_id = ?");

				pstmt.setString(1,complain_status_id);
				rs=pstmt.executeQuery();
				
				
				while(rs.next())
				{
					complain_status_BeanObj=new complain_status_Bean();
					
					/*countryBeanObj.setCountry_id(rs.getInt("country_id"));
					countryBeanObj.setCountry_name(rs.getString("country_name"));
					
					System.out.println("Inside pk id:" + countryBeanObj.getCountry_id());*/
				
					complain_status_BeanObj.setComplain_status_id(rs.getInt("complain_status_id"));
					complain_status_BeanObj.setComplain_status_type(rs.getString("complain_status_type"));
					
					System.out.println("Inside pk id:" + complain_status_BeanObj.getComplain_status_id());
					
				}

				
				
			} catch (Exception e) {
				e.printStackTrace();
			
				
				
			}
			
		}
		
		
		return complain_status_BeanObj;
	}

	public static boolean update(complain_status_Bean complain_status_Bean_obj) {
		// TODO Auto-generated method stub
		Connection conn=DatabaseConnection.getDbConnection();
		boolean status=false;
		
		
		int result;
		PreparedStatement pstmt=null;
		
		int complain_status_id=complain_status_Bean_obj.getComplain_status_id();
		String complain_status_type=complain_status_Bean_obj.getComplain_status_type();
		
	
		System.out.println("Complain_status_id::"+complain_status_id);
		System.out.println("Complain_status_type::"+complain_status_type);
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("update complain_status set complain_status_type=? WHERE complain_status_id = ?");
				
				pstmt.setString(1, complain_status_type);
				pstmt.setInt(2, complain_status_id);
				
				
				
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

	public List<complain_status_Bean> view_particular(String complain_status_id) {
		// TODO Auto-generated method stub
		
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		complain_status_Bean complain_status_Beanobj=null;
		List<complain_status_Bean> complain_status_list=new ArrayList<complain_status_Bean>(); 
		

		PreparedStatement pstmt=null;
		
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("SELECT * from complain_status WHERE complain_status_id = ?");
				pstmt.setString(1,complain_status_id);
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					complain_status_Beanobj=new complain_status_Bean();
					
					complain_status_Beanobj.setComplain_status_id(rs.getInt("complain_status_id"));
					complain_status_Beanobj.setComplain_status_type(rs.getString("complain_status_type"));
					
					complain_status_list.add(complain_status_Beanobj);
				}
				
				
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		return complain_status_list;
		
	}
}
