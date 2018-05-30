package Mindeft.CFMS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Mindeft.CFMS.bean.criminalBean;
import Mindeft.CFMS.bean.user_typeBean;
import Mindeft.CFMS.util.DatabaseConnection;

public class criminalDao {

	public static boolean insert(criminalBean criminalBeanObj) {
		// TODO Auto-generated method stub
		Connection conn=DatabaseConnection.getDbConnection();
		boolean status=false;
		String criminal_id,criminal_firstname,criminal_middlename,criminal_lastname;
		String criminal_gender,criminal_age,criminal_details,criminal_image,mostwanted,police_station_id;
		int result;
		PreparedStatement pstmt=null;
			
		criminal_firstname=criminalBeanObj.getCriminal_firstname();
		criminal_middlename=criminalBeanObj.getCriminal_middlename();
		criminal_lastname=criminalBeanObj.getCriminal_lastname();
		criminal_gender=criminalBeanObj.getCriminal_gender();
		criminal_age=criminalBeanObj.getCriminal_age();
		criminal_details=criminalBeanObj.getCriminal_details();
		criminal_image=criminalBeanObj.getCriminal_image();
		mostwanted=criminalBeanObj.getMostwanted();
		police_station_id=criminalBeanObj.getPolice_station_id();
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("insert into criminal(criminal_firstname,criminal_middlename,criminal_lastname,criminal_gender,criminal_age,criminal_details,criminal_image,mostwanted,police_station_id) values(?,?,?,?,?,?,?,?,?)");
				
				pstmt.setString(1, criminal_firstname);
				pstmt.setString(2, criminal_middlename);
				pstmt.setString(3, criminal_lastname);
				pstmt.setString(4, criminal_gender);
				pstmt.setString(5, criminal_age);
				pstmt.setString(6, criminal_details);
				pstmt.setString(7, criminal_image);
				pstmt.setString(8, mostwanted);
				pstmt.setString(9, police_station_id);
				
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

	public List<criminalBean> select() {
		// TODO Auto-generated method stub
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		criminalBean criminalBeanObj=null;
		List<criminalBean> criminalBeanlist=new ArrayList<criminalBean>(); 
		

		PreparedStatement pstmt=null;
		
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("select * from criminal");
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					criminalBeanObj=new criminalBean();
					
					criminalBeanObj.setCriminal_id(rs.getString("criminal_id"));
					criminalBeanObj.setCriminal_firstname(rs.getString("criminal_firstname"));
					criminalBeanObj.setCriminal_middlename(rs.getString("criminal_middlename"));
					criminalBeanObj.setCriminal_lastname(rs.getString("criminal_lastname"));
					criminalBeanObj.setCriminal_gender(rs.getString("criminal_gender"));
					criminalBeanObj.setCriminal_age(rs.getString("criminal_age"));
					criminalBeanObj.setCriminal_details(rs.getString("criminal_details"));
					criminalBeanObj.setCriminal_image(rs.getString("criminal_image"));
					criminalBeanObj.setMostwanted(rs.getString("mostwanted"));
					criminalBeanObj.setPolice_station_id(rs.getString("police_station_id"));
					
					criminalBeanlist.add(criminalBeanObj);
				}
				
				
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		return criminalBeanlist;
	}

	public boolean delete(String criminal_id) {
		// TODO Auto-generated method stub
		Connection conn=DatabaseConnection.getDbConnection();
		boolean result=false;
		PreparedStatement pstmt=null;
		
		if(conn!=null){
			//String insertSQL = "DELETE FROM STUDENT WHERE STUDENTID = ?";
			try {
				pstmt = conn.prepareStatement("DELETE FROM criminal WHERE criminal_id = ?");

				pstmt.setString(1,criminal_id);
				
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

	public static criminalBean getDatabyPK(String criminal_id) {
		// TODO Auto-generated method stub
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		criminalBean criminalBeanObj=null;
		
		PreparedStatement pstmt=null;
		if(conn!=null){
			
			try {
				pstmt=conn.prepareStatement("SELECT * from criminal WHERE criminal_id = ?");
				pstmt.setString(1,criminal_id);
				rs=pstmt.executeQuery();
				
				
				while(rs.next())
				{
					criminalBeanObj=new criminalBean();
					
					criminalBeanObj.setCriminal_id(rs.getString("criminal_id"));
					criminalBeanObj.setCriminal_firstname(rs.getString("criminal_firstname"));
					criminalBeanObj.setCriminal_middlename(rs.getString("criminal_middlename"));
					criminalBeanObj.setCriminal_lastname(rs.getString("criminal_lastname"));
					criminalBeanObj.setCriminal_gender(rs.getString("criminal_gender"));
					criminalBeanObj.setCriminal_age(rs.getString("criminal_age"));
					criminalBeanObj.setCriminal_details(rs.getString("criminal_details"));
					criminalBeanObj.setCriminal_image(rs.getString("criminal_image"));
					criminalBeanObj.setMostwanted(rs.getString("mostwanted"));
					criminalBeanObj.setPolice_station_id(rs.getString("police_station_id"));
					
				}

				
				
			} catch (Exception e) {
				e.printStackTrace();
			
				
				
			}
			
		}
		
		
		return criminalBeanObj;
	}

	public static boolean update(criminalBean criminalBeanObj) {
		// TODO Auto-generated method stub
		Connection conn=DatabaseConnection.getDbConnection();
		boolean status=false;
		String criminal_id,criminal_firstname,criminal_middlename,criminal_lastname;
		String criminal_gender,criminal_age,criminal_details,criminal_image,mostwanted,police_station_id;
		int result;
		PreparedStatement pstmt=null;
			
		criminal_firstname=criminalBeanObj.getCriminal_firstname();
		criminal_middlename=criminalBeanObj.getCriminal_middlename();
		criminal_lastname=criminalBeanObj.getCriminal_lastname();
		criminal_gender=criminalBeanObj.getCriminal_gender();
		criminal_age=criminalBeanObj.getCriminal_age();
		criminal_details=criminalBeanObj.getCriminal_details();
		criminal_image=criminalBeanObj.getCriminal_image();
		mostwanted=criminalBeanObj.getMostwanted();
		police_station_id=criminalBeanObj.getPolice_station_id();
		criminal_id=criminalBeanObj.getCriminal_id();
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("update criminal set  criminal_firstname=?,criminal_middlename=?,criminal_lastname=?,criminal_gender=?,criminal_age=?,criminal_details=?,criminal_image=?,mostwanted=?,police_station_id=?   where criminal_id=?");
				
				pstmt.setString(1, criminal_firstname);
				pstmt.setString(2, criminal_middlename);
				pstmt.setString(3, criminal_lastname);
				pstmt.setString(4, criminal_gender);
				pstmt.setString(5, criminal_age);
				pstmt.setString(6, criminal_details);
				pstmt.setString(7, criminal_image);
				pstmt.setString(8, mostwanted);
				pstmt.setString(9, police_station_id);
				pstmt.setString(10, criminal_id);
				
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

	public List<criminalBean> view_particular(String criminal_id) {
		// TODO Auto-generated method stub
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		criminalBean criminalBeanObj=null;
		List<criminalBean> criminalBeanlist=new ArrayList<criminalBean>(); 
		

		PreparedStatement pstmt=null;
		
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("SELECT * from criminal WHERE criminal_id = ?");
				pstmt.setString(1,criminal_id);
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					criminalBeanObj=new criminalBean();
					
					criminalBeanObj.setCriminal_id(rs.getString("criminal_id"));
					criminalBeanObj.setCriminal_firstname(rs.getString("criminal_firstname"));
					criminalBeanObj.setCriminal_middlename(rs.getString("criminal_middlename"));
					criminalBeanObj.setCriminal_lastname(rs.getString("criminal_lastname"));
					criminalBeanObj.setCriminal_gender(rs.getString("criminal_gender"));
					criminalBeanObj.setCriminal_age(rs.getString("criminal_age"));
					criminalBeanObj.setCriminal_details(rs.getString("criminal_details"));
					criminalBeanObj.setCriminal_image(rs.getString("criminal_image"));
					criminalBeanObj.setMostwanted(rs.getString("mostwanted"));
					criminalBeanObj.setPolice_station_id(rs.getString("police_station_id"));
					
					criminalBeanlist.add(criminalBeanObj);
				}
				
				
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		return criminalBeanlist;
	}

}
