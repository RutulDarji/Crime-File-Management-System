<%@page import="Mindeft.CFMS.bean.crime_accuseBean"%>
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
	width:50%;
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

<form action="" id="crime_accuse_list_form" name="crime_accuse_list_form">
<input type="hidden" name="crime_accuse_id" id="crime_accuse_id">
<table border=1>
<!--  
<tr>
<td>Crime Accuse id</td>
<td>Crime Accuse FirstName</td>
<td>Crime Accuse MiddleName</td>
<td>Crime Accuse lastName</td>

<td>Crime Accuse Gender</td>
<td>Crime Accuse Age</td>
<td>Crime Accuse Number</td>

<td>Crime Accuse Address</td>
<td>Image</td>
<td> Crime Id </td>
</tr>
-->

<% List<crime_accuseBean> crime_accuseBeanlist=(ArrayList)request.getAttribute("crime_accuseBeanlist"); 
if(crime_accuseBeanlist!=null)
{
	for(int i=0;i<crime_accuseBeanlist.size();i++)
	{
		crime_accuseBean crime_accuse=crime_accuseBeanlist.get(i);
		%>
		
		<img height="100px" width="100px" align="center" alt="NO IMAGE FOUND TO DISPLAY" src="./upload/crime_accuse/<%= crime_accuse.getCrime_accuse_image() %>"></td>
		 
		<table border="1">
		 
		 <tr>
		 <td>Crime Accuse id</td>
		 <td><%= crime_accuse.getCrime_accuse_id() %>
		 </tr>
		 
		 <tr>
		 <td>Crime Accuse FirstName</td>
		 <td><%= crime_accuse.getCrime_accuse_firstname() %>
		 </tr>
		 
		 <tr>
		 <td>Crime Accuse MiddleName</td>
		 <td><%= crime_accuse.getCrime_accuse_middlename() %>
		</tr>
		
		<tr>
		  <td>Crime Accuse lastName</td>			
		 <td><%= crime_accuse.getCrime_accuse_lastname() %>
		 </tr>
		 
		 <tr>
		 <td>Crime Accuse Gender</td>
		 <td><%= crime_accuse.getCrime_accuse_gender() %>
		 </tr>
		 
		 <tr>
		 <td>Crime Accuse Age</td>			 
		 <td><%= crime_accuse.getCrime_accuse_age() %>
		 </tr>
		 
		 <tr>
		 <td>Crime Accuse Number</td>		 
		 <td><%= crime_accuse.getCrime_accuse_number() %>
		 </tr>
		 
		 <tr>
		 <td>Crime Accuse Address</td>		 
		 <td><%= crime_accuse.getCrime_accuse_address() %>
		 </tr>
		 
		 
		 <tr>
		 <td> Crime Id </td>		 
		 <td><%= crime_accuse.getCrime_id() %>
		
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