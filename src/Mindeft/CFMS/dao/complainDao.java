package Mindeft.CFMS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Mindeft.CFMS.bean.complainBean;
import Mindeft.CFMS.bean.complain_status_Bean;
import Mindeft.CFMS.bean.user_typeBean;
import Mindeft.CFMS.util.DatabaseConnection;

public class complainDao {

	public static boolean insert(complainBean complainBeanObj) {
		// TODO Auto-generated method stub
		
		Connection conn=DatabaseConnection.getDbConnection();
		boolean status=false;
		String crime_id,police_station_id,complain_date,complain_details,complain_status_id,user_id,complain_id;
		int result;
		PreparedStatement pstmt=null;
			
		crime_id=complainBeanObj.getCrime_id();
		police_station_id=complainBeanObj.getPolice_station_id();
		complain_date=complainBeanObj.getComplain_date();
		complain_details=complainBeanObj.getComplain_details();
		complain_status_id=complainBeanObj.getComplain_status_id();
		user_id=complainBeanObj.getUser_id();
		
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("insert into complain(crime_id,police_station_id,complain_date,complain_details,complain_status_id,user_id) values(?,?,?,?,?,?)");
				
				pstmt.setString(1, crime_id);
				pstmt.setString(2, police_station_id);
				pstmt.setString(3, complain_date);
				pstmt.setString(4, complain_details);
				pstmt.setString(5, complain_status_id);
				pstmt.setString(6, user_id);
				
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

	public List<complainBean> select() {
		// TODO Auto-generated method stub
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		complainBean complainBeanObj=null;
		List<complainBean> complainBeanlist=new ArrayList<complainBean>(); 
		
		PreparedStatement pstmt=null;
		String crime_id,police_station_id,complain_date,complain_details,complain_status_id,user_id,complain_id;
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("select * from complain");
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					complainBeanObj=new complainBean();
					complainBeanObj.setPolice_station_id(rs.getString("police_station_id"));
					complainBeanObj.setComplain_date(rs.getString("complain_date"));
					complainBeanObj.setComplain_details(rs.getString("complain_details"));
					complainBeanObj.setComplain_status_id(rs.getString("complain_status_id"));
					complainBeanObj.setUser_id(rs.getString("user_id"));
					complainBeanObj.setComplain_id(rs.getString("complain_id"));		
					complainBeanObj.setCrime_id(rs.getString("crime_id"));
					
					complainBeanlist.add(complainBeanObj);
				}
				
				
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		return complainBeanlist;
	}

	public boolean delete(String complain_id) {
		// TODO Auto-generated method stub
		Connection conn=DatabaseConnection.getDbConnection();
		boolean result=false;
		PreparedStatement pstmt=null;
		
		if(conn!=null){
			//String insertSQL = "DELETE FROM STUDENT WHERE STUDENTID = ?";
			try {
				pstmt = conn.prepareStatement("DELETE FROM complain WHERE complain_id = ?");

				pstmt.setString(1,complain_id);
				
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

	public static complainBean getDatabyPK(String complain_id) {
		// TODO Auto-generated method stub
		
		complainBean complainBeanObj=null;
		
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		PreparedStatement pstmt=null;
		if(conn!=null){
			
			try {
				pstmt=conn.prepareStatement("SELECT * from complain WHERE complain_id = ?");
				pstmt.setString(1,complain_id);
				
				rs=pstmt.executeQuery();
				
				
				while(rs.next())
				{
					complainBeanObj=new complainBean();
					complainBeanObj.setPolice_station_id(rs.getString("police_station_id"));
					complainBeanObj.setComplain_date(rs.getString("complain_date"));
					complainBeanObj.setComplain_details(rs.getString("complain_details"));
					complainBeanObj.setComplain_status_id(rs.getString("complain_status_id"));
					complainBeanObj.setUser_id(rs.getString("user_id"));
					complainBeanObj.setComplain_id(rs.getString("complain_id"));		
					complainBeanObj.setCrime_id(rs.getString("crime_id"));
					
				}

				
				
			} catch (Exception e) {
				e.printStackTrace();
			
				
				
			}
			
		}
		
		
		return complainBeanObj;
	}

	public static boolean update(complainBean complainBeanObj) {
		// TODO Auto-generated method stub
		
		Connection conn=DatabaseConnection.getDbConnection();
		boolean status=false;
		String crime_id,police_station_id,complain_date,complain_details,complain_status_id,user_id,complain_id;
		int result;
		PreparedStatement pstmt=null;
		
		crime_id=complainBeanObj.getCrime_id();
		police_station_id=complainBeanObj.getPolice_station_id();
		complain_date=complainBeanObj.getComplain_date();
		complain_details=complainBeanObj.getComplain_details();
		complain_status_id=complainBeanObj.getComplain_status_id();
		user_id=complainBeanObj.getUser_id();
		complain_id=complainBeanObj.getComplain_id();
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("update complain set crime_id=?,police_station_id=?,complain_date=?,complain_details=?,complain_status_id=?,user_id=? WHERE complain_id = ?");
				
				pstmt.setString(1, crime_id);
				pstmt.setString(2, police_station_id);
				pstmt.setString(3, complain_date);
				pstmt.setString(4, complain_details);
				pstmt.setString(5, complain_status_id);
				pstmt.setString(6, user_id);
				pstmt.setString(7, complain_id);
				
				
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

	public List<complainBean> view_particular(String complain_id) {
		// TODO Auto-generated method stub
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		complainBean complainBeanObj=null;
		List<complainBean> complainBeanlist=new ArrayList<complainBean>(); 
		
		PreparedStatement pstmt=null;
		String crime_id,police_station_id,complain_date,complain_details,complain_status_id,user_id;
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("SELECT * from complain WHERE complain_id = ?");
				pstmt.setString(1,complain_id);
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					complainBeanObj=new complainBean();
					complainBeanObj.setPolice_station_id(rs.getString("police_station_id"));
					complainBeanObj.setComplain_date(rs.getString("complain_date"));
					complainBeanObj.setComplain_details(rs.getString("complain_details"));
					complainBeanObj.setComplain_status_id(rs.getString("complain_status_id"));
					complainBeanObj.setUser_id(rs.getString("user_id"));
					complainBeanObj.setComplain_id(rs.getString("complain_id"));		
					complainBeanObj.setCrime_id(rs.getString("crime_id"));
					
					complainBeanlist.add(complainBeanObj);
				}
				
				
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return complainBeanlist;
	}
	
	
	public List<complainBean> search_by_userid(String user_id) {
		// TODO Auto-generated method stub
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		System.out.println("USer id in search by user"+ user_id);
		
		complainBean complainBeanObj=null;
		List<complainBean> complainBeanlist=new ArrayList<complainBean>(); 
		
		PreparedStatement pstmt=null;
		String crime_id,police_station_id,complain_date,complain_details,complain_status_id;
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("SELECT * from complain WHERE user_id = ?");
				pstmt.setString(1,user_id);
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					complainBeanObj=new complainBean();
					complainBeanObj.setPolice_station_id(rs.getString("police_station_id"));
					complainBeanObj.setComplain_date(rs.getString("complain_date"));
					complainBeanObj.setComplain_details(rs.getString("complain_details"));
					complainBeanObj.setComplain_status_id(rs.getString("complain_status_id"));
					complainBeanObj.setUser_id(rs.getString("user_id"));
					complainBeanObj.setComplain_id(rs.getString("complain_id"));		
					complainBeanObj.setCrime_id(rs.getString("crime_id"));
					
					System.out.println("Inside Loop"+complainBeanObj.getCrime_id());
					
					complainBeanlist.add(complainBeanObj);
				}
				
				
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return complainBeanlist;
	}

	public static boolean update_details(complainBean complainBeanObj) {
		// TODO Auto-generated method stub
		
		Connection conn=DatabaseConnection.getDbConnection();
		boolean status=false;
		String crime_id,police_station_id,complain_date,complain_details,complain_status_id,user_id,complain_id;
		int result;
		PreparedStatement pstmt=null;
		
		//crime_id=complainBeanObj.getCrime_id();
		//police_station_id=complainBeanObj.getPolice_station_id();
		//complain_date=complainBeanObj.getComplain_date();
		complain_details=complainBeanObj.getComplain_details();
		//complain_status_id=complainBeanObj.getComplain_status_id();
		//user_id=complainBeanObj.getUser_id();
		complain_id=complainBeanObj.getComplain_id();
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("update complain set complain_details=? WHERE complain_id = ?");
				
				//pstmt.setString(1, crime_id);
				//pstmt.setString(2, police_station_id);
				//pstmt.setString(3, complain_date);
				pstmt.setString(1, complain_details);
				//pstmt.setString(5, complain_status_id);
				//pstmt.setString(6, user_id);
				pstmt.setString(2, complain_id);
				
				
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
	
	
}
