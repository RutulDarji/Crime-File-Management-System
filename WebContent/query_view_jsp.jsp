<%@page import="java.util.ArrayList"%>
<%@page import="Mindeft.CFMS.bean.queryBean"%>
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
    border: 2px solid green;
}


.button4:hover {background-color: #e7e7e7;}


</style>
</head>
<body>
<%@include file='myheader1.jsp'%>
<br><br><br><br><br>
<center>

<form action="" id="query_list_form" name="query_list_form">
<input type="hidden" name="query_id" id="query_id">
<table border=1>

<!--  
<tr>
<td>Query id</td>
<td>Query Details</td>
<td>Query Date</td>
<td>Query Status</td>
<td>User Id</td>
</tr>
-->

<% List<queryBean> queryBeanlist=(ArrayList)request.getAttribute("queryBeanlist"); 
if(queryBeanlist!=null)
{
	for(int i=0;i<queryBeanlist.size();i++)
	{
		queryBean queryBeanObj=queryBeanlist.get(i);
		%>
		
		 <tr>
		 <td>Query id</td>
		 <td><%= queryBeanObj.getQuery_id() %>
		 </tr>
		 
		 <tr>
		 <td>Query Details</td>
		 <td><%= queryBeanObj.getQuery_details() %>
		 </tr>
		 
		 <tr>
		 <td>Query Date</td>
		 <td><%= queryBeanObj.getQuery_date() %>
		 </tr>
		 
		 <tr>
		 <td>Query Status id</td>
		 <td><%= queryBeanObj.getQuery_status_id() %>
		 </tr>
		 
		 <tr>
		 <td>User id</td>
		 <td><%= queryBeanObj.getUser_id() %>
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