package Mindeft.CFMS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Mindeft.CFMS.bean.AreaBean;
import Mindeft.CFMS.bean.police_station_map;
import Mindeft.CFMS.util.DatabaseConnection;

public class police_station_search_Dao {

	public static police_station_map find(String police_station_id) {
		// TODO Auto-generated method stub
		police_station_map police_station_mapObj=null;
		
		
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		PreparedStatement pstmt=null;
		System.out.println("Police Station id" + police_station_id);
		
		if(conn!=null){
			
			try {
				pstmt=conn.prepareStatement("select * from police_station_map where police_station_name = (select police_station_name from police_station where police_station_id=?)");

				//select * from police_station_map where police_station_name = (select police_station_name from police_station where police_station_id=1);
				pstmt.setString(1,police_station_id);
				rs=pstmt.executeQuery();
				
				
				while(rs.next())
				{
					police_station_mapObj=new police_station_map();
					
					police_station_mapObj.setPolice_station_map_id(rs.getString("police_station_map_id"));
					police_station_mapObj.setPolice_station_name(rs.getString("police_station_name"));
					police_station_mapObj.setLatitude(rs.getString("latitude"));
					police_station_mapObj.setLongitude(rs.getString("longitude"));
					police_station_mapObj.setArea_id(rs.getString("area_id"));
					
					System.out.println("psId::"+police_station_mapObj.getPolice_station_map_id());
					
				}
	
				
			} catch (Exception e) {
				e.printStackTrace();
				
			}
			
		}
		
		
		return police_station_mapObj;
	}

	
}
