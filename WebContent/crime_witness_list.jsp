<%@page import="java.util.ArrayList"%>
<%@page import="Mindeft.CFMS.bean.crime_witnessBean"%>
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

<center>
<a href="crime_witness_table.jsp"> ADD </a>
</center>


<form action="" id="crime_witness_list_form" name="crime_witness_list_form">
<input type="hidden" name="crime_witness_id" id="crime_witness_id">
<table border=1>
<tr>
<td>Crime Witness id</td>
<td>Crime Witness FirstName</td>
<td>Crime Witness MiddleName</td>
<td>Crime Witness lastName</td>

<td>Crime Witness Gender</td>
<td>Crime Witness Age</td>
<td>Crime Witness Number</td>

<td>Crime Witness Address</td>
<td>Image</td>
<td> Crime Id </td>
<td>Action</td>
</tr>

<% List<crime_witnessBean> crime_witnessBeanlist=(ArrayList)request.getAttribute("crime_witnessBeanlist"); 
if(crime_witnessBeanlist!=null)
{
	for(int i=0;i<crime_witnessBeanlist.size();i++)
	{
		crime_witnessBean crime_witness=crime_witnessBeanlist.get(i);
		%>
		
		 <tr>
		 <td><%= crime_witness.getCrime_witness_id() %>
		 <td><%= crime_witness.getCrime_witness_firstname() %>
		 <td><%= crime_witness.getCrime_witness_middlename() %>
		 <td><%= crime_witness.getCrime_witness_lastname() %>
		 <td><%= crime_witness.getCrime_witness_gender() %>
		 <td><%= crime_witness.getCrime_witness_age() %>
		 <td><%= crime_witness.getCrime_witness_number() %>
		 <td><%= crime_witness.getCrime_witness_address() %>
		 <td><img height="30px" width="60px" alt="NO IMAGE FOUND TO DISPLAY" src="./upload/crime_witness/<%= crime_witness.getCrime_witness_image() %>"></td>
		 <td><%= crime_witness.getCrime_id() %>
		 
		 <td><a href="crime_witness_delete?crime_witness_id=<%= crime_witness.getCrime_witness_id() %>">Delete</a> &nbsp;&nbsp;&nbsp; <a href="crime_witness_edit?crime_witness_id=<%= crime_witness.getCrime_witness_id() %>">Edit</a>&nbsp;&nbsp;&nbsp;<a href="crime_witness_view?crime_witness_id=<%= crime_witness.getCrime_witness_id() %>">View</a>
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