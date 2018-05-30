<%@page import="java.util.ArrayList"%>
<%@page import="Mindeft.CFMS.bean.police_station_Bean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
body
{
	color:white;
	font-size:20px;
}
table {
    border-collapse: collapse;
	width:80%;
}
th
{
    padding: 15px;
    color:white;
    text-align: left;
    border-bottom: 1px solid #ddd;
 	background-color: #4CAF50;
}
td {
    padding: 15px;
    color:white;
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
    background-color: #4CAF50;
    border: 2px solid green;
}


.button4:hover {background-color: #e7e7e7;}


</style>
</head>
<body>
<%@include file='myheader1.jsp'%>
<br><br><br><br><br>
<center>


<form action="" id="" name="">
<input type="hidden" name="police_station_id" id="police_station_id">
<table border=1>

<!--  
<tr>
<td>Police Station ID</td>
<td>Police Station Name</td>
<td>area Id</td>
<td>Contact</td>
</tr>
-->

<% List<police_station_Bean> police_stationlist=(ArrayList)request.getAttribute("police_stationlist"); 
if(police_stationlist!=null)
{
	for(int i=0;i<police_stationlist.size();i++)
	{
		police_station_Bean police_station=police_stationlist.get(i);
		%>
		
		 <tr>
		 <td>Police Station ID</td>
		 <td><%= police_station.getPolice_station_id() %>
		 </tr>
		 
		 <tr>
		 <td>Police Station Name</td>
		 <td><%= police_station.getPolice_station_name() %>
		 </tr>
		 
		 <tr>
		 <td>Area ID</td>
		 <td><%= police_station.getArea_id() %>
		 </tr>
		 
		 <tr>
		 <td>Police Station Contact</td>
		 <td><%= police_station.getContact() %>	 
		</tr>
		   
<% }%>
	
	
	<% 
}
%>


</table>
</form>
</center>
<br><br><br><br><br><br><br><br>
<br><br><br>
<br><br>

<%@include file='myFooter.html'%>

</body>
</html>