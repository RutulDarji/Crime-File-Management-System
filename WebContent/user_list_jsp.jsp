<%@page import="java.util.ArrayList"%>
<%@page import="Mindeft.CFMS.bean.userBean"%>
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
	width:100%;
}
th
{
    padding: 15px;
    text-align: left;
    border-bottom: 1px solid #ddd;
 	background-color: #4CAF50;
}
td {
   <!-- padding: 15px;-->
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
<a href="user_table.jsp">ADD</a>
</center>

<form action="" id="user_list_form" name="user_list_form">
<input type="hidden" name="user_id" id="user_id">
<table border="1">
<tr>
<td>User id</td>
<td>User Firstname</td>
<td>User middlename</td>
<td>User lastname</td>
<td>Email</td>
<td>password</td>
<td>gender</td>
<td>date_of_birth</td>
<td>is Active</td>
<td>Security Question ID</td>
<td>Security Question Answer</td>
<td>User type ID</td>
<td>Mobile</td>
<td>address</td>
<td>User Image</td>
<td>City ID</td>
<td>Action</td>
</tr>

<% List<userBean> userBeanlist=(ArrayList)request.getAttribute("userBeanlist"); 
if(userBeanlist!=null)
{
	for(int i=0;i<userBeanlist.size();i++)
	{
		userBean userBeanObj=userBeanlist.get(i);
		%>
		
		 <tr>
		 <td><%= userBeanObj.getUser_id() %>
		 <td><%= userBeanObj.getUser_firstname() %>
		 <td><%= userBeanObj.getUser_middlename() %>
		 <td><%= userBeanObj.getUser_lastname() %>
		 <td><%= userBeanObj.getEmail() %>
		 <td><%= userBeanObj.getPassword() %>
		 <td><%= userBeanObj.getGender() %>
		 <td><%= userBeanObj.getDate_of_birth() %>
		 <td><%= userBeanObj.getIsActive() %>
		 <td><%= userBeanObj.getSecurity_question_id() %>
		 <td><%= userBeanObj.getSecurity_question_answer()%>
		 <td><%= userBeanObj.getUser_type_id() %>
		 <td><%= userBeanObj.getMobile() %>
		 <td><%= userBeanObj.getAddress() %>
		 <td><img height="30px" width="60px" alt="NO IMAGE FOUND TO DISPLAY" src="./upload/user_image/<%= userBeanObj.getUser_image() %>"></td>
		 <td><%= userBeanObj.getCity_id() %>
		 
		 <td><!--  <a href="user_delete?user_id=<%= userBeanObj.getUser_id() %>">Delete</a> &nbsp;&nbsp;&nbsp; <a href="user_edit?user_id=<%= userBeanObj.getUser_id() %>">Edit</a>&nbsp;&nbsp;&nbsp;--><a href="user_view?user_id=<%= userBeanObj.getUser_id() %>">View</a>
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