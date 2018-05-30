package Mindeft.CFMS.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

	private static String connectionUrl="jdbc:mysql://localhost:3306/CrimeFileManagementSystem";
	private static String driverClassName="com.mysql.jdbc.Driver";
	private static String userName="root";
	private static String password="root";
	
	public static Connection getDbConnection()
	{
		Connection conn=null;	
		
		try {
			Class.forName(driverClassName);
			conn=DriverManager.getConnection(connectionUrl, userName, password);
			
			if(conn!=null)
				System.out.println("Connection With Database");
			else 
				System.out.println("Connection Failed");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return conn;
		
	}
	
	public static void main(String[] args) {
		getDbConnection();
		
	}
	
	
	
	
}
