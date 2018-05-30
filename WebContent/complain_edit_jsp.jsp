<%@page import="Mindeft.CFMS.dao.complain_status_Dao"%>
<%@page import="Mindeft.CFMS.bean.complain_status_Bean"%>
<%@page import="Mindeft.CFMS.bean.complainBean"%>
<%@page import="Mindeft.CFMS.dao.police_stationDao"%>
<%@page import="Mindeft.CFMS.bean.police_station_Bean"%>
<%@page import="Mindeft.CFMS.dao.crimeDao"%>
<%@page import="Mindeft.CFMS.bean.crimeBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>

table {
    border-collapse: collapse;
	width:60%;
}
th
{
    padding: 15px;
    text-align: left;
    border-bottom: 1px solid #ddd;
 	background-color: rgba(248, 219, 25, 0.29);
}
td {
    padding: 15px;
    text-align: left;
    border-bottom: 1px solid #ddd;
}
tr:hover {background-color: #a9a9a9}

 .button
  {
   background-color: #4CAF50; /* Green */
    border: none;
    color: white;
    padding: 8px 35px;
	text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    -webkit-transition-duration: 0.4s; /* Safari */
    transition-duration: 0.4s;
    cursor: pointer;
  border-radius:12px;
 }
 .button4 {
    background-color: rgba(240, 195, 11, 0.32);
    border: 2px solid green;
}


.button4:hover {background-color: #e7e7e7;}

#text3
{
    background: #40413c;
    color: #a2a9a9;
    width: 250px;
	padding: 6px 15px 6px 35px;
	transition: 500ms all ease;
	border: 1px solid #333;
	border-radius: 10px;
	box-shadow: 0 1px 0 #ccc inset;
}

#abc
{
	-webkit-appearance:radio;
	position:absolute;
	left:580px;
	top:520px;

}
#abc1
{
	-webkit-appearance:radio;
	position:absolute;
	left:720px;
	top:520px;

}

#text3:hover
{

box-shadow: 12px 13px 0px rgba(204, 211, 51, 0.38),
-11px -14px 0px rgba(241, 96, 0, 0.28),
18px -24px 0px rgba(0, 0, 0, 0.34),
33px -6px 0px rgba(39, 74, 214, 0.28);
}


</style>
</head>
<body>
<%@include file='myheader1.jsp'%>
<br><br><br><br><br>

<% 
complainBean complainBeanObj=(complainBean)request.getAttribute("complainBeanObj");
%>
<center>

<form action="complain_update" name="complain_edit_form" id="complain_edit_form">
<input type="hidden" name="complain_id" id="complain_id" value="<%= complainBeanObj.getComplain_id() %>">
<input type="hidden" name="user_id" id="user_id" value="<%= complainBeanObj.getUser_id() %>">
<table>

<tr>
<th>Select Crime ::
<td>
<select name="crime_id" id="text3">

<%
List<crimeBean> crimeBeanlist=new crimeDao().select();
String complainBeanObj_crime_id=complainBeanObj.getCrime_id();


if(crimeBeanlist!=null)
{
	for(int i=0;i<crimeBeanlist.size();i++)
	{	
		crimeBean crime=crimeBeanlist.get(i);
		String 	crimeBeanlist_crime_id=crime.getCrime_id();
		
		if(crime!=null)
		{
			if(complainBeanObj_crime_id.equals(crimeBeanlist_crime_id))
			{
				%>
				<option value="<%= crime.getCrime_id() %>" selected="selected"><%= crime.getCrime_details()  %></option>
				<%
			}
			else
			{
				%>
				<option value="<%= crime.getCrime_id() %>"><%= crime.getCrime_details()  %></option>
				<%
			}
		}//nested if
	}//for
}//if
%>

</select> ${ crime_id }
</tr>



<tr>
<th>Select Police station ::
<td>
<select name="police_station_id" id="text3">

<%
List<police_station_Bean> police_stationlist=new police_stationDao().select();
String complainBeanObj_policestation_id=complainBeanObj.getPolice_station_id();

if(police_stationlist!=null)
{
	for(int i=0;i<police_stationlist.size();i++)
	{	
		police_station_Bean police_station=police_stationlist.get(i);
		String 	police_stationlist_policestation_id=police_station.getPolice_station_id();
		
		if(police_station!=null)
		{
			
			if(complainBeanObj_policestation_id.equals(police_stationlist_policestation_id))
			{
				%>
				<option value="<%= police_station.getPolice_station_id() %>" selected="selected"><%= police_station.getPolice_station_name()  %></option>
				<%
			}
			else
			{
				%>
				<option value="<%= police_station.getPolice_station_id() %>"><%= police_station.getPolice_station_name()  %></option>
				<%
			}
		}//nested if
	}//for
}//if
%>

</select> ${ police_station_id }
</tr>

<tr>
<th>Select Complain_status::
<td>
<select name="complain_status_id" id="text3">
<%
List<complain_status_Bean> complain_statuslist=new complain_status_Dao().select();

String complainBeanObj_status_id=complainBeanObj.getComplain_status_id();

if(complain_statuslist!=null)
{
	for(int i=0;i<complain_statuslist.size();i++)
	{	
		complain_status_Bean complain=complain_statuslist.get(i);
		String complain_statuslist_status_id=complain.getComplain_status_id()+"";
		complain_statuslist_status_id=complain_statuslist_status_id.trim();
		
		if(complain!=null)
		{
			
				if(complainBeanObj_status_id.equals(complain_statuslist_status_id))
				{
			
					%>
					<option value="<%= complain.getComplain_status_id() %>" selected="selected"><%= complain.getComplain_status_type()  %></option>

					<% 
				}
				else
				{
					%>
					<option value="<%= complain.getComplain_status_id()  %>"><%= complain.getComplain_status_type()  %></option>

					<% 					
				}
		}//nested if
	}//for
}//if

%>
</select>${ complain_status_id }
</tr>


<tr>
<th>Complain Date :
<td><input type="date" id="text3" name="complain_date">${ complain_date }
</tr> 

<tr>
<th>Complain Details :
<td><textarea row="3" id="text3" name="complain_details" ><%= complainBeanObj.getComplain_details() %></textarea>${ complain_details }
</tr>

<tr>
<td colspan="2"><center><input type="submit" name="btnsubmit" id="btnsubmit" value="OK" class="button button4"></center>
</tr>


</table>
</form>

</center>
<br><br><br><br><br><br><br><br>
<br><br><br>
<br><br>


<%@include file='myFooter.html'%>



</body>
</html>