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

<form action="" id="crime_witness_list_form" name="crime_witness_list_form">
<input type="hidden" name="crime_witness_id" id="crime_witness_id">

<!--  
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
</tr>
-->

<% List<crime_witnessBean> crime_witnessBeanlist=(ArrayList)request.getAttribute("crime_witnessBeanlist"); 
if(crime_witnessBeanlist!=null)
{
	for(int i=0;i<crime_witnessBeanlist.size();i++)
	{
		crime_witnessBean crime_witness=crime_witnessBeanlist.get(i);
		%>
		
		<img align="center" height="100px" width="100px" alt="NO IMAGE FOUND TO DISPLAY" src="./upload/crime_witness/<%= crime_witness.getCrime_witness_image() %>"></td>
		 
		<table border=1>
		
		 <tr>
		 <td>Crime Witness id</td>
		 <td><%= crime_witness.getCrime_witness_id() %>
		 </tr>
		 
		 <tr>
		 <td>Crime Witness FirstName</td>
		 <td><%= crime_witness.getCrime_witness_firstname() %>
		 </tr>
		 
		 <tr>
		 <td>Crime Witness MiddleName</td>
		 <td><%= crime_witness.getCrime_witness_middlename() %>
		 </tr>
		 
		 <tr>
		 <td>Crime Witness LastName</td>
		 <td><%= crime_witness.getCrime_witness_lastname() %>
		 </tr>
		 
		 <tr>
		 <td>Crime Witness Gender</td>
		 <td><%= crime_witness.getCrime_witness_gender() %>
		 </tr>
		 
		 <tr>
		 <td>Crime Witness Age</td>
		 <td><%= crime_witness.getCrime_witness_age() %>
		 </tr>
		 
		 <tr>
		 <td>Crime Witness Number</td>
		 <td><%= crime_witness.getCrime_witness_number() %>
		 </tr>
		 
		 <tr>
		 <td>Crime Witness Address</td>
		 <td><%= crime_witness.getCrime_witness_address() %>
		 </tr>
		 
		 
		 <tr>
		 <td>Crime ID</td>
		 <td><%= crime_witness.getCrime_id() %>
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