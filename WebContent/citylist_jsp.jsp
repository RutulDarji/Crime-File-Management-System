<%@page import="java.util.ArrayList"%>
<%@page import="Mindeft.CFMS.bean.cityBean"%>
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
body
{
	color:white;
	font-size:20px;
}

.button4:hover {background-color: #e7e7e7;}


</style>
</head>
<body bgcolor="white">
<%@include file='myheader1.jsp'%>
<br><br><br><br><br>
<center>

<center>
<a href="city_table_jsp.jsp"> ADD </a>
</center>

<form action="" id="" name="">
<input type="hidden" name="city_id" id="city_id">
<table>
<tr>
<td>City_id</td>
<td>City_name</td>
<td>State_id</td>
<td>Action</td>
</tr>

<% List<cityBean> citylist=(ArrayList)request.getAttribute("citylist"); 
if(citylist!=null)
{
	for(int i=0;i<citylist.size();i++)
	{
		cityBean city=citylist.get(i);
		%>
		
		 <tr>
		 <td><%= city.getCity_id() %>
		 <td><%= city.getCity_name()  %></td>
		 <td><%= city.getState_id()  %>
		 
		 <td><a href="city_delete?city_id=<%= city.getCity_id() %>">Delete</a> &nbsp;&nbsp;&nbsp; <a href="city_edit?city_id=<%= city.getCity_id() %>">Edit</a>&nbsp;&nbsp;&nbsp;<a href="city_view?city_id=<%= city.getCity_id() %>">View</a>
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