<%@page import="Mindeft.CFMS.bean.crimeBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crime List</title>
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
td 
{
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
<a href="crime_table_jsp.jsp"> ADD </a>
</center>

<form action="" id="crime_list_form" name="crime_list_form">
<input type="hidden" name="crime_id" id="crime_id">
<table border=1>
<tr>
<td>Crime Id</td>
<td>Crime Type Id</td>
<td>Area Id</td>
<td>Crime Date</td>
<td>Crime Details</td>
<td>Location Description</td>
<td>Action</td>
</tr>

<% List<crimeBean> crimeBeanlist=(ArrayList)request.getAttribute("crimeBeanlist"); 
if(crimeBeanlist!=null)
{
	for(int i=0;i<crimeBeanlist.size();i++)
	{
		crimeBean crimeBeanObj=crimeBeanlist.get(i);
		%>
		
		 <tr>
		 <td><%= crimeBeanObj.getCrime_id() %>
		 <td><%= crimeBeanObj.getCrimeType_Id() %>
		 <td><%= crimeBeanObj.getArea_id() %>
		 <td><%= crimeBeanObj.getCrime_date() %>
		 <td><%= crimeBeanObj.getCrime_details() %>
		 <td><%= crimeBeanObj.getLocation_description() %>
		 
		 <td><a href="crime_delete?crime_id=<%= crimeBeanObj.getCrime_id() %>">Delete</a> &nbsp;&nbsp;&nbsp; <a href="crime_edit?crime_id=<%= crimeBeanObj.getCrime_id() %>">Edit</a>&nbsp;&nbsp;&nbsp;<a href="crime_view?crime_id=<%= crimeBeanObj.getCrime_id() %>">View</a>
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