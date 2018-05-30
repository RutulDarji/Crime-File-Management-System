package Mindeft.CFMS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Mindeft.CFMS.bean.cityBean;
import Mindeft.CFMS.bean.countryBean;
import Mindeft.CFMS.bean.stateBean;
import Mindeft.CFMS.util.DatabaseConnection;

public class cityDao {

	public static boolean insert(cityBean cityBeanobj) {
		
		Connection conn=DatabaseConnection.getDbConnection();
		boolean status=false;
		int result;
		PreparedStatement pstmt=null;
			
		
		String city_name=cityBeanobj.getCity_name();
		String state_id=cityBeanobj.getState_id();
		
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("insert into city(city_name,state_id) values(?,?)");
				
				pstmt.setString(1, city_name);
				pstmt.setString(2, state_id);
				
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

	public List<cityBean> select() {
		// TODO Auto-generated method stub
		
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		cityBean cityBeanobj=null;
		List<cityBean> citylist=new ArrayList<cityBean>(); 
		

		PreparedStatement pstmt=null;
		
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("select * from city");
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					cityBeanobj=new cityBean();
					
					cityBeanobj.setCity_id(rs.getString("city_id"));
					cityBeanobj.setCity_name(rs.getString("city_name"));
					cityBeanobj.setState_id(rs.getString("state_id"));
				
					
					citylist.add(cityBeanobj);
				}
				
				
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		return citylist;
		
	}

	public boolean delete(String city_id) {
		// TODO Auto-generated method stub
	
		Connection conn=DatabaseConnection.getDbConnection();
		boolean result=false;
		PreparedStatement pstmt=null;
		
		if(conn!=null){
			//String insertSQL = "DELETE FROM STUDENT WHERE STUDENTID = ?";
			try {
				pstmt = conn.prepareStatement("DELETE FROM city WHERE city_id = ?");

				pstmt.setString(1,city_id);
				
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

	public static cityBean getDatabyPK(String city_id) {
		
		cityBean cityBeanObj=null;		
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		System.out.println("city id in get data:"+ city_id);
		
		PreparedStatement pstmt=null;
		if(conn!=null){
			
			try {
				pstmt=conn.prepareStatement("SELECT * from city WHERE city_id = ?");

				pstmt.setString(1,city_id);
				rs=pstmt.executeQuery();
				
				
				while(rs.next())
				{
					cityBeanObj=new cityBean();
					
					cityBeanObj.setCity_id(rs.getString("city_id"));
					cityBeanObj.setCity_name(rs.getString("city_name"));
					cityBeanObj.setState_id(rs.getString("state_id"));
				}

				
			} catch (Exception e) {
				e.printStackTrace();
							
			}
			
		}
		
		
		return cityBeanObj;
		
	}
	
	
	public boolean update(cityBean cityBeanobj) {
		// TODO Auto-generated method stub
		Connection conn=DatabaseConnection.getDbConnection();
		boolean status=false;
		
		
		int result;
		PreparedStatement pstmt=null;
				
		String city_id=cityBeanobj.getCity_id();
		String city_name=cityBeanobj.getCity_name();
		String state_id=cityBeanobj.getState_id();
		
		
		System.out.println("City id"+city_id);
		System.out.println("City name"+city_name);
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("update city set city_name=? WHERE city_id = ?");
				
				pstmt.setString(1, city_name);
				pstmt.setString(2, city_id);
				
				
				
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

	public List<cityBean> viewParticular(String city_id) {
		
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		cityBean cityBeanobj=null;
		List<cityBean> citylist=new ArrayList<cityBean>(); 
		

		PreparedStatement pstmt=null;
		
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("select * from city where city_id=?");
				pstmt.setString(1, city_id);
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					cityBeanobj=new cityBean();
					
					cityBeanobj.setCity_id(rs.getString("city_id"));
					cityBeanobj.setCity_name(rs.getString("city_name"));
					cityBeanobj.setState_id(rs.getString("state_id"));
				
					
					citylist.add(cityBeanobj);
				}
				
				
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		return citylist;
		
	}
	

	
	
}
