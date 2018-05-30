package Mindeft.CFMS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Mindeft.CFMS.util.DatabaseConnection;

public class change_password_Dao {

	public static boolean password_change(String user_id, String new_password) {
		// TODO Auto-generated method stub
		
		Connection conn=DatabaseConnection.getDbConnection();
		boolean status=false;
		
		int result;
		PreparedStatement pstmt=null;
			

		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("update user set password=? where user_id=?");
				
				pstmt.setString(1, new_password);
				pstmt.setString(2, user_id);
				
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
