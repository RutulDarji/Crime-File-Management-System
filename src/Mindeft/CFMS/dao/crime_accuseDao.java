package Mindeft.CFMS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Mindeft.CFMS.bean.crime_accuseBean;
import Mindeft.CFMS.util.DatabaseConnection;

public class crime_accuseDao {

	public static boolean insert(crime_accuseBean crime_accuseBeanObj) {
		// TODO Auto-generated method stub
		Connection conn=DatabaseConnection.getDbConnection();
		boolean status=false;
		
		int result;
		PreparedStatement pstmt=null;
		
		String crime_accuse_id,crime_accuse_firstname,crime_accuse_middlename,crime_accuse_lastname,crime_accuse_gender;
		String crime_accuse_age,crime_accuse_number,crime_accuse_address,crime_accuse_image,crime_id;

		crime_accuse_firstname=crime_accuseBeanObj.getCrime_accuse_firstname();
		crime_accuse_middlename=crime_accuseBeanObj.getCrime_accuse_middlename();
		crime_accuse_lastname=crime_accuseBeanObj.getCrime_accuse_lastname();
		crime_accuse_gender=crime_accuseBeanObj.getCrime_accuse_gender();
		crime_accuse_age=crime_accuseBeanObj.getCrime_accuse_age();
		crime_accuse_number=crime_accuseBeanObj.getCrime_accuse_number();
		crime_accuse_address=crime_accuseBeanObj.getCrime_accuse_address();
		crime_accuse_image=crime_accuseBeanObj.getCrime_accuse_image();
		crime_id=crime_accuseBeanObj.getCrime_id();
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("insert into crime_accuse(crime_accuse_firstname,crime_accuse_middlename,crime_accuse_lastname,crime_accuse_gender,crime_accuse_age,crime_accuse_number,crime_accuse_address,crime_accuse_image,crime_id) values(?,?,?,?,?,?,?,?,?);");
				
				pstmt.setString(1, crime_accuse_firstname);
				pstmt.setString(2, crime_accuse_middlename);
				pstmt.setString(3, crime_accuse_lastname);
				pstmt.setString(4, crime_accuse_gender);
				pstmt.setString(5, crime_accuse_age);
				pstmt.setString(6, crime_accuse_number);
				pstmt.setString(7, crime_accuse_address);
				pstmt.setString(8, crime_accuse_image);
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
	
	public List<crime_accuseBean> select() {
		// TODO Auto-generated method stub
		
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		crime_accuseBean crime_accuseBeanObj=null;
		List<crime_accuseBean> crime_accuseBeanlist=new ArrayList<crime_accuseBean>(); 
		

		PreparedStatement pstmt=null;
		
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("select * from crime_accuse");
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					crime_accuseBeanObj=new crime_accuseBean();
					
					/*crime_accuseBeanObj.setcrime_accuse_firstname(rs.getString("crime_accuse_firstname"));
					crime_accuseBeanObj.setcrime_accuse_middlename(rs.getString("crime_accuse_middlename"));
					crime_accuseBeanObj.setcrime_accuse_lastname(rs.getString("crime_accuse_lastname"));
					crime_accuseBeanObj.setcrime_accuse_gender(rs.getString("crime_accuse_gender"));
					crime_accuseBeanObj.setcrime_accuse_age(rs.getString("crime_accuse_age"));
					crime_accuseBeanObj.setcrime_accuse_number(rs.getString("crime_accuse_number"));
					crime_accuseBeanObj.setcrime_accuse_address(rs.getString("crime_accuse_address"));
					crime_accuseBeanObj.setcrime_accuse_image(rs.getString("crime_accuse_image"));
					crime_accuseBeanObj.setCrime_id(rs.getString("crime_id"));
					crime_accuseBeanObj.setcrime_accuse_id(rs.getString("crime_accuse_id"));
					*/
					
					crime_accuseBeanObj.setCrime_accuse_firstname(rs.getString("crime_accuse_firstname"));
					crime_accuseBeanObj.setCrime_accuse_middlename(rs.getString("crime_accuse_middlename"));
					crime_accuseBeanObj.setCrime_accuse_lastname(rs.getString("crime_accuse_lastname"));
					crime_accuseBeanObj.setCrime_accuse_gender(rs.getString("crime_accuse_gender"));
					crime_accuseBeanObj.setCrime_accuse_age(rs.getString("crime_accuse_age"));
					crime_accuseBeanObj.setCrime_accuse_number(rs.getString("crime_accuse_number"));
					crime_accuseBeanObj.setCrime_accuse_address(rs.getString("crime_accuse_address"));
					crime_accuseBeanObj.setCrime_accuse_image(rs.getString("crime_accuse_image"));
					crime_accuseBeanObj.setCrime_id(rs.getString("crime_id"));
					crime_accuseBeanObj.setCrime_accuse_id(rs.getString("crime_accuse_id"));
					
					crime_accuseBeanlist.add(crime_accuseBeanObj);
				}
				
				
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		return crime_accuseBeanlist;
	}

	public boolean delete(String crime_accuse_id) {
		Connection conn=DatabaseConnection.getDbConnection();
		boolean result=false;
		PreparedStatement pstmt=null;
		
		if(conn!=null){
			//String insertSQL = "DELETE FROM STUDENT WHERE STUDENTID = ?";
			try {
				pstmt = conn.prepareStatement("DELETE FROM crime_accuse WHERE crime_accuse_id = ?");

				pstmt.setString(1,crime_accuse_id);
				
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

	public static crime_accuseBean getDatabyPK(String crime_accuse_id) {
		
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		crime_accuseBean crime_accuseBeanObj=null;
		//List<crime_accuseBean> crime_accuseBeanlist=new ArrayList<crime_accuseBean>(); 
		

		PreparedStatement pstmt=null;
		
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("select * from crime_accuse where crime_accuse_id=?");
				pstmt.setString(1,crime_accuse_id);
				
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					crime_accuseBeanObj=new crime_accuseBean();
					
					
					crime_accuseBeanObj.setCrime_accuse_firstname(rs.getString("crime_accuse_firstname"));
					crime_accuseBeanObj.setCrime_accuse_middlename(rs.getString("crime_accuse_middlename"));
					crime_accuseBeanObj.setCrime_accuse_lastname(rs.getString("crime_accuse_lastname"));
					crime_accuseBeanObj.setCrime_accuse_gender(rs.getString("crime_accuse_gender"));
					crime_accuseBeanObj.setCrime_accuse_age(rs.getString("crime_accuse_age"));
					crime_accuseBeanObj.setCrime_accuse_number(rs.getString("crime_accuse_number"));
					crime_accuseBeanObj.setCrime_accuse_address(rs.getString("crime_accuse_address"));
					crime_accuseBeanObj.setCrime_accuse_image(rs.getString("crime_accuse_image"));
					crime_accuseBeanObj.setCrime_id(rs.getString("crime_id"));
					crime_accuseBeanObj.setCrime_accuse_id(rs.getString("crime_accuse_id"));
					
				}
				
				
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		return crime_accuseBeanObj;
		
		
	}

	public static boolean update(crime_accuseBean crime_accuseBeanObj) {
		// TODO Auto-generated method stub
		Connection conn=DatabaseConnection.getDbConnection();
		boolean status=false;
		
		int result;
		PreparedStatement pstmt=null;
		
		String crime_accuse_id,crime_accuse_firstname,crime_accuse_middlename,crime_accuse_lastname,crime_accuse_gender;
		String crime_accuse_age,crime_accuse_number,crime_accuse_address,crime_accuse_image,crime_id;

		crime_accuse_firstname=crime_accuseBeanObj.getCrime_accuse_firstname();
		crime_accuse_middlename=crime_accuseBeanObj.getCrime_accuse_middlename();
		crime_accuse_lastname=crime_accuseBeanObj.getCrime_accuse_lastname();
		crime_accuse_gender=crime_accuseBeanObj.getCrime_accuse_gender();
		crime_accuse_age=crime_accuseBeanObj.getCrime_accuse_age();
		crime_accuse_number=crime_accuseBeanObj.getCrime_accuse_number();
		crime_accuse_address=crime_accuseBeanObj.getCrime_accuse_address();
		crime_accuse_image=crime_accuseBeanObj.getCrime_accuse_image();
		crime_id=crime_accuseBeanObj.getCrime_id();
		crime_accuse_id=crime_accuseBeanObj.getCrime_accuse_id();
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("update  crime_accuse set crime_accuse_firstname=?,crime_accuse_middlename=?,crime_accuse_lastname=?,crime_accuse_gender=?,crime_accuse_age=?,crime_accuse_number=?,crime_accuse_address=?,crime_accuse_image=?,crime_id=? where crime_accuse_id=?");
				
				pstmt.setString(1, crime_accuse_firstname);
				pstmt.setString(2, crime_accuse_middlename);
				pstmt.setString(3, crime_accuse_lastname);
				pstmt.setString(4, crime_accuse_gender);
				pstmt.setString(5, crime_accuse_age);
				pstmt.setString(6, crime_accuse_number);
				pstmt.setString(7, crime_accuse_address);
				pstmt.setString(8, crime_accuse_image);
				pstmt.setString(9, crime_id);
				pstmt.setString(10, crime_accuse_id);
				
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

	public List<crime_accuseBean> view_particular(String crime_accuse_id) {
		// TODO Auto-generated method stub
		
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		crime_accuseBean crime_accuseBeanObj=null;
		List<crime_accuseBean> crime_accuseBeanlist=new ArrayList<crime_accuseBean>(); 
		

		PreparedStatement pstmt=null;
		
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("select * from crime_accuse where crime_accuse_id=?");
				pstmt.setString(1,crime_accuse_id);
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					crime_accuseBeanObj=new crime_accuseBean();
				
					crime_accuseBeanObj.setCrime_accuse_firstname(rs.getString("crime_accuse_firstname"));
					crime_accuseBeanObj.setCrime_accuse_middlename(rs.getString("crime_accuse_middlename"));
					crime_accuseBeanObj.setCrime_accuse_lastname(rs.getString("crime_accuse_lastname"));
					crime_accuseBeanObj.setCrime_accuse_gender(rs.getString("crime_accuse_gender"));
					crime_accuseBeanObj.setCrime_accuse_age(rs.getString("crime_accuse_age"));
					crime_accuseBeanObj.setCrime_accuse_number(rs.getString("crime_accuse_number"));
					crime_accuseBeanObj.setCrime_accuse_address(rs.getString("crime_accuse_address"));
					crime_accuseBeanObj.setCrime_accuse_image(rs.getString("crime_accuse_image"));
					crime_accuseBeanObj.setCrime_id(rs.getString("crime_id"));
					crime_accuseBeanObj.setCrime_accuse_id(rs.getString("crime_accuse_id"));
					
					crime_accuseBeanlist.add(crime_accuseBeanObj);
				}
				
				
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		return crime_accuseBeanlist;
		
	}
}
