package Mindeft.CFMS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Mindeft.CFMS.bean.evidenceBean;
import Mindeft.CFMS.bean.user_typeBean;
import Mindeft.CFMS.util.DatabaseConnection;

public class evidenceDao {

	public static boolean insert(evidenceBean evidenceBeanObj) {
		// TODO Auto-generated method stub
		Connection conn=DatabaseConnection.getDbConnection();
		boolean status=false;
		String evidence_id,evidence_date,evidence_details,evidence_image,crime_id;
		int result;
		PreparedStatement pstmt=null;
			
		
		evidence_date=evidenceBeanObj.getEvidence_date();
		evidence_details=evidenceBeanObj.getEvidence_details();
		evidence_image=evidenceBeanObj.getEvidence_image();
		crime_id=evidenceBeanObj.getCrime_id();
		
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("insert into evidence(evidence_date,evidence_details,evidence_image,crime_id) values(?,?,?,?)");
				
				pstmt.setString(1, evidence_date);
				pstmt.setString(2, evidence_details);
				pstmt.setString(3, evidence_image);
				pstmt.setString(4, crime_id);
				
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

	public List<evidenceBean> select() {
		// TODO Auto-generated method stub
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		evidenceBean evidenceBeanObj=null;
		List<evidenceBean> evidenceBeanlist=new ArrayList<evidenceBean>(); 
		

		PreparedStatement pstmt=null;
		
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("select * from evidence");
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					evidenceBeanObj=new evidenceBean();
					
					evidenceBeanObj.setEvidence_id(rs.getString("evidence_id"));
					evidenceBeanObj.setEvidence_details(rs.getString("evidence_details"));
					evidenceBeanObj.setEvidence_date(rs.getString("evidence_date"));
					evidenceBeanObj.setEvidence_image(rs.getString("evidence_image"));
					evidenceBeanObj.setCrime_id(rs.getString("crime_id"));
					
					evidenceBeanlist.add(evidenceBeanObj);
				}
				
				
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		return evidenceBeanlist;
	}

	public boolean delete(String evidence_id) {
		// TODO Auto-generated method stub
		Connection conn=DatabaseConnection.getDbConnection();
		boolean result=false;
		PreparedStatement pstmt=null;
		
		if(conn!=null){
			//String insertSQL = "DELETE FROM STUDENT WHERE STUDENTID = ?";
			try {
				pstmt = conn.prepareStatement("DELETE FROM evidence WHERE evidence_id = ?");

				pstmt.setString(1,evidence_id);
				
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

	public static evidenceBean getDatabyPK(String evidence_id) {
		// TODO Auto-generated method stub
		
		evidenceBean evidenceBeanObj=null;
		
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		PreparedStatement pstmt=null;
		if(conn!=null){
			
			try {
				pstmt=conn.prepareStatement("SELECT * from evidence WHERE evidence_id = ?");
				pstmt.setString(1,evidence_id);
				rs=pstmt.executeQuery();
				
				
				while(rs.next())
				{
					evidenceBeanObj=new evidenceBean();
					
					evidenceBeanObj.setEvidence_id(rs.getString("evidence_id"));
					evidenceBeanObj.setEvidence_details(rs.getString("evidence_details"));
					evidenceBeanObj.setEvidence_date(rs.getString("evidence_date"));
					evidenceBeanObj.setEvidence_image(rs.getString("evidence_image"));
					evidenceBeanObj.setCrime_id(rs.getString("crime_id"));
					
				}

				
				
			} catch (Exception e) {
				e.printStackTrace();
			
				
				
			}
			
		}
		
		
		return evidenceBeanObj;
	}

	public static boolean update(evidenceBean evidenceBeanObj) {
		// TODO Auto-generated method stub
		
		Connection conn=DatabaseConnection.getDbConnection();
		boolean status=false;
		String evidence_id,evidence_date,evidence_details,evidence_image,crime_id;
		int result;
		PreparedStatement pstmt=null;
			
		
		evidence_date=evidenceBeanObj.getEvidence_date();
		evidence_details=evidenceBeanObj.getEvidence_details();
		evidence_image=evidenceBeanObj.getEvidence_image();
		crime_id=evidenceBeanObj.getCrime_id();
		evidence_id=evidenceBeanObj.getEvidence_id();
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("update evidence set evidence_date=?,evidence_details=?,evidence_image=?,crime_id=? where evidence_id=?");
				
				pstmt.setString(1, evidence_date);
				pstmt.setString(2, evidence_details);
				pstmt.setString(3, evidence_image);
				pstmt.setString(4, crime_id);
				pstmt.setString(5, evidence_id);
				
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

	public List<evidenceBean> view_particular(String evidence_id) {
		// TODO Auto-generated method stub
		
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		evidenceBean evidenceBeanObj=null;
		List<evidenceBean> evidenceBeanlist=new ArrayList<evidenceBean>(); 
		

		PreparedStatement pstmt=null;
		
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("SELECT * from evidence WHERE evidence_id = ?");
				pstmt.setString(1,evidence_id);
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					evidenceBeanObj=new evidenceBean();
					
					evidenceBeanObj.setEvidence_id(rs.getString("evidence_id"));
					evidenceBeanObj.setEvidence_details(rs.getString("evidence_details"));
					evidenceBeanObj.setEvidence_date(rs.getString("evidence_date"));
					evidenceBeanObj.setEvidence_image(rs.getString("evidence_image"));
					evidenceBeanObj.setCrime_id(rs.getString("crime_id"));
					
					evidenceBeanlist.add(evidenceBeanObj);
				}
				
				
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		return evidenceBeanlist;
		
	}

}
