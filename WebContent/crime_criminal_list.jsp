<%@page import="java.util.ArrayList"%>
<%@page import="Mindeft.CFMS.bean.crime_criminalBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crime Criminal List</title>
<style>
body
{
	color:white;
	font-size:20px;
}
table {
    border-collapse: collapse;
	width:60%;
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
<a href="crime_criminal_table.jsp"> ADD </a>
</center>

<form action="" id="crime_criminal_list_form" name="crime_criminal_list_form">
<input type="hidden" name="crime_criminal_id" id="crime_criminal_id">
<table border=1>
<tr>
<td>Crime Criminal ID</td>
<td>Crime Id</td>
<td>Criminal ID</td>
<td>Action</td>
</tr>

<% 
List<crime_criminalBean> crime_criminalBeanlist=(ArrayList)request.getAttribute("crime_criminalBeanlist");
if(crime_criminalBeanlist!=null)
{
	for(int i=0;i<crime_criminalBeanlist.size();i++)
	{
		crime_criminalBean crime_criminalBeanObj=crime_criminalBeanlist.get(i);
		%>
		
		 <tr>
		 <td><%= crime_criminalBeanObj.getCrime_criminal_id() %>
		 <td><%= crime_criminalBeanObj.getCrime_id() %>
		  <td><%= crime_criminalBeanObj.getCriminal_id() %>
		
		 <td><a href="crime_criminal_delete?crime_criminal_id=<%= crime_criminalBeanObj.getCrime_criminal_id() %>">Delete</a> &nbsp;&nbsp;&nbsp; <a href="crime_criminal_edit?crime_criminal_id=<%= crime_criminalBeanObj.getCrime_criminal_id() %>">Edit</a>&nbsp;&nbsp;&nbsp;<a href="crime_criminal_view?crime_criminal_id=<%= crime_criminalBeanObj.getCrime_criminal_id() %>">View</a>
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