package Mindeft.CFMS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Mindeft.CFMS.bean.police_station_Bean;
import Mindeft.CFMS.bean.user_typeBean;
import Mindeft.CFMS.util.DatabaseConnection;

public class police_stationDao {

	public static boolean insert(police_station_Bean police_station_BeanObj) {
		
		Connection conn=DatabaseConnection.getDbConnection();
		boolean status=false;
		int result;
		PreparedStatement pstmt=null;
		String police_station_name,area_id,contact; 
		
		police_station_name=police_station_BeanObj.getPolice_station_name();
		area_id=police_station_BeanObj.getArea_id();
		contact=police_station_BeanObj.getContact();
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("insert into police_station(police_station_name,area_id,contact) values(?,?,?)");
				
				pstmt.setString(1, police_station_name);
				pstmt.setString(2, area_id);
				pstmt.setString(3, contact);
				
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

	public List<police_station_Bean> select() {
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		List<police_station_Bean> police_stationlist=new ArrayList<police_station_Bean>(); 
		
		police_station_Bean police_station_BeanObj=null; 

		PreparedStatement pstmt=null;
		
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("select * from police_station");
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					police_station_BeanObj=new police_station_Bean();
					
					police_station_BeanObj.setPolice_station_id(rs.getString("police_station_id"));
					police_station_BeanObj.setPolice_station_name(rs.getString("police_station_name"));
					police_station_BeanObj.setContact(rs.getString("contact"));
					police_station_BeanObj.setArea_id(rs.getString("area_id"));
					
					police_stationlist.add(police_station_BeanObj);
				}
				
				
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		return police_stationlist;
	}

	public boolean delete(String police_station_id) {
		
		Connection conn=DatabaseConnection.getDbConnection();
		boolean result=false;
		PreparedStatement pstmt=null;
		
		if(conn!=null){
			//String insertSQL = "DELETE FROM STUDENT WHERE STUDENTID = ?";
			try {
				pstmt = conn.prepareStatement("DELETE FROM police_station WHERE police_station_id = ?");

				pstmt.setString(1,police_station_id);
				
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

	public static police_station_Bean getDatabyPK(String police_station_id) {
		
		police_station_Bean police_station_BeanObj=null; 
		
		
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		PreparedStatement pstmt=null;
		if(conn!=null){
			
			try {
				pstmt=conn.prepareStatement("SELECT * from police_station WHERE police_station_id = ?");
				pstmt.setString(1,police_station_id);
				rs=pstmt.executeQuery();
				
				
				while(rs.next())
				{
					police_station_BeanObj=new police_station_Bean();
					
					police_station_BeanObj.setPolice_station_id(rs.getString("police_station_id"));
					police_station_BeanObj.setPolice_station_name(rs.getString("police_station_name"));
					police_station_BeanObj.setContact(rs.getString("contact"));
					police_station_BeanObj.setArea_id(rs.getString("area_id"));
					
				}

				
				
			} catch (Exception e) {
				e.printStackTrace();
			
				
				
			}
			
		}
		
		
		return police_station_BeanObj;
	}

	public boolean update(police_station_Bean police_station_BeanObj) {
		
		Connection conn=DatabaseConnection.getDbConnection();
		boolean status=false;
		String police_station_id,police_station_name,area_id,contact;
		
		int result;
		PreparedStatement pstmt=null;
		
		police_station_id=police_station_BeanObj.getPolice_station_id();
		police_station_name=police_station_BeanObj.getPolice_station_name();
		area_id=police_station_BeanObj.getArea_id();
		contact=police_station_BeanObj.getContact();
	
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("update police_station set police_station_name=?,area_id=?,contact=? WHERE police_station_id = ?");
				
				pstmt.setString(1,police_station_name);
				pstmt.setString(2, area_id);
				pstmt.setString(3, contact);
				pstmt.setString(4, police_station_id);
				
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

	public List<police_station_Bean> view_paricular(String police_station_id) {
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		List<police_station_Bean> police_stationlist=new ArrayList<police_station_Bean>(); 
		
		police_station_Bean police_station_BeanObj=null; 

		PreparedStatement pstmt=null;
		
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("SELECT * from police_station WHERE police_station_id = ?");
				pstmt.setString(1,police_station_id);
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					police_station_BeanObj=new police_station_Bean();
					
					police_station_BeanObj.setPolice_station_id(rs.getString("police_station_id"));
					police_station_BeanObj.setPolice_station_name(rs.getString("police_station_name"));
					police_station_BeanObj.setContact(rs.getString("contact"));
					police_station_BeanObj.setArea_id(rs.getString("area_id"));
					
					police_stationlist.add(police_station_BeanObj);
				}
				
				
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		return police_stationlist;
	}

}
