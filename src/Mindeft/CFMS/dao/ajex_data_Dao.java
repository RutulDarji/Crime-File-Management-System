package Mindeft.CFMS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Mindeft.CFMS.bean.AreaBean;
import Mindeft.CFMS.bean.cityBean;
import Mindeft.CFMS.bean.police_station_Bean;
import Mindeft.CFMS.bean.stateBean;
import Mindeft.CFMS.util.DatabaseConnection;

public class ajex_data_Dao {

	public  static List<stateBean> getAllState(String country_id) {
		// TODO Auto-generated method stub
		
		System.out.println("Inside Get All State Function");
		
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		stateBean stateBeanobj=null;
		List<stateBean> statelist=new ArrayList<stateBean>(); 
		

		PreparedStatement pstmt=null;
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("select * from state where country_id=?");
				pstmt.setString(1,country_id);
				rs=pstmt.executeQuery();
				
				stateBeanobj=new stateBean();
				stateBeanobj.setState_id("");
				stateBeanobj.setState_name("--Select Any State----");
				statelist.add(stateBeanobj);
				
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
	
	
	public  static List<cityBean> getAllCity(String state_id) {
		// TODO Auto-generated method stub
		
		System.out.println("Inside Get All City Function" + state_id);
		
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		cityBean cityBeanobj=null;
		List<cityBean> citylist=new ArrayList<cityBean>();
		
		
		
		
		
		PreparedStatement pstmt=null;
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("select * from city where state_id=?");
				pstmt.setString(1,state_id);
				rs=pstmt.executeQuery();
		
				cityBeanobj=new cityBean();
				cityBeanobj.setCity_id("");
				cityBeanobj.setCity_name("----Select Any City----");
				citylist.add(cityBeanobj);
				
				while(rs.next())
				{
					cityBeanobj=new cityBean();
					
					cityBeanobj.setCity_id(rs.getString("city_id"));
					System.out.println(rs.getString("city_id"));
					cityBeanobj.setCity_name(rs.getString("city_name"));
					System.out.println(rs.getString("city_name"));
					cityBeanobj.setState_id(rs.getString("state_id"));
				
					
					citylist.add(cityBeanobj);
				}
				
				
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		return citylist;
	}

	public List<AreaBean> getAjexArea(String city_id) {
		
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		System.out.println("Inside Get All Area Function" + city_id);
		
		AreaBean AreaBeanObj=null;
		List<AreaBean> AreaBeanlist=new ArrayList<AreaBean>(); 
		

		PreparedStatement pstmt=null;
		
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("select * from area  where city_id=?");
				pstmt.setString(1,city_id);
				rs=pstmt.executeQuery();
				
				AreaBeanObj=new AreaBean();
				AreaBeanObj.setArea_id("");
				AreaBeanObj.setArea_name("----Select Area Name----");
				AreaBeanlist.add(AreaBeanObj);
				
				while(rs.next())
				{
					AreaBeanObj=new AreaBean();
					
					AreaBeanObj.setArea_id(rs.getString("area_id"));
					AreaBeanObj.setArea_name(rs.getString("area_name"));
					AreaBeanObj.setZipcode(rs.getString("zipcode"));
					AreaBeanObj.setCity_id(rs.getString("city_id"));
					
					AreaBeanlist.add(AreaBeanObj);
				}
				
				
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		return AreaBeanlist;
		
	}
	
	public List<police_station_Bean> getAjexPoliceStation(String area_id) {
		Connection conn=DatabaseConnection.getDbConnection();
		ResultSet rs=null;
		
		List<police_station_Bean> police_stationlist=new ArrayList<police_station_Bean>(); 
		police_station_Bean police_station_BeanObj=null; 
		PreparedStatement pstmt=null;
		
		if(conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement("SELECT * from police_station WHERE area_id = ?");
				pstmt.setString(1,area_id);
				rs=pstmt.executeQuery();
				
				police_station_BeanObj=new police_station_Bean();
				police_station_BeanObj.setPolice_station_id("");
				police_station_BeanObj.setPolice_station_name("----Select Any Police Station---");
				police_stationlist.add(police_station_BeanObj);
				
				while(rs.next())
				{
					police_station_BeanObj=new police_station_Bean();
					
					police_station_BeanObj.setPolice_station_id(rs.getString("police_station_id"));
					police_station_BeanObj.setPolice_station_name(rs.getString("police_station_name"));
					police_station_BeanObj.setContact(rs.getString("contact"));
					police_station_BeanObj.setArea_id(rs.getString("area_id"));
					
					police_stationlist.add(police_station_BeanObj);
				}
				
				
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		return police_stationlist;
	}
	
	
}
