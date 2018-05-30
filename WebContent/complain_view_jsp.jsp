<%@page import="java.util.ArrayList"%>
<%@page import="Mindeft.CFMS.bean.complainBean"%>
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

<form action="" id="complain_list_form" name="complain_list_form">
<input type="hidden" name="complain_id" id="complain_id">
<table border=1>
<!--  
<tr>
<td>Complain Id</td>
<td>Complain Status Id</td>
<td>Police Station Id</td>
<td>Complain Date</td>
<td>Complain Details</td>
<td>User Id</td>
<td>Crime Id</td>
</tr>
-->

<% List<complainBean> complainBeanlist=(ArrayList)request.getAttribute("complainBeanlist"); 
if(complainBeanlist!=null)
{
	for(int i=0;i<complainBeanlist.size();i++)
	{
		complainBean complainBeanObj=complainBeanlist.get(i);
		%>
		
		 <tr>
		 <td>Complain Id</td>
		 <td><%= complainBeanObj.getComplain_id() %>
		 </tr>
		 
		 <tr>
		 <td>Complain Status Id</td>
		 <td><%= complainBeanObj.getComplain_status_id() %>
		 </tr>
		 
		 <tr>
		 <td>Police Station Id</td>
		 <td><%= complainBeanObj.getPolice_station_id() %>
		 </tr>
		 
		 <tr>
		 <td>Complain Date</td>
		 <td><%= complainBeanObj.getComplain_date() %>
		 </tr>
		 
		 <tr>
		 <td>Complain Details</td>
		 <td><%= complainBeanObj.getComplain_details() %>
		 </tr>
		 
		 <tr>
		 <td>User Id</td>
		 <td><%= complainBeanObj.getUser_id() %>
		 </tr>
		 
		 <tr>
		 <td>Crime Id</td>
		 <td><%= complainBeanObj.getCrime_id() %>	 
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