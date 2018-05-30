<%@page import="java.util.ArrayList"%>
<%@page import="Mindeft.CFMS.bean.query_response_Bean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Query Response List</title>
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
    color: black;
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
<a href="query_response_table.jsp"> ADD </a>
</center>

<form action="" id="query_response_list_form" name="query_response_list_form">
<input type="hidden" name="query_response_id" id="query_response_id">
<table border=1>
<tr>
<td>Query Response Id</td>
<td>Query Response Details</td>
<td>Query Id</td>
<td>Query Date</td>
<td>Action</td>
</tr>

<% List<query_response_Bean> query_response_Beanlist=(ArrayList)request.getAttribute("query_response_Beanlist"); 
if(query_response_Beanlist!=null)
{
	for(int i=0;i<query_response_Beanlist.size();i++)
	{
		query_response_Bean query_response_BeanObj=query_response_Beanlist.get(i);
		%>
		
		 <tr>
		 <td><%= query_response_BeanObj.getQuery_response_id() %>
		 <td><%= query_response_BeanObj.getQuery_response_details() %>
		 <td><%= query_response_BeanObj.getQuery_id() %>
		 <td><%= query_response_BeanObj.getQuery_response_date() %>
		 
		 <td><a href="query_response_delete?query_response_id=<%= query_response_BeanObj.getQuery_response_id() %>">Delete</a> &nbsp;&nbsp;&nbsp; <a href="query_response_edit?query_response_id=<%= query_response_BeanObj.getQuery_response_id() %>">Edit</a>&nbsp;&nbsp;&nbsp;<a href="query_response_view?query_response_id=<%= query_response_BeanObj.getQuery_response_id() %>">View</a>
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