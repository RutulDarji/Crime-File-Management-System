package Mindeft.CFMS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Mindeft.CFMS.bean.missing_personBean;
import Mindeft.CFMS.bean.user_typeBean;
import Mindeft.CFMS.util.DatabaseConnection;

public class missing_personDao {

	public static boolean insert(missing_personBean missing_personBeanObj) {
		// TODO Auto-generated method stub
		
		Connection conn=DatabaseConnection.getDbConnection();
		boolean status=false;
		String user_type=new String();
		int result;
		PreparedStatement pstmt=null;
		String missing_person_firstname,missing_person_middlename,missing_person_lastname,missing_person_gender,missing_person_age;
		String referenceperson_name,referenceperson_relation,referenceperson_number,area_id;
		String missing_person_details,missing_person_date,missing_person_image;	
		
		missing_person_firstname=missing_personBeanObj.getMissing_person_firstname();
		missing_person_middlename=missing_personBeanObj.getMissing_person_middlename();
		missing_person_lastname=missing_personBeanObj.getMissing_person_lastname();
		missing_person_gender=missing_personBeanObj.getMissing_person_gender();
		missing_person_age=missing_personBeanObj.getMissing_person_age();
		referenceperson_name=missing_personBeanObj.getReferenceperson_name();
		referenceperson_number=missing_personBeanObj.getReferenceperson_number();
		referenceperson_relation=missing_personBeanObj.getReferenceperson_relation();
		area_id=missing_personBeanObj.getArea_id();
		missing_person_date=missing_personBeanObj.getMissing_person_date();
		missing_person_details=missing_personBeanObj.getMissing_person_details();
		missing_person_image=missing_personBeanObj.getMissing_person_image();
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("insert into missing_person(missing_person_firstname,missing_person_middlename,missing_person_lastname,missing_person_gender,missing_person_age,referenceperson_name,referenceperson_relation,referenceperson_number,area_id,missing_person_details,missing_person_date,missing_person_image) values(?,?,?,?,?,?,?,?,?,?,?,?);");
				
				pstmt.setString(1, missing_person_firstname);
				pstmt.setString(2, missing_person_middlename);
				pstmt.setString(3, missing_person_lastname);
				pstmt.setString(4, missing_person_gender);
				pstmt.setString(5, missing_person_age);
				pstmt.setString(6, referenceperson_name);
				pstmt.setString(7, referenceperson_relation);
				pstmt.setString(8, referenceperson_number);
				pstmt.setString(9, area_id);
				pstmt.setString(10, missing_person_details);
				pstmt.setString(11, missing_person_date);
				pstmt.setString(12, missing_person_image);
				
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

	public List<missing_personBean> select() {
		// TODO Auto-generated method stub
		
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		missing_personBean missing_personBeanObj=null;
		List<missing_personBean> missing_personBeanlist=new ArrayList<missing_personBean>(); 
		

		PreparedStatement pstmt=null;
		
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("select * from missing_person");
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					missing_personBeanObj=new missing_personBean();
					
					missing_personBeanObj.setMissing_person_id(rs.getString("missing_person_id"));
					missing_personBeanObj.setMissing_person_firstname(rs.getString("missing_person_firstname"));
					missing_personBeanObj.setMissing_person_middlename(rs.getString("missing_person_middlename"));
					missing_personBeanObj.setMissing_person_lastname(rs.getString("missing_person_lastname"));
					missing_personBeanObj.setMissing_person_gender(rs.getString("missing_person_gender"));
					missing_personBeanObj.setMissing_person_age(rs.getString("missing_person_age"));
					missing_personBeanObj.setReferenceperson_name(rs.getString("referenceperson_name"));
					missing_personBeanObj.setReferenceperson_number(rs.getString("referenceperson_number"));
					missing_personBeanObj.setReferenceperson_relation(rs.getString("referenceperson_relation"));
					missing_personBeanObj.setArea_id(rs.getString("area_id"));
					missing_personBeanObj.setMissing_person_date(rs.getString("missing_person_date"));
					missing_personBeanObj.setMissing_person_details(rs.getString("missing_person_details"));
					missing_personBeanObj.setMissing_person_image(rs.getString("missing_person_image"));
					
					System.out.println(missing_personBeanObj.getMissing_person_id());
					
					missing_personBeanlist.add(missing_personBeanObj);
				}
				
				
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		return missing_personBeanlist;
		
	}

	public boolean delete(String missing_person_id) {
		// TODO Auto-generated method stub
		Connection conn=DatabaseConnection.getDbConnection();
		boolean result=false;
		PreparedStatement pstmt=null;
		
		if(conn!=null){
			//String insertSQL = "DELETE FROM STUDENT WHERE STUDENTID = ?";
			try {
				pstmt = conn.prepareStatement("DELETE FROM missing_person WHERE missing_person_id = ?");

				pstmt.setString(1,missing_person_id);
				
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

	public static missing_personBean getDatabyPK(String missing_person_id) {
		// TODO Auto-generated method stub
		
		missing_personBean missing_personBeanObj=null;
		
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		PreparedStatement pstmt=null;
		if(conn!=null){
			
			try {
				pstmt=conn.prepareStatement("SELECT * from missing_person WHERE missing_person_id = ?");
				pstmt.setString(1,missing_person_id);
				rs=pstmt.executeQuery();
				
				
				while(rs.next())
				{
					missing_personBeanObj=new missing_personBean();
					
					missing_personBeanObj.setMissing_person_id(rs.getString("missing_person_id"));
					missing_personBeanObj.setMissing_person_firstname(rs.getString("missing_person_firstname"));
					missing_personBeanObj.setMissing_person_middlename(rs.getString("missing_person_middlename"));
					missing_personBeanObj.setMissing_person_lastname(rs.getString("missing_person_lastname"));
					missing_personBeanObj.setMissing_person_gender(rs.getString("missing_person_gender"));
					missing_personBeanObj.setMissing_person_age(rs.getString("missing_person_age"));
					missing_personBeanObj.setReferenceperson_name(rs.getString("referenceperson_name"));
					missing_personBeanObj.setReferenceperson_number(rs.getString("referenceperson_number"));
					missing_personBeanObj.setReferenceperson_relation(rs.getString("referenceperson_relation"));
					missing_personBeanObj.setArea_id(rs.getString("area_id"));
					missing_personBeanObj.setMissing_person_date(rs.getString("missing_person_date"));
					missing_personBeanObj.setMissing_person_details(rs.getString("missing_person_details"));
					missing_personBeanObj.setMissing_person_image(rs.getString("missing_person_image"));
				}

				
				
			} catch (Exception e) {
				e.printStackTrace();
			
				
				
			}
			
		}
		
		
		return missing_personBeanObj;
	}

	public static boolean update(missing_personBean missing_personBeanObj) {
		Connection conn=DatabaseConnection.getDbConnection();
		boolean status=false;
		
		
		int result;
		PreparedStatement pstmt=null;
		String missing_person_firstname,missing_person_middlename,missing_person_lastname,missing_person_gender,missing_person_age;
		String referenceperson_name,referenceperson_relation,referenceperson_number,area_id;
		String missing_person_details,missing_person_date;	
		String missing_person_id,missing_person_image;
		
		missing_person_firstname=missing_personBeanObj.getMissing_person_firstname();
		missing_person_middlename=missing_personBeanObj.getMissing_person_middlename();
		missing_person_lastname=missing_personBeanObj.getMissing_person_lastname();
		missing_person_gender=missing_personBeanObj.getMissing_person_gender();
		missing_person_age=missing_personBeanObj.getMissing_person_age();
		referenceperson_name=missing_personBeanObj.getReferenceperson_name();
		referenceperson_number=missing_personBeanObj.getReferenceperson_number();
		referenceperson_relation=missing_personBeanObj.getReferenceperson_relation();
		area_id=missing_personBeanObj.getArea_id();
		missing_person_date=missing_personBeanObj.getMissing_person_date();
		missing_person_details=missing_personBeanObj.getMissing_person_details();
		missing_person_id=missing_personBeanObj.getMissing_person_id();
		missing_person_image=missing_personBeanObj.getMissing_person_image();
		
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("update  missing_person set missing_person_firstname=?,missing_person_middlename=?,missing_person_lastname=?,missing_person_gender=?,missing_person_age=?,referenceperson_name=?,referenceperson_relation=?,referenceperson_number=?,area_id=?,missing_person_details=?,missing_person_date=?,missing_person_image=? where missing_person_id=?");
				
				pstmt.setString(1, missing_person_firstname);
				pstmt.setString(2, missing_person_middlename);
				pstmt.setString(3, missing_person_lastname);
				pstmt.setString(4, missing_person_gender);
				pstmt.setString(5, missing_person_age);
				pstmt.setString(6, referenceperson_name);
				pstmt.setString(7, referenceperson_relation);
				pstmt.setString(8, referenceperson_number);
				pstmt.setString(9, area_id);
				pstmt.setString(10, missing_person_details);
				pstmt.setString(11, missing_person_date);
				pstmt.setString(12, missing_person_image);
		
				pstmt.setString(13, missing_person_id);
				
				
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

	public List<missing_personBean> view_particular(String missing_person_id) {
		// TODO Auto-generated method stub
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		missing_personBean missing_personBeanObj=null;
		List<missing_personBean> missing_personBeanlist=new ArrayList<missing_personBean>(); 
		

		PreparedStatement pstmt=null;
		
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("SELECT * from missing_person WHERE missing_person_id = ?");
				pstmt.setString(1,missing_person_id);
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					missing_personBeanObj=new missing_personBean();
					
					missing_personBeanObj.setMissing_person_id(rs.getString("missing_person_id"));
					missing_personBeanObj.setMissing_person_firstname(rs.getString("missing_person_firstname"));
					missing_personBeanObj.setMissing_person_middlename(rs.getString("missing_person_middlename"));
					missing_personBeanObj.setMissing_person_lastname(rs.getString("missing_person_lastname"));
					missing_personBeanObj.setMissing_person_gender(rs.getString("missing_person_gender"));
					missing_personBeanObj.setMissing_person_age(rs.getString("missing_person_age"));
					missing_personBeanObj.setReferenceperson_name(rs.getString("referenceperson_name"));
					missing_personBeanObj.setReferenceperson_number(rs.getString("referenceperson_number"));
					missing_personBeanObj.setReferenceperson_relation(rs.getString("referenceperson_relation"));
					missing_personBeanObj.setArea_id(rs.getString("area_id"));
					missing_personBeanObj.setMissing_person_date(rs.getString("missing_person_date"));
					missing_personBeanObj.setMissing_person_details(rs.getString("missing_person_details"));
					missing_personBeanObj.setMissing_person_image(rs.getString("missing_person_image"));
					
					System.out.println(missing_personBeanObj.getMissing_person_id());
					
					missing_personBeanlist.add(missing_personBeanObj);
				}
				
				
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		return missing_personBeanlist;
	}

}
