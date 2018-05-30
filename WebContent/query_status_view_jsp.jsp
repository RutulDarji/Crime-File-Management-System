<%@page import="java.util.ArrayList"%>
<%@page import="Mindeft.CFMS.bean.query_status_Bean"%>
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

<form action="" id="" name="">
<input type="hidden" name="query_status_id" id="query_status_id">
<table border=1>
<!--  
<tr>
<td>query_status_id</td>
<td>query_status_type</td>
</tr>
-->
<% List<query_status_Bean> query_status_list=(ArrayList)request.getAttribute("query_status_list"); 
if(query_status_list!=null)
{
	for(int i=0;i<query_status_list.size();i++)
	{
		query_status_Bean query_status=query_status_list.get(i);
		%>
		
		 <tr>
		 <td>query_status_id</td>
		 <td><%= query_status.getQuery_status_id() %>
		 </tr>
		 
		 <tr>
		 <td>query_status_type</td>
		 <td><%= query_status.getQuery_status_type()  %>
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