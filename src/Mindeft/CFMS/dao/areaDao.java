package Mindeft.CFMS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Mindeft.CFMS.bean.AreaBean;
import Mindeft.CFMS.bean.user_typeBean;
import Mindeft.CFMS.util.DatabaseConnection;

public class areaDao {

	public static boolean insert(AreaBean areaBeanObj) {
		
		Connection conn=DatabaseConnection.getDbConnection();
		boolean status=false;
		
		int result;
		PreparedStatement pstmt=null;
		
		String area_name,area_id,zipcode,city_id;
	
		area_name=areaBeanObj.getArea_name();
		zipcode=areaBeanObj.getZipcode();
		city_id=areaBeanObj.getCity_id();
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("insert into area(area_name,zipcode,city_id) values(?,?,?)");
				
				pstmt.setString(1, area_name);
				pstmt.setString(2, zipcode);
				pstmt.setString(3, city_id);
				
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

	public List<AreaBean> select() {
	
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		
		AreaBean AreaBeanObj=null;
		List<AreaBean> AreaBeanlist=new ArrayList<AreaBean>(); 
		

		PreparedStatement pstmt=null;
		
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("select * from area");
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					AreaBeanObj=new AreaBean();
					
					AreaBeanObj.setArea_id(rs.getString("area_id"));
					AreaBeanObj.setArea_name(rs.getString("area_name"));
					AreaBeanObj.setZipcode(rs.getString("zipcode"));
					AreaBeanObj.setCity_id(rs.getString("city_id"));
					
					AreaBeanlist.add(AreaBeanObj);
				}
				
				
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		return AreaBeanlist;
		
	}

	public boolean delete(String area_id) {
		
		Connection conn=DatabaseConnection.getDbConnection();
		boolean result=false;
		PreparedStatement pstmt=null;
		System.out.println("Area id:" + area_id);
		
		if(conn!=null){
			//String insertSQL = "DELETE FROM STUDENT WHERE STUDENTID = ?";
			try {
				pstmt = conn.prepareStatement("DELETE FROM area WHERE area_id = ?");

				pstmt.setString(1,area_id);
				
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

	public static AreaBean getDatabyPK(String area_id) {
		
		AreaBean AreaBeanObj=null;
		
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		PreparedStatement pstmt=null;
		if(conn!=null){
			
			try {
				pstmt=conn.prepareStatement("SELECT * from area WHERE area_id = ?");

				pstmt.setString(1,area_id);
				rs=pstmt.executeQuery();
				
				
				while(rs.next())
				{
					AreaBeanObj=new AreaBean();
								
					AreaBeanObj.setArea_id(rs.getString("area_id"));
					AreaBeanObj.setArea_name(rs.getString("area_name"));
					AreaBeanObj.setZipcode(rs.getString("zipcode"));
					AreaBeanObj.setCity_id(rs.getString("city_id"));
					
				}
	
				
			} catch (Exception e) {
				e.printStackTrace();
				
			}
			
		}
			
		return AreaBeanObj;
	}

	public boolean update(AreaBean areaBeanObj) {
		
		Connection conn=DatabaseConnection.getDbConnection();
		boolean status=false;
		
		
		int result;
		PreparedStatement pstmt=null;
		
		String area_id=areaBeanObj.getArea_id();
		String area_name=areaBeanObj.getArea_name();
		String zipcode=areaBeanObj.getZipcode();
		String city_id=areaBeanObj.getCity_id();	
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("update area set area_name= ? , zipcode= ? , city_id= ? WHERE area_id= ? ");
				
				pstmt.setString(1,area_name);
				pstmt.setString(2, zipcode);
				pstmt.setString(3, city_id);
				pstmt.setString(4, area_id);
				
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

	public static List<AreaBean> viewParticular(String area_id) {
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		
		AreaBean AreaBeanObj=null;
		List<AreaBean> AreaBeanlist=new ArrayList<AreaBean>(); 
		

		PreparedStatement pstmt=null;
		
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("select * from area where area_id=?");
				pstmt.setString(1,area_id);		
				rs=pstmt.executeQuery();
				
				
				while(rs.next())
				{
					AreaBeanObj=new AreaBean();
					
					AreaBeanObj.setArea_id(rs.getString("area_id"));
					AreaBeanObj.setArea_name(rs.getString("area_name"));
					AreaBeanObj.setZipcode(rs.getString("zipcode"));
					AreaBeanObj.setCity_id(rs.getString("city_id"));
					
					AreaBeanlist.add(AreaBeanObj);
				}
				
				
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		return AreaBeanlist;
		
	}

}
