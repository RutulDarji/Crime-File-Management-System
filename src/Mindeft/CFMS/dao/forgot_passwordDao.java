package Mindeft.CFMS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Mindeft.CFMS.bean.AreaBean;
import Mindeft.CFMS.bean.userBean;
import Mindeft.CFMS.util.DatabaseConnection;

public class forgot_passwordDao {

public static userBean Email_Check(String email) {
		
		userBean userBeanObj=null;
		
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		PreparedStatement pstmt=null;
		if(conn!=null){
			
			try {
				pstmt=conn.prepareStatement("SELECT * from user WHERE email = ?");

				pstmt.setString(1,email);
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
}
