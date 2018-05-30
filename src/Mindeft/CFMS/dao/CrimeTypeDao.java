package Mindeft.CFMS.dao;

import Mindeft.CFMS.bean.CrimeTypeBean;
import Mindeft.CFMS.bean.complain_status_Bean;
import Mindeft.CFMS.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CrimeTypeDao {

	private Connection conn=null;
	private ResultSet rs=null;
	private PreparedStatement pstmt=null;
	

	
	public boolean insert(Mindeft.CFMS.bean.CrimeTypeBean CrimeTypeBeanObj){
		boolean result = false;
		conn=DatabaseConnection.getDbConnection();
		
		if(conn!=null){
			String insertSQL = "INSERT INTO crimetypes(CrimeType,CrimeDetails) values (?,?)";
			try {
				
				pstmt = conn.prepareStatement(insertSQL);

				pstmt.setString(1,CrimeTypeBeanObj.getCrimeType());
				pstmt.setString(2, CrimeTypeBeanObj.getCrimeDetails());
				
				int rowsAffacted  = pstmt.executeUpdate();
				
	
				if(rowsAffacted > 0){
					System.out.println(rowsAffacted+" Row(s) Inserted......");
					result=true;
				}else{
					System.out.println(rowsAffacted+"Row(s) Inserted......");					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				if(pstmt!=null){
					try {
						pstmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}

					if(conn!=null){
						try {
							conn.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
		
				}
				
				
			}
			
		}
		
	}
		return result;
		
	}//end of insert
	
//---------------------------------------------------------------------------------------------------------------------------

	public List<CrimeTypeBean> select() {
		
		CrimeTypeBean CrimeTypeBeanObj = null;
			List<CrimeTypeBean> CrimeTypeList = new ArrayList<CrimeTypeBean>();
			
			conn=DatabaseConnection.getDbConnection();
			
			if(conn!=null){
				try {
					String selectSQL = "SELECT * FROM crimetypes";
					pstmt = conn.prepareStatement(selectSQL);
					
					rs = pstmt.executeQuery();
					
					while(rs.next()){
						CrimeTypeBeanObj = new CrimeTypeBean();
						CrimeTypeBeanObj.setCrimeTypeId(rs.getInt("CrimeType_Id"));
						CrimeTypeBeanObj.setCrimeType(rs.getString("CrimeType"));
						CrimeTypeBeanObj.setCrimeDetails(rs.getString("CrimeDetails"));
						
							
						CrimeTypeList.add(CrimeTypeBeanObj);
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
			System.out.println("List Size : "+CrimeTypeList.size());
			return CrimeTypeList;
		}	//end of select

//----------------------------------------------------------------------------------------------------------------

	
	public boolean delete(String crimeType_Id){
		boolean result = false;
		conn=DatabaseConnection.getDbConnection();
		
		if(conn!=null){
			String deleteSQL = "DELETE FROM crimetypes WHERE CrimeType_Id = ?";
			try {
				pstmt = conn.prepareStatement(deleteSQL);

				pstmt.setString(1,crimeType_Id);
				
				int rowsAffacted  = pstmt.executeUpdate();
				

				if(rowsAffacted > 0){
					System.out.println(rowsAffacted+" Row(s) Deleted......");
					result=true;
				}else{
					System.out.println(rowsAffacted+"Row(s) Deleted......");					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				if(pstmt!=null){
					try {
						pstmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}

					if(conn!=null){
						try {
							conn.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
		
				}
				
				
			}
			
		}
		
	}
		return result;
		
	}

	public static CrimeTypeBean getDatabyPK(String crimeType_id) {
		
		CrimeTypeBean CrimeTypeBeanObj=null;
		
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		PreparedStatement pstmt=null;
		if(conn!=null){
			
			try {
				pstmt=conn.prepareStatement("SELECT * from crimetypes WHERE CrimeType_Id = ?");

				pstmt.setString(1,crimeType_id);
				rs=pstmt.executeQuery();
				
				
				while(rs.next())
				{
					CrimeTypeBeanObj=new CrimeTypeBean();
					
					/*countryBeanObj.setCountry_id(rs.getInt("country_id"));
					countryBeanObj.setCountry_name(rs.getString("country_name"));
					
					System.out.println("Inside pk id:" + countryBeanObj.getCountry_id());*/
			
					CrimeTypeBeanObj.setCrimeTypeId(rs.getInt("CrimeType_Id"));
					CrimeTypeBeanObj.setCrimeType(rs.getString("CrimeType"));
					CrimeTypeBeanObj.setCrimeDetails(rs.getString("CrimeDetails"));
					
					System.out.println(CrimeTypeBeanObj.getCrimeTypeId());
					System.out.println(CrimeTypeBeanObj.getCrimeType());
					System.out.println(CrimeTypeBeanObj.getCrimeDetails());
				}

				
				
			} catch (Exception e) {
				e.printStackTrace();
			
				
				
			}
			
		}
		
		
		return CrimeTypeBeanObj;
		
	}

	public boolean update(CrimeTypeBean crimeTypeBeanObj) {
		// TODO Auto-generated method stub
		Connection conn=DatabaseConnection.getDbConnection();
		boolean status=false;
		
		
		int result;
		PreparedStatement pstmt=null;
		
		String CrimeType_id=crimeTypeBeanObj.getCrimeTypeId()+"";
		CrimeType_id=CrimeType_id.trim();
		
		String CrimeType=crimeTypeBeanObj.getCrimeType();
		String CrimeType_details=crimeTypeBeanObj.getCrimeDetails();
	
		System.out.println("CrimeType id"+CrimeType_id);
		System.out.println("Crimetype"+CrimeType);
		System.out.println("Details::"+CrimeType_details);
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("update crimetypes set CrimeType=?,CrimeDetails=? WHERE CrimeType_Id = ?");
				
				pstmt.setString(1,CrimeType);
				pstmt.setString(2, CrimeType_details);
				pstmt.setString(3, CrimeType_id);
				
				
				
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

	public List<CrimeTypeBean> view_particular(String crimeType_id) {
		// TODO Auto-generated method stub
		
		CrimeTypeBean CrimeTypeBeanObj = null;
		List<CrimeTypeBean> CrimeTypeList = new ArrayList<CrimeTypeBean>();
		
		conn=DatabaseConnection.getDbConnection();
		
		if(conn!=null){
			try {
				pstmt=conn.prepareStatement("SELECT * from crimetypes WHERE CrimeType_Id = ?");

				pstmt.setString(1,crimeType_id);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()){
					CrimeTypeBeanObj = new CrimeTypeBean();
					CrimeTypeBeanObj.setCrimeTypeId(rs.getInt("CrimeType_Id"));
					CrimeTypeBeanObj.setCrimeType(rs.getString("CrimeType"));
					CrimeTypeBeanObj.setCrimeDetails(rs.getString("CrimeDetails"));
					
						
					CrimeTypeList.add(CrimeTypeBeanObj);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		System.out.println("List Size : "+CrimeTypeList.size());
		return CrimeTypeList;
		
	}

}
