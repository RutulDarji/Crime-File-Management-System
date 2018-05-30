package Mindeft.CFMS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Mindeft.CFMS.bean.countryBean;
import Mindeft.CFMS.bean.stateBean;
import Mindeft.CFMS.util.DatabaseConnection;

public class stateDao {
	
	public  static boolean insert(stateBean stateBeanobj) {
		// TODO Auto-generated method stub
		Connection conn=DatabaseConnection.getDbConnection();
		boolean status=false;
		String state_name=new String();
		int result;
		PreparedStatement pstmt=null;
			
		
		state_name=stateBeanobj.getState_name();
		String country_id=stateBeanobj.getCountry_id();
		
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("insert into state(state_name,country_id) values(?,?)");
				
				pstmt.setString(1, state_name);
				pstmt.setString(2, country_id);
				
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
	
	
	public  static List<stateBean> select() {
		// TODO Auto-generated method stub
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		stateBean stateBeanobj=null;
		List<stateBean> statelist=new ArrayList<stateBean>(); 
		

		PreparedStatement pstmt=null;
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("select * from state");
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					stateBeanobj=new stateBean();
					
					stateBeanobj.setState_id(rs.getString("state_id"));
					stateBeanobj.setState_name(rs.getString("state_name"));
					stateBeanobj.setCountry_id(rs.getString("country_id"));
					
					statelist.add(stateBeanobj);
				}
				
				
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		return statelist;
	}
	
	
	public boolean delete(String state_id){
		Connection conn=DatabaseConnection.getDbConnection();
		boolean result=false;
		PreparedStatement pstmt=null;
		
		if(conn!=null){
			//String insertSQL = "DELETE FROM STUDENT WHERE STUDENTID = ?";
			try {
				pstmt = conn.prepareStatement("DELETE FROM state WHERE state_id = ?");

				pstmt.setString(1,state_id);
				
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


	public static stateBean getDatabyPK(String state_id) {
		// TODO Auto-generated method stub
		stateBean stateBeanObj=null;
		
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		System.out.println("state id in get data:"+ state_id);
		
		PreparedStatement pstmt=null;
		if(conn!=null){
			
			try {
				pstmt=conn.prepareStatement("SELECT * from state WHERE state_id = ?");

				pstmt.setString(1,state_id);
				rs=pstmt.executeQuery();
				
				
				while(rs.next())
				{
					stateBeanObj=new stateBean();
				
					stateBeanObj.setState_id(rs.getString("state_id"));
					stateBeanObj.setState_name(rs.getString("state_name"));
					stateBeanObj.setCountry_id(rs.getString("country_id"));	
				}

				
			} catch (Exception e) {
				e.printStackTrace();
							
			}
			
		}
		
		
		return stateBeanObj;
	}


	public boolean update(stateBean stateBeanobj) {
		// TODO Auto-generated method stub
		Connection conn=DatabaseConnection.getDbConnection();
		boolean status=false;
		
		
		int result;
		PreparedStatement pstmt=null;
		
		
		//int state_id=countryBeanobj.getCountry_id();
		//String country_name=countryBeanobj.getCountry_name();
		
		String state_id=stateBeanobj.getState_id();
		String state_name=stateBeanobj.getState_name();
		String country_id=stateBeanobj.getCountry_id();
	
		System.out.println("id"+state_id);
		System.out.println("name"+state_name);
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("update state set state_name=? WHERE state_id = ?");
				
				pstmt.setString(1, state_name);
				pstmt.setString(2, state_id);
				
				
				
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


	public List<stateBean> view_particular(String state_id) {
		// TODO Auto-generated method stub
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		stateBean stateBeanobj=null;
		List<stateBean> statelist=new ArrayList<stateBean>(); 
		

		PreparedStatement pstmt=null;
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("SELECT * from state WHERE state_id = ?");
				pstmt.setString(1,state_id);
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					stateBeanobj=new stateBean();
					
					stateBeanobj.setState_id(rs.getString("state_id"));
					stateBeanobj.setState_name(rs.getString("state_name"));
					stateBeanobj.setCountry_id(rs.getString("country_id"));
					
					statelist.add(stateBeanobj);
				}
				
				
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		return statelist;
	}
}
