package Mindeft.CFMS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Mindeft.CFMS.bean.crime_witnessBean;
import Mindeft.CFMS.bean.missing_personBean;
import Mindeft.CFMS.util.DatabaseConnection;

public class crime_witnessDao {

	public static boolean insert(crime_witnessBean crime_witnessBeanObj) {
		// TODO Auto-generated method stub
		Connection conn=DatabaseConnection.getDbConnection();
		boolean status=false;
		String user_type=new String();
		int result;
		PreparedStatement pstmt=null;
		
		String crime_witness_id,crime_witness_firstname,crime_witness_middlename,crime_witness_lastname,crime_witness_gender;
		String crime_witness_age,crime_witness_number,crime_witness_address,crime_witness_image,crime_id;
		
		crime_witness_firstname=crime_witnessBeanObj.getCrime_witness_firstname();
		crime_witness_middlename=crime_witnessBeanObj.getCrime_witness_middlename();
		crime_witness_lastname=crime_witnessBeanObj.getCrime_witness_lastname();
		crime_witness_gender=crime_witnessBeanObj.getCrime_witness_gender();
		crime_witness_age=crime_witnessBeanObj.getCrime_witness_age();
		crime_witness_number=crime_witnessBeanObj.getCrime_witness_number();
		crime_witness_address=crime_witnessBeanObj.getCrime_witness_address();
		crime_witness_image=crime_witnessBeanObj.getCrime_witness_image();
		crime_id=crime_witnessBeanObj.getCrime_id();
		
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("insert into crime_witness(crime_witness_firstname,crime_witness_middlename,crime_witness_lastname,crime_witness_gender,crime_witness_age,crime_witness_number,crime_witness_address,crime_witness_image,crime_id) values(?,?,?,?,?,?,?,?,?);");
				
				pstmt.setString(1, crime_witness_firstname);
				pstmt.setString(2, crime_witness_middlename);
				pstmt.setString(3, crime_witness_lastname);
				pstmt.setString(4, crime_witness_gender);
				pstmt.setString(5, crime_witness_age);
				pstmt.setString(6, crime_witness_number);
				pstmt.setString(7, crime_witness_address);
				pstmt.setString(8, crime_witness_image);
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

	public List<crime_witnessBean> select() {
		// TODO Auto-generated method stub
		
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		crime_witnessBean crime_witnessBeanObj=null;
		List<crime_witnessBean> crime_witnessBeanlist=new ArrayList<crime_witnessBean>(); 
		

		PreparedStatement pstmt=null;
		
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("select * from crime_witness");
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					crime_witnessBeanObj=new crime_witnessBean();
					
					crime_witnessBeanObj.setCrime_witness_firstname(rs.getString("crime_witness_firstname"));
					crime_witnessBeanObj.setCrime_witness_middlename(rs.getString("crime_witness_middlename"));
					crime_witnessBeanObj.setCrime_witness_lastname(rs.getString("crime_witness_lastname"));
					crime_witnessBeanObj.setCrime_witness_gender(rs.getString("crime_witness_gender"));
					crime_witnessBeanObj.setCrime_witness_age(rs.getString("crime_witness_age"));
					crime_witnessBeanObj.setCrime_witness_number(rs.getString("crime_witness_number"));
					crime_witnessBeanObj.setCrime_witness_address(rs.getString("crime_witness_address"));
					crime_witnessBeanObj.setCrime_witness_image(rs.getString("crime_witness_image"));
					crime_witnessBeanObj.setCrime_id(rs.getString("crime_id"));
					crime_witnessBeanObj.setCrime_witness_id(rs.getString("crime_witness_id"));
					
					crime_witnessBeanlist.add(crime_witnessBeanObj);
				}
				
				
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		return crime_witnessBeanlist;
	}

	public boolean delete(String crime_witness_id) {
		// TODO Auto-generated method stub
		Connection conn=DatabaseConnection.getDbConnection();
		boolean result=false;
		PreparedStatement pstmt=null;
		
		if(conn!=null){
			//String insertSQL = "DELETE FROM STUDENT WHERE STUDENTID = ?";
			try {
				pstmt = conn.prepareStatement("DELETE FROM crime_witness WHERE crime_witness_id = ?");

				pstmt.setString(1,crime_witness_id);
				
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

	 public static crime_witnessBean getDatabyPK(String crime_witness_id) {
		// TODO Auto-generated method stub
		 
		    crime_witnessBean crime_witnessBeanObj=null;
			
			Connection conn=DatabaseConnection.getDbConnection();
			ResultSet rs=null;
			
			PreparedStatement pstmt=null;
			if(conn!=null){
				
				try {
					pstmt=conn.prepareStatement("SELECT * from crime_witness WHERE crime_witness_id = ?");
					pstmt.setString(1,crime_witness_id);
					rs=pstmt.executeQuery();
					
					
					while(rs.next())
					{
						crime_witnessBeanObj=new crime_witnessBean();
						
						crime_witnessBeanObj.setCrime_witness_firstname(rs.getString("crime_witness_firstname"));
						crime_witnessBeanObj.setCrime_witness_middlename(rs.getString("crime_witness_middlename"));
						crime_witnessBeanObj.setCrime_witness_lastname(rs.getString("crime_witness_lastname"));
						crime_witnessBeanObj.setCrime_witness_gender(rs.getString("crime_witness_gender"));
						crime_witnessBeanObj.setCrime_witness_age(rs.getString("crime_witness_age"));
						crime_witnessBeanObj.setCrime_witness_number(rs.getString("crime_witness_number"));
						crime_witnessBeanObj.setCrime_witness_address(rs.getString("crime_witness_address"));
						crime_witnessBeanObj.setCrime_witness_image(rs.getString("crime_witness_image"));
						crime_witnessBeanObj.setCrime_id(rs.getString("crime_id"));
						crime_witnessBeanObj.setCrime_witness_id(rs.getString("crime_witness_id"));
					}

					
					
				} catch (Exception e) {
					e.printStackTrace();
				
					
					
				}
				
			}
			
			
			return crime_witnessBeanObj;
	}

	public static boolean update(crime_witnessBean crime_witnessBeanObj) {
		// TODO Auto-generated method stub
		Connection conn=DatabaseConnection.getDbConnection();
		boolean status=false;
		String user_type=new String();
		int result;
		PreparedStatement pstmt=null;
		
		String crime_witness_id,crime_witness_firstname,crime_witness_middlename,crime_witness_lastname,crime_witness_gender;
		String crime_witness_age,crime_witness_number,crime_witness_address,crime_witness_image,crime_id;
		
		crime_witness_firstname=crime_witnessBeanObj.getCrime_witness_firstname();
		crime_witness_middlename=crime_witnessBeanObj.getCrime_witness_middlename();
		crime_witness_lastname=crime_witnessBeanObj.getCrime_witness_lastname();
		crime_witness_gender=crime_witnessBeanObj.getCrime_witness_gender();
		crime_witness_age=crime_witnessBeanObj.getCrime_witness_age();
		crime_witness_number=crime_witnessBeanObj.getCrime_witness_number();
		crime_witness_address=crime_witnessBeanObj.getCrime_witness_address();
		crime_witness_image=crime_witnessBeanObj.getCrime_witness_image();
		crime_id=crime_witnessBeanObj.getCrime_id();
		crime_witness_id=crime_witnessBeanObj.getCrime_witness_id();
		
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("update  crime_witness set crime_witness_firstname=?,crime_witness_middlename=?,crime_witness_lastname=?,crime_witness_gender=?,crime_witness_age=?,crime_witness_number=?,crime_witness_address=?,crime_witness_image=?,crime_id=? where crime_witness_id=?");
				
				pstmt.setString(1, crime_witness_firstname);
				pstmt.setString(2, crime_witness_middlename);
				pstmt.setString(3, crime_witness_lastname);
				pstmt.setString(4, crime_witness_gender);
				pstmt.setString(5, crime_witness_age);
				pstmt.setString(6, crime_witness_number);
				pstmt.setString(7, crime_witness_address);
				pstmt.setString(8, crime_witness_image);
				pstmt.setString(9, crime_id);
				pstmt.setString(10, crime_witness_id);
				
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

	public List<crime_witnessBean> view_particular(String crime_witness_id) {
		// TODO Auto-generated method stub
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		crime_witnessBean crime_witnessBeanObj=null;
		List<crime_witnessBean> crime_witnessBeanlist=new ArrayList<crime_witnessBean>(); 
		

		PreparedStatement pstmt=null;
		
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("SELECT * from crime_witness WHERE crime_witness_id = ?");
				pstmt.setString(1,crime_witness_id);
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					crime_witnessBeanObj=new crime_witnessBean();
					
					crime_witnessBeanObj.setCrime_witness_firstname(rs.getString("crime_witness_firstname"));
					crime_witnessBeanObj.setCrime_witness_middlename(rs.getString("crime_witness_middlename"));
					crime_witnessBeanObj.setCrime_witness_lastname(rs.getString("crime_witness_lastname"));
					crime_witnessBeanObj.setCrime_witness_gender(rs.getString("crime_witness_gender"));
					crime_witnessBeanObj.setCrime_witness_age(rs.getString("crime_witness_age"));
					crime_witnessBeanObj.setCrime_witness_number(rs.getString("crime_witness_number"));
					crime_witnessBeanObj.setCrime_witness_address(rs.getString("crime_witness_address"));
					crime_witnessBeanObj.setCrime_witness_image(rs.getString("crime_witness_image"));
					crime_witnessBeanObj.setCrime_id(rs.getString("crime_id"));
					crime_witnessBeanObj.setCrime_witness_id(rs.getString("crime_witness_id"));
					
					crime_witnessBeanlist.add(crime_witnessBeanObj);
				}
				
				
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		return crime_witnessBeanlist;
	}

}
