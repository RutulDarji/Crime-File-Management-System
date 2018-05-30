package Mindeft.CFMS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Mindeft.CFMS.bean.crime_victimBean;
import Mindeft.CFMS.bean.crime_victimBean;
import Mindeft.CFMS.util.DatabaseConnection;

public class crime_victimDao {

	public static boolean insert(crime_victimBean crime_victimBeanObj) {
		// TODO Auto-generated method stub
		Connection conn=DatabaseConnection.getDbConnection();
		boolean status=false;
		
		int result;
		PreparedStatement pstmt=null;
		
		String crime_victim_id,crime_victim_firstname,crime_victim_middlename,crime_victim_lastname,crime_victim_gender;
		String crime_victim_age,crime_victim_number,crime_victim_address,crime_victim_image,crime_id;

		crime_victim_firstname=crime_victimBeanObj.getCrime_victim_firstname();
		crime_victim_middlename=crime_victimBeanObj.getCrime_victim_middlename();
		crime_victim_lastname=crime_victimBeanObj.getCrime_victim_lastname();
		crime_victim_gender=crime_victimBeanObj.getCrime_victim_gender();
		crime_victim_age=crime_victimBeanObj.getCrime_victim_age();
		crime_victim_number=crime_victimBeanObj.getCrime_victim_number();
		crime_victim_address=crime_victimBeanObj.getCrime_victim_address();
		crime_victim_image=crime_victimBeanObj.getCrime_victim_image();
		crime_id=crime_victimBeanObj.getCrime_id();
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("insert into crime_victim(crime_victim_firstname,crime_victim_middlename,crime_victim_lastname,crime_victim_gender,crime_victim_age,crime_victim_number,crime_victim_address,crime_victim_image,crime_id) values(?,?,?,?,?,?,?,?,?);");
				
				pstmt.setString(1, crime_victim_firstname);
				pstmt.setString(2, crime_victim_middlename);
				pstmt.setString(3, crime_victim_lastname);
				pstmt.setString(4, crime_victim_gender);
				pstmt.setString(5, crime_victim_age);
				pstmt.setString(6, crime_victim_number);
				pstmt.setString(7, crime_victim_address);
				pstmt.setString(8, crime_victim_image);
				pstmt.setString(9, crime_id);
				
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
	
	public List<crime_victimBean> select() {
		// TODO Auto-generated method stub
		
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		crime_victimBean crime_victimBeanObj=null;
		List<crime_victimBean> crime_victimBeanlist=new ArrayList<crime_victimBean>(); 
		

		PreparedStatement pstmt=null;
		
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("select * from crime_victim");
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					crime_victimBeanObj=new crime_victimBean();
					
					/*crime_victimBeanObj.setcrime_victim_firstname(rs.getString("crime_victim_firstname"));
					crime_victimBeanObj.setcrime_victim_middlename(rs.getString("crime_victim_middlename"));
					crime_victimBeanObj.setcrime_victim_lastname(rs.getString("crime_victim_lastname"));
					crime_victimBeanObj.setcrime_victim_gender(rs.getString("crime_victim_gender"));
					crime_victimBeanObj.setcrime_victim_age(rs.getString("crime_victim_age"));
					crime_victimBeanObj.setcrime_victim_number(rs.getString("crime_victim_number"));
					crime_victimBeanObj.setcrime_victim_address(rs.getString("crime_victim_address"));
					crime_victimBeanObj.setcrime_victim_image(rs.getString("crime_victim_image"));
					crime_victimBeanObj.setCrime_id(rs.getString("crime_id"));
					crime_victimBeanObj.setcrime_victim_id(rs.getString("crime_victim_id"));
					*/
					
					crime_victimBeanObj.setCrime_victim_firstname(rs.getString("crime_victim_firstname"));
					crime_victimBeanObj.setCrime_victim_middlename(rs.getString("crime_victim_middlename"));
					crime_victimBeanObj.setCrime_victim_lastname(rs.getString("crime_victim_lastname"));
					crime_victimBeanObj.setCrime_victim_gender(rs.getString("crime_victim_gender"));
					crime_victimBeanObj.setCrime_victim_age(rs.getString("crime_victim_age"));
					crime_victimBeanObj.setCrime_victim_number(rs.getString("crime_victim_number"));
					crime_victimBeanObj.setCrime_victim_address(rs.getString("crime_victim_address"));
					crime_victimBeanObj.setCrime_victim_image(rs.getString("crime_victim_image"));
					crime_victimBeanObj.setCrime_id(rs.getString("crime_id"));
					crime_victimBeanObj.setCrime_victim_id(rs.getString("crime_victim_id"));
					
					crime_victimBeanlist.add(crime_victimBeanObj);
				}
				
				
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		return crime_victimBeanlist;
	}

	public boolean delete(String crime_victim_id) {
		Connection conn=DatabaseConnection.getDbConnection();
		boolean result=false;
		PreparedStatement pstmt=null;
		
		if(conn!=null){
			//String insertSQL = "DELETE FROM STUDENT WHERE STUDENTID = ?";
			try {
				pstmt = conn.prepareStatement("DELETE FROM crime_victim WHERE crime_victim_id = ?");

				pstmt.setString(1,crime_victim_id);
				
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

	public static crime_victimBean getDatabyPK(String crime_victim_id) {
		
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		crime_victimBean crime_victimBeanObj=null;
		//List<crime_victimBean> crime_victimBeanlist=new ArrayList<crime_victimBean>(); 
		

		PreparedStatement pstmt=null;
		
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("select * from crime_victim where crime_victim_id=?");
				pstmt.setString(1,crime_victim_id);
				
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					crime_victimBeanObj=new crime_victimBean();
					
					
					crime_victimBeanObj.setCrime_victim_firstname(rs.getString("crime_victim_firstname"));
					crime_victimBeanObj.setCrime_victim_middlename(rs.getString("crime_victim_middlename"));
					crime_victimBeanObj.setCrime_victim_lastname(rs.getString("crime_victim_lastname"));
					crime_victimBeanObj.setCrime_victim_gender(rs.getString("crime_victim_gender"));
					crime_victimBeanObj.setCrime_victim_age(rs.getString("crime_victim_age"));
					crime_victimBeanObj.setCrime_victim_number(rs.getString("crime_victim_number"));
					crime_victimBeanObj.setCrime_victim_address(rs.getString("crime_victim_address"));
					crime_victimBeanObj.setCrime_victim_image(rs.getString("crime_victim_image"));
					crime_victimBeanObj.setCrime_id(rs.getString("crime_id"));
					crime_victimBeanObj.setCrime_victim_id(rs.getString("crime_victim_id"));
					
				}
				
				
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		return crime_victimBeanObj;
		
		
	}

	public static boolean update(crime_victimBean crime_victimBeanObj) {
		// TODO Auto-generated method stub
		Connection conn=DatabaseConnection.getDbConnection();
		boolean status=false;
		
		int result;
		PreparedStatement pstmt=null;
		
		String crime_victim_id,crime_victim_firstname,crime_victim_middlename,crime_victim_lastname,crime_victim_gender;
		String crime_victim_age,crime_victim_number,crime_victim_address,crime_victim_image,crime_id;

		crime_victim_firstname=crime_victimBeanObj.getCrime_victim_firstname();
		crime_victim_middlename=crime_victimBeanObj.getCrime_victim_middlename();
		crime_victim_lastname=crime_victimBeanObj.getCrime_victim_lastname();
		crime_victim_gender=crime_victimBeanObj.getCrime_victim_gender();
		crime_victim_age=crime_victimBeanObj.getCrime_victim_age();
		crime_victim_number=crime_victimBeanObj.getCrime_victim_number();
		crime_victim_address=crime_victimBeanObj.getCrime_victim_address();
		crime_victim_image=crime_victimBeanObj.getCrime_victim_image();
		crime_id=crime_victimBeanObj.getCrime_id();
		crime_victim_id=crime_victimBeanObj.getCrime_victim_id();
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("update  crime_victim set crime_victim_firstname=?,crime_victim_middlename=?,crime_victim_lastname=?,crime_victim_gender=?,crime_victim_age=?,crime_victim_number=?,crime_victim_address=?,crime_victim_image=?,crime_id=? where crime_victim_id=?");
				
				pstmt.setString(1, crime_victim_firstname);
				pstmt.setString(2, crime_victim_middlename);
				pstmt.setString(3, crime_victim_lastname);
				pstmt.setString(4, crime_victim_gender);
				pstmt.setString(5, crime_victim_age);
				pstmt.setString(6, crime_victim_number);
				pstmt.setString(7, crime_victim_address);
				pstmt.setString(8, crime_victim_image);
				pstmt.setString(9, crime_id);
				pstmt.setString(10, crime_victim_id);
				
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

	public List<crime_victimBean> view_particular(String crime_victim_id) {
		// TODO Auto-generated method stub
		
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		crime_victimBean crime_victimBeanObj=null;
		List<crime_victimBean> crime_victimBeanlist=new ArrayList<crime_victimBean>(); 
		

		PreparedStatement pstmt=null;
		
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("select * from crime_victim where crime_victim_id=?");
				pstmt.setString(1,crime_victim_id);
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					crime_victimBeanObj=new crime_victimBean();
				
					crime_victimBeanObj.setCrime_victim_firstname(rs.getString("crime_victim_firstname"));
					crime_victimBeanObj.setCrime_victim_middlename(rs.getString("crime_victim_middlename"));
					crime_victimBeanObj.setCrime_victim_lastname(rs.getString("crime_victim_lastname"));
					crime_victimBeanObj.setCrime_victim_gender(rs.getString("crime_victim_gender"));
					crime_victimBeanObj.setCrime_victim_age(rs.getString("crime_victim_age"));
					crime_victimBeanObj.setCrime_victim_number(rs.getString("crime_victim_number"));
					crime_victimBeanObj.setCrime_victim_address(rs.getString("crime_victim_address"));
					crime_victimBeanObj.setCrime_victim_image(rs.getString("crime_victim_image"));
					crime_victimBeanObj.setCrime_id(rs.getString("crime_id"));
					crime_victimBeanObj.setCrime_victim_id(rs.getString("crime_victim_id"));
					
					crime_victimBeanlist.add(crime_victimBeanObj);
				}
				
				
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		return crime_victimBeanlist;
		
	}
	
}
