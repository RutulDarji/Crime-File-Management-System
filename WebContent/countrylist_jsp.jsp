<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Mindeft.CFMS.bean.countryBean"%>
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
<a href="country_table_jsp.jsp"> ADD </a>
</center>

<form action="" id="" name="">
<input type="hidden" name="country_id" id="country_id">
<table border="1">
<tr>
<td>country_id</td>
<td>country_name</td>
<td>Action</td>
</tr>

<% List<countryBean> countrylist=(ArrayList)request.getAttribute("countrylist"); 
if(countrylist!=null)
{
	for(int i=0;i<countrylist.size();i++)
	{
		countryBean country=countrylist.get(i);
		%>
		
		 <tr>
		 <td><%= country.getCountry_id() %>
		 <td><%= country.getCountry_name()  %>
		 
		 <td><a href="country_delete?country_id=<%= country.getCountry_id() %>">Delete</a> &nbsp;&nbsp;&nbsp; <a href="country_edit?country_id=<%= country.getCountry_id() %>">Edit</a>&nbsp;&nbsp;&nbsp;<a href="country_view?country_id=<%= country.getCountry_id() %>">View</a>
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