<%@page import="java.util.ArrayList"%>
<%@page import="Mindeft.CFMS.bean.evidenceBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Evidence List</title>
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
<a href="evidence_table_jsp.jsp"> ADD </a>
</center>


<form action="" id="evidence_list_form" name="evidence_list_form">
<input type="hidden" name="evidence_id" id="evidence_id">
<table border=1>
<tr>
<td>Evidence id</td>
<td>Evidence Date</td>
<td>Evidence Details</td>
<td>Evidence image</td>
<td>Crime Id</td>
<td>Action</td>
</tr>

<% 

List<evidenceBean> evidenceBeanlist=(ArrayList)request.getAttribute("evidenceBeanlist");
if(evidenceBeanlist!=null)
{
	for(int i=0;i<evidenceBeanlist.size();i++)
	{
		evidenceBean evidenceBeanObj=evidenceBeanlist.get(i);
		%>
		
		 <tr>
		 <td><%= evidenceBeanObj.getEvidence_id() %>
		 <td><%= evidenceBeanObj.getEvidence_date() %>
		 <td><%= evidenceBeanObj.getEvidence_details() %>
		 <td><img height="30px" width="60px" alt="NO IMAGE FOUND TO DISPLAY" src="./upload/criminal/<%= evidenceBeanObj.getEvidence_image() %>">
		 <td><%= evidenceBeanObj.getCrime_id() %>
		 
		 <td><a href="evidence_delete?evidence_id=<%= evidenceBeanObj.getEvidence_id() %>">Delete</a> &nbsp;&nbsp;&nbsp; <a href="evidence_edit?evidence_id=<%= evidenceBeanObj.getEvidence_id() %>">Edit</a>&nbsp;&nbsp;&nbsp;<a href="evidence_view?evidence_id=<%= evidenceBeanObj.getEvidence_id() %>">View</a>
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