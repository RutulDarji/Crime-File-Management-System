<%@page import="java.util.ArrayList"%>
<%@page import="Mindeft.CFMS.bean.criminalBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Criminal List</title>
<style>
body
{
	color:white;
	font-size:20px;
}
table {
    border-collapse: collapse;
	width:100%;
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
	color:white;
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

<center>
<a href="criminal_table.jsp"> ADD </a>
</center>

<form action="" id="criminal_list_form" name="criminal_list_form">
<input type="hidden" name="criminal_id" id="criminal_id">
<table border=1>
<tr>
<td>Criminal id</td>
<td>Criminal Firstname</td>
<td>Criminal Middlename</td>
<td>Criminal lastname</td>
<td>Criminal Gender</td>
<td>Criminal Age</td>
<td>Criminal Details</td>
<td>Criminal Image</td>
<td>Is Mostwanted</td>
<td>Police Station id</td>
<td>Action</td>
</tr>

<% List<criminalBean> criminalBeanlist=(ArrayList)request.getAttribute("criminalBeanlist"); 
if(criminalBeanlist!=null)
{
	for(int i=0;i<criminalBeanlist.size();i++)
	{
		criminalBean criminalBeanObj=criminalBeanlist.get(i);
		%>
		
		 <tr>
		 <td><%= criminalBeanObj.getCriminal_id() %>
		 <td><%= criminalBeanObj.getCriminal_firstname() %>
		 <td><%= criminalBeanObj.getCriminal_middlename() %>
		 <td><%= criminalBeanObj.getCriminal_lastname() %>
		 <td><%= criminalBeanObj.getCriminal_gender() %>
		 <td><%= criminalBeanObj.getCriminal_age() %>
		 <td><%= criminalBeanObj.getCriminal_details() %>
		 <td><img height="30px" width="60px" alt="NO IMAGE FOUND TO DISPLAY" src="./upload/criminal/<%= criminalBeanObj.getCriminal_image() %>">
		 <td><%= criminalBeanObj.getMostwanted() %>
		 <td><%= criminalBeanObj.getPolice_station_id() %>
		 
		 <td><a href="criminal_delete?criminal_id=<%= criminalBeanObj.getCriminal_id() %>">Delete</a> &nbsp;&nbsp;&nbsp; <a href="criminal_edit?criminal_id=<%= criminalBeanObj.getCriminal_id() %>">Edit</a>&nbsp;&nbsp;&nbsp;<a href="criminal_view?criminal_id=<%= criminalBeanObj.getCriminal_id() %>">View</a>
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