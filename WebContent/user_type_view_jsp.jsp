<%@page import="Mindeft.CFMS.bean.user_typeBean"%>
<%@page import="java.util.ArrayList"%>
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

<form action="" id="user_type_list_form" name="user_type_list_form">
<input type="hidden" name="user_type_id" id="user_type_id">
<table border=1>
<!--  
<tr>
<td>User_type_id</td>
<td>User_type</td>
</tr>
-->

<% List<user_typeBean> user_typelist=(ArrayList)request.getAttribute("user_typelist"); 
if(user_typelist!=null)
{
	for(int i=0;i<user_typelist.size();i++)
	{
		user_typeBean user_typeBeanObj=user_typelist.get(i);
		%>
		
		 <tr>
		 <td>User_type_id</td>
		 <td><%= user_typeBeanObj.getUser_type_id() %>
		 </tr>
		 
		 <tr>
		 <td>User_type</td>
		 <td><%= user_typeBeanObj.getUser_type()  %>
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