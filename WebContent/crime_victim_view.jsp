<%@page import="Mindeft.CFMS.bean.crime_victimBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Mindeft.CFMS.bean.crime_witnessBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crime Victim View</title>
<style>
body
{
	color:white;
	font-size:20px;
}
table {
    border-collapse: collapse;
	width:50%;
}
th
{
	color:white;
    padding: 15px;
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

<form action="" id="crime_victim_list_form" name="crime_victim_list_form">
<input type="hidden" name="crime_victim_id" id="crime_victim_id">

<!--  
<tr>
<td>Crime Victim id</td>
<td>Crime Victim FirstName</td>
<td>Crime Victim MiddleName</td>
<td>Crime Victim lastName</td>

<td>Crime Victim Gender</td>
<td>Crime Victim Age</td>
<td>Crime Victim Number</td>

<td>Crime Victim Address</td>
<td>Image</td>
<td> Crime Id </td>
</tr>
-->

<% List<crime_victimBean> crime_victimBeanlist=(ArrayList)request.getAttribute("crime_victimBeanlist"); 
if(crime_victimBeanlist!=null)
{
	for(int i=0;i<crime_victimBeanlist.size();i++)
	{
		crime_victimBean crime_victim=crime_victimBeanlist.get(i);
		%>
		
		<img align="center" height="100px" width="100px" alt="NO IMAGE FOUND TO DISPLAY" src="./upload/crime_victim/<%= crime_victim.getCrime_victim_image() %>"></td>
		
		<table border=1>
		
		
		 <tr>
		 <td>Crime Victim id</td>
		 <td><%= crime_victim.getCrime_victim_id() %>
		 </tr>
		 
		 <tr>
		 <td>Crime Victim FirstName</td>
		 <td><%= crime_victim.getCrime_victim_firstname() %>
		 </tr>
		 
		 <tr>
		 <td>Crime Victim MiddleName</td>		 
		 <td><%= crime_victim.getCrime_victim_middlename() %>
		 </tr>
		 
		 <tr>
		 <td>Crime Victim LastName</td>		 
		 <td><%= crime_victim.getCrime_victim_lastname() %>
		 </tr>
		 
		 <tr>
		 <td>Crime Victim Gender</td>		 
		 <td><%= crime_victim.getCrime_victim_gender() %>
		 </tr>
		 
		 <tr>
		 <td>Crime Victim Age</td>		 
		 <td><%= crime_victim.getCrime_victim_age() %>
		 </tr>
		 
		 <tr>
		 <td>Crime Victim Number</td>		 
		 <td><%= crime_victim.getCrime_victim_number() %>
		 </tr>
		 
		 <tr>
		 <td>Crime Victim Address</td>		 
		 <td><%= crime_victim.getCrime_victim_address() %>
		 </tr>
		 
		 
		 <tr>
		 <td>Crime ID</td>
		 <td><%= crime_victim.getCrime_id() %>
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