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
	width:60%;
}
th
{
    padding: 15px;
    text-align: left;
    border-bottom: 1px solid #ddd;
 	background-color: #4CAF50;
}
td {
    <!--padding: 15px;-->
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
    background-color: rgba(240, 195, 11, 0.32);
    border: 2px solid green;
}


.button4:hover {background-color: #e7e7e7;}


</style>
</head>
<body>
<%@include file='myheader1.jsp'%>
<br><br><br><br><br>
<center>

<form action="block_user" id="user_list_form" name="user_list_form">



<% List<userBean> userBeanlist=(ArrayList)request.getAttribute("userBeanlist"); 
if(userBeanlist!=null)
{
	for(int i=0;i<userBeanlist.size();i++)
	{
		userBean userBeanObj=userBeanlist.get(i);
		%>
		
		 <img height="100px" width="100px" align="center" alt="NO IMAGE FOUND TO DISPLAY" src="./upload/user_image/<%= userBeanObj.getUser_image() %>">
		 
		<table>			
		 <tr>
		 <td>User id</td>
		 <td><%= userBeanObj.getUser_id() %>
		 </tr>
		 
		 <tr>
		 <td>User Firstname</td>
		 <td><%= userBeanObj.getUser_firstname() %>
		 </tr>
		 
		 <tr>
		 <td>User middlename</td>
		 <td><%= userBeanObj.getUser_middlename() %>
		 </tr>
		 
		 <tr>
		 <td>User lastname</td>
		 <td><%= userBeanObj.getUser_lastname() %>
		 </tr>
		 
		 <tr>
		 <td>Email</td>
		 <td><%= userBeanObj.getEmail() %>
		 </tr>
		 
		 <tr>
		 <td>password</td>
		 <td><%= userBeanObj.getPassword() %>
		 </tr>
		 
		 <tr>
		 <td>gender</td>
		 <td><%= userBeanObj.getGender() %>
		 </tr>
		 
		 <tr>
		 <td>date_of_birth</td>
		 <td><%= userBeanObj.getDate_of_birth() %>
		 </tr>
		 
		 <tr>
		 <td>is Active</td>
		 <td><%= userBeanObj.getIsActive() %>
		 </tr>
		 
		 <tr>
		 <td>Security Question Id</td>
		 <td><%= userBeanObj.getSecurity_question_id() %>
		 </tr>
		 
		 <tr>
		<td>Security Question Answer</td>
		 <td><%= userBeanObj.getSecurity_question_answer()%>
		 </tr>
		 
		 <tr>
		 <td>User Type ID</td>
		 <td><%= userBeanObj.getUser_type_id() %>
		 </tr>
		 
		 <tr>
		 <td>Mobile Number</td>
		 <td><%= userBeanObj.getMobile() %>
		 </tr>
		 
		 <tr>
		 <td>Address</td>
		 <td><%= userBeanObj.getAddress() %>
		 </tr>
		 
		 <tr>
		 <td>City ID</td>
		 <td><%= userBeanObj.getCity_id() %>
		 </tr>
		 
		 <input type="hidden" name="user_id" id="user_id" value="<%= userBeanObj.getUser_id() %>">
		 <input type="hidden" name="isActive" id="isActive" value="<%= userBeanObj.getIsActive() %>">
		 
		   
<% }%>
	
	
	<% 
}
%>

<tr>
<td colspan="16" align="center"><input type="submit" name="btnsubmit" value="BLOCK/UNBLOCK" class="button button4">
</tr>


</table>
</form>
</center>
<br><br><br><br><br><br><br><br>
<br><br><br>
<br><br>


<%@include file='myFooter.html'%>


</body>
</html>