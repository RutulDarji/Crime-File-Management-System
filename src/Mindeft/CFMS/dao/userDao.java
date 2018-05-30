package Mindeft.CFMS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Mindeft.CFMS.bean.userBean;
import Mindeft.CFMS.bean.user_typeBean;
import Mindeft.CFMS.util.DatabaseConnection;

public class userDao {

	public static boolean insert(userBean userBeanObj) {
		// TODO Auto-generated method stub
		Connection conn=DatabaseConnection.getDbConnection();
		boolean status=false;
		String user_id,user_firstname,user_middlename,user_lastname,email,password,gender,mobile,address;
		String city_id,date_of_birth,security_question_id,security_question_answer,user_image,isActive,user_type_id;
		
		int result;
		PreparedStatement pstmt=null;
			
		user_firstname=userBeanObj.getUser_firstname();
		user_middlename=userBeanObj.getUser_middlename();
		user_lastname=userBeanObj.getUser_lastname();
		email=userBeanObj.getEmail();
		password=userBeanObj.getPassword();
		gender=userBeanObj.getGender();
		date_of_birth=userBeanObj.getDate_of_birth();
		isActive=userBeanObj.getIsActive();
		security_question_id=userBeanObj.getSecurity_question_id();
		security_question_answer=userBeanObj.getSecurity_question_answer();
		user_type_id=userBeanObj.getUser_type_id();
		mobile=userBeanObj.getMobile();
		address=userBeanObj.getAddress();
		user_image=userBeanObj.getUser_image();
		city_id=userBeanObj.getCity_id();
		
		

		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("insert into user (user_firstname,user_middlename,user_lastname,email,password,gender,"
						+ "date_of_birth,isActive,security_question_id,security_question_answer,user_type_id,mobile,address,"
						+ "user_image,city_id) "
						+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				
				pstmt.setString(1, user_firstname);
				pstmt.setString(2, user_middlename);
				pstmt.setString(3, user_lastname);
				pstmt.setString(4, email);
				pstmt.setString(5, password);
				pstmt.setString(6, gender);
				pstmt.setString(7, date_of_birth);
				pstmt.setString(8, isActive);
				pstmt.setString(9, security_question_id);
				pstmt.setString(10, security_question_answer);
				pstmt.setString(11, user_type_id);
				pstmt.setString(12, mobile);
				pstmt.setString(13, address);
				pstmt.setString(14, user_image);
				pstmt.setString(15, city_id);
				
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

	public List<userBean> select() {
		// TODO Auto-generated method stub
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		userBean userBeanObj=null;
		List<userBean> userBeanlist=new ArrayList<userBean>(); 
		

		PreparedStatement pstmt=null;
		
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("select * from user");
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					userBeanObj=new userBean();
					
					
					userBeanObj.setUser_firstname(rs.getString("user_firstname"));
					userBeanObj.setUser_middlename(rs.getString("user_middlename"));
					userBeanObj.setUser_lastname(rs.getString("user_lastname"));
					userBeanObj.setEmail(rs.getString("email"));
					userBeanObj.setPassword(rs.getString("password"));
					userBeanObj.setGender(rs.getString("gender"));
					userBeanObj.setDate_of_birth(rs.getString("date_of_birth"));
					userBeanObj.setIsActive(rs.getString("isActive"));
					userBeanObj.setSecurity_question_id(rs.getString("security_question_id"));
					userBeanObj.setSecurity_question_answer(rs.getString("security_question_answer"));
					userBeanObj.setUser_type_id(rs.getString("user_type_id"));
					userBeanObj.setMobile(rs.getString("mobile"));
					userBeanObj.setAddress(rs.getString("address"));
					userBeanObj.setUser_image(rs.getString("user_image"));
					userBeanObj.setCity_id(rs.getString("city_id"));
					userBeanObj.setUser_id(rs.getString("user_id"));
					
					userBeanlist.add(userBeanObj);
				}
				
				
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		return userBeanlist;
	}

	public boolean delete(String user_id) {
		// TODO Auto-generated method stub
		Connection conn=DatabaseConnection.getDbConnection();
		boolean result=false;
		PreparedStatement pstmt=null;
		
		if(conn!=null){
			//String insertSQL = "DELETE FROM STUDENT WHERE STUDENTID = ?";
			try {
				pstmt = conn.prepareStatement("DELETE FROM user WHERE user_id = ?");

				pstmt.setString(1,user_id);
				
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

	public static userBean getDatabyPK(String user_id) {
		// TODO Auto-generated method stub
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		userBean userBeanObj=null;
		
		PreparedStatement pstmt=null;
		if(conn!=null){
			
			try {
				pstmt=conn.prepareStatement("SELECT * from user WHERE user_id = ?");
				pstmt.setString(1,user_id);
				rs=pstmt.executeQuery();
				
				
				while(rs.next())
				{
					userBeanObj=new userBean();
					
					
					userBeanObj.setUser_firstname(rs.getString("user_firstname"));
					userBeanObj.setUser_middlename(rs.getString("user_middlename"));
					userBeanObj.setUser_lastname(rs.getString("user_lastname"));
					userBeanObj.setEmail(rs.getString("email"));
					userBeanObj.setPassword(rs.getString("password"));
					userBeanObj.setGender(rs.getString("gender"));
					userBeanObj.setDate_of_birth(rs.getString("date_of_birth"));
					userBeanObj.setIsActive(rs.getString("isActive"));
					userBeanObj.setSecurity_question_id(rs.getString("security_question_id"));
					userBeanObj.setSecurity_question_answer(rs.getString("security_question_answer"));
					userBeanObj.setUser_type_id(rs.getString("user_type_id"));
					userBeanObj.setMobile(rs.getString("mobile"));
					userBeanObj.setAddress(rs.getString("address"));
					userBeanObj.setUser_image(rs.getString("user_image"));
					userBeanObj.setCity_id(rs.getString("city_id"));
					userBeanObj.setUser_id(rs.getString("user_id"));
				}

				
				
			} catch (Exception e) {
				e.printStackTrace();
			
				
				
			}
			
		}
		
		
		return userBeanObj;
	}

	public static boolean update(userBean userBeanObj) {
		// TODO Auto-generated method stub
		Connection conn=DatabaseConnection.getDbConnection();
		boolean status=false;
		String user_id,user_firstname,user_middlename,user_lastname,email,password,gender,mobile,address;
		String city_id,date_of_birth,security_question_id,security_question_answer,user_image,isActive,user_type_id;
		
		int result;
		PreparedStatement pstmt=null;
			
		user_firstname=userBeanObj.getUser_firstname();
		user_middlename=userBeanObj.getUser_middlename();
		user_lastname=userBeanObj.getUser_lastname();
		email=userBeanObj.getEmail();
		password=userBeanObj.getPassword();
		gender=userBeanObj.getGender();
		date_of_birth=userBeanObj.getDate_of_birth();
		isActive=userBeanObj.getIsActive();
		security_question_id=userBeanObj.getSecurity_question_id();
		security_question_answer=userBeanObj.getSecurity_question_answer();
		user_type_id=userBeanObj.getUser_type_id();
		mobile=userBeanObj.getMobile();
		address=userBeanObj.getAddress();
		user_image=userBeanObj.getUser_image();
		city_id=userBeanObj.getCity_id();
		user_id=userBeanObj.getUser_id();
		

		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("update user set user_firstname=?,user_middlename=?,user_lastname=?,email=?,password=?,gender=?,"
						+ "date_of_birth=?,isActive=?,security_question_id=?,security_question_answer=?,user_type_id=?,mobile=?,address=?,"
						+ "user_image=?,city_id=? "
						+ "where user_id=?");
				
				pstmt.setString(1, user_firstname);
				pstmt.setString(2, user_middlename);
				pstmt.setString(3, user_lastname);
				pstmt.setString(4, email);
				pstmt.setString(5, password);
				pstmt.setString(6, gender);
				pstmt.setString(7, date_of_birth);
				pstmt.setString(8, isActive);
				pstmt.setString(9, security_question_id);
				pstmt.setString(10, security_question_answer);
				pstmt.setString(11, user_type_id);
				pstmt.setString(12, mobile);
				pstmt.setString(13, address);
				pstmt.setString(14, user_image);
				pstmt.setString(15, city_id);
				pstmt.setString(16, user_id);
				
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

	public List<userBean> view_particular(String user_id) {
		// TODO Auto-generated method stub
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		userBean userBeanObj=null;
		List<userBean> userBeanlist=new ArrayList<userBean>(); 
		

		PreparedStatement pstmt=null;
		
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("SELECT * from user WHERE user_id = ?");
				pstmt.setString(1,user_id);
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					userBeanObj=new userBean();
					
					
					userBeanObj.setUser_firstname(rs.getString("user_firstname"));
					userBeanObj.setUser_middlename(rs.getString("user_middlename"));
					userBeanObj.setUser_lastname(rs.getString("user_lastname"));
					userBeanObj.setEmail(rs.getString("email"));
					userBeanObj.setPassword(rs.getString("password"));
					userBeanObj.setGender(rs.getString("gender"));
					userBeanObj.setDate_of_birth(rs.getString("date_of_birth"));
					userBeanObj.setIsActive(rs.getString("isActive"));
					userBeanObj.setSecurity_question_id(rs.getString("security_question_id"));
					userBeanObj.setSecurity_question_answer(rs.getString("security_question_answer"));
					userBeanObj.setUser_type_id(rs.getString("user_type_id"));
					userBeanObj.setMobile(rs.getString("mobile"));
					userBeanObj.setAddress(rs.getString("address"));
					userBeanObj.setUser_image(rs.getString("user_image"));
					userBeanObj.setCity_id(rs.getString("city_id"));
					userBeanObj.setUser_id(rs.getString("user_id"));
					
					userBeanlist.add(userBeanObj);
				}
				
				
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		return userBeanlist;
	}

	public static boolean update_profile(userBean userBeanObj) {
		// TODO Auto-generated method stub
		Connection conn=DatabaseConnection.getDbConnection();
		boolean status=false;
		String user_id,user_firstname,user_middlename,user_lastname,email,password,gender,mobile,address;
		String city_id,date_of_birth,security_question_id,security_question_answer,user_image,isActive,user_type_id;
		
		int result;
		PreparedStatement pstmt=null;
			
		user_firstname=userBeanObj.getUser_firstname();
		user_middlename=userBeanObj.getUser_middlename();
		user_lastname=userBeanObj.getUser_lastname();
		email=userBeanObj.getEmail();
		//password=userBeanObj.getPassword();
		gender=userBeanObj.getGender();
		date_of_birth=userBeanObj.getDate_of_birth();
//		isActive=userBeanObj.getIsActive();
//		security_question_id=userBeanObj.getSecurity_question_id();
//		security_question_answer=userBeanObj.getSecurity_question_answer();
//		user_type_id=userBeanObj.getUser_type_id();
		mobile=userBeanObj.getMobile();
		address=userBeanObj.getAddress();
		user_image=userBeanObj.getUser_image();
//		city_id=userBeanObj.getCity_id();
		user_id=userBeanObj.getUser_id();
		

		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("update user set user_firstname=?,user_middlename=?,user_lastname=?,email=?,gender=?,"
						+ "date_of_birth=?,mobile=?,address=?,"
						+ "user_image=? "
						+ "where user_id=?");
				
				pstmt.setString(1, user_firstname);
				pstmt.setString(2, user_middlename);
				pstmt.setString(3, user_lastname);
				pstmt.setString(4, email);
				pstmt.setString(5, gender);
				pstmt.setString(6, date_of_birth);
				pstmt.setString(7, mobile);
				pstmt.setString(8, address);
				pstmt.setString(9, user_image);
				//pstmt.setString(15, city_id);
				pstmt.setString(10, user_id);
				
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
