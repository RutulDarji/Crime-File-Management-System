package Mindeft.CFMS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Mindeft.CFMS.bean.criminalBean;
import Mindeft.CFMS.util.DatabaseConnection;

public class most_wanted_criminal_Dao {

	public List<criminalBean> select() {
		// TODO Auto-generated method stub
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		criminalBean criminalBeanObj=null;
		List<criminalBean> criminalBeanlist=new ArrayList<criminalBean>(); 
		

		PreparedStatement pstmt=null;
		
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("select * from criminal where mostwanted=1");
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					criminalBeanObj=new criminalBean();
					
					criminalBeanObj.setCriminal_id(rs.getString("criminal_id"));
					criminalBeanObj.setCriminal_firstname(rs.getString("criminal_firstname"));
					criminalBeanObj.setCriminal_middlename(rs.getString("criminal_middlename"));
					criminalBeanObj.setCriminal_lastname(rs.getString("criminal_lastname"));
					criminalBeanObj.setCriminal_gender(rs.getString("criminal_gender"));
					criminalBeanObj.setCriminal_age(rs.getString("criminal_age"));
					criminalBeanObj.setCriminal_details(rs.getString("criminal_details"));
					criminalBeanObj.setCriminal_image(rs.getString("criminal_image"));
					criminalBeanObj.setMostwanted(rs.getString("mostwanted"));
					criminalBeanObj.setPolice_station_id(rs.getString("police_station_id"));
					
					criminalBeanlist.add(criminalBeanObj);
				}
				
				
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		return criminalBeanlist;
	}
}
