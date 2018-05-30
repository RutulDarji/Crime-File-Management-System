package Mindeft.CFMS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Mindeft.CFMS.bean.crimeBean;
import Mindeft.CFMS.bean.user_typeBean;
import Mindeft.CFMS.util.DatabaseConnection;

public class crimeDao {

	public static boolean insert(crimeBean crimeBeanObj) {
		Connection conn=DatabaseConnection.getDbConnection();
		boolean status=false;
		String CrimeType_Id,area_id,crime_date,crime_details,location_description,crime_id;
		int result;
		PreparedStatement pstmt=null;
			
		
		CrimeType_Id=crimeBeanObj.getCrimeType_Id();
		area_id=crimeBeanObj.getArea_id();
		crime_date=crimeBeanObj.getCrime_date();
		crime_details=crimeBeanObj.getCrime_details();
		location_description=crimeBeanObj.getLocation_description();
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("insert into crime(CrimeType_Id,area_id,crime_date,crime_details,location_description) values(?,?,?,?,?)");
				
				pstmt.setString(1, CrimeType_Id);
				pstmt.setString(2, area_id);
				pstmt.setString(3, crime_date);
				pstmt.setString(4, crime_details);
				pstmt.setString(5, location_description);
				
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

	public List<crimeBean> select() {
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		//crimeBean crimeBeanObj=null;
		crimeBean crimeBeanObj=null; 
		List<crimeBean> crimeBeanlist=new ArrayList<crimeBean>(); 
		

		PreparedStatement pstmt=null;
		
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("select * from crime");
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					crimeBeanObj=new crimeBean();				
					
					crimeBeanObj.setCrime_id(rs.getString("crime_id"));
					crimeBeanObj.setCrimeType_Id(rs.getString("CrimeType_Id"));
					crimeBeanObj.setArea_id(rs.getString("area_id"));
					crimeBeanObj.setCrime_date(rs.getString("crime_date"));
					crimeBeanObj.setCrime_details(rs.getString("crime_details"));
					crimeBeanObj.setLocation_description(rs.getString("location_description"));
					
					crimeBeanlist.add(crimeBeanObj);
				}
				
 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		return crimeBeanlist;
	}

	public boolean delete(String crime_id) {
		
		
		Connection conn=DatabaseConnection.getDbConnection();
		boolean result=false;
		PreparedStatement pstmt=null;
		
		if(conn!=null){
			//String insertSQL = "DELETE FROM STUDENT WHERE STUDENTID = ?";
			try {
				pstmt = conn.prepareStatement("DELETE FROM crime WHERE crime_id = ?");

				pstmt.setString(1,crime_id);
				
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

	public static crimeBean getDatabyPK(String crime_id) {
		crimeBean crimeBeanObj=null;
		
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		PreparedStatement pstmt=null;
		if(conn!=null){
			
			try {
				pstmt=conn.prepareStatement("SELECT * from crime WHERE crime_id = ?");
				pstmt.setString(1,crime_id);
				rs=pstmt.executeQuery();
				
				
				while(rs.next())
				{
					crimeBeanObj=new crimeBean();
					
					crimeBeanObj.setCrime_id(rs.getString("crime_id"));
					crimeBeanObj.setCrimeType_Id(rs.getString("CrimeType_Id"));
					crimeBeanObj.setArea_id(rs.getString("area_id"));
					crimeBeanObj.setCrime_date(rs.getString("crime_date"));
					crimeBeanObj.setCrime_details(rs.getString("crime_details"));
					crimeBeanObj.setLocation_description(rs.getString("location_description"));
					
				}

				
				
			} catch (Exception e) {
				e.printStackTrace();
			
				
				
			}
			
		}
		
		
		return crimeBeanObj;
	}

	public static boolean update(crimeBean crimeBeanObj) {
		// TODO Auto-generated method stub
		Connection conn=DatabaseConnection.getDbConnection();
		boolean status=false;
		String CrimeType_Id,area_id,crime_date,crime_details,location_description,crime_id;
		
		int result;
		PreparedStatement pstmt=null;
		
		CrimeType_Id=crimeBeanObj.getCrimeType_Id();
		area_id=crimeBeanObj.getArea_id();
		crime_date=crimeBeanObj.getCrime_date();
		crime_details=crimeBeanObj.getCrime_details();
		location_description=crimeBeanObj.getLocation_description();
		crime_id=crimeBeanObj.getCrime_id();
	
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("update crime set CrimeType_Id=?,area_id=?,crime_date=?,crime_details=?,location_description=? WHERE crime_id = ?");
				
				pstmt.setString(1, CrimeType_Id);
				pstmt.setString(2, area_id);
				pstmt.setString(3, crime_date);
				pstmt.setString(4, crime_details);
				pstmt.setString(5, location_description);
				pstmt.setString(6, crime_id);
				
				
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

	public List<crimeBean> view_particular(String crime_id) {
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		crimeBean crimeBeanObj=null;
		List<crimeBean> crimeBeanlist=new ArrayList<crimeBean>(); 
		

		PreparedStatement pstmt=null;
		
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("SELECT * from crime WHERE crime_id = ?");
				pstmt.setString(1,crime_id);
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					crimeBeanObj=new crimeBean();
									
					crimeBeanObj.setCrime_id(rs.getString("crime_id"));
					crimeBeanObj.setCrimeType_Id(rs.getString("CrimeType_Id"));
					crimeBeanObj.setArea_id(rs.getString("area_id"));
					crimeBeanObj.setCrime_date(rs.getString("crime_date"));
					crimeBeanObj.setCrime_details(rs.getString("crime_details"));
					crimeBeanObj.setLocation_description(rs.getString("location_description"));
					
					crimeBeanlist.add(crimeBeanObj);
				}
				
 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		return crimeBeanlist;
	}

	

}
