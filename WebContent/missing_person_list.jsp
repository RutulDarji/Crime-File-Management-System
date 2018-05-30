<%@page import="java.util.ArrayList"%>
<%@page import="Mindeft.CFMS.bean.missing_personBean"%>
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
<a href="missing_person_table.jsp"> ADD </a>
</center>

<form action="" id="missing_person_list_form" name="missing_person_list_form">
<input type="hidden" name="missing_person_id" id="missing_person_id">
<table border=1>
<tr>
<td>Missing Person id</td>
<td>Missing Person FirstName</td>
<td>Missing Person MiddleName</td>
<td>Missing Person lastName</td>

<td>Missing Person Gender</td>
<td>Missing Person Age</td>
<td>Reference Name</td>
<td>Reference Number</td>

<td>Reference Relation</td>
<td>Area id</td>
<td>Missing Person Detail</td>
<td>Missing Date</td>
<td>Image</td>
<td>Action</td>
</tr>

<% List<missing_personBean> missing_personBeanlist=(ArrayList)request.getAttribute("missing_personBeanlist"); 
if(missing_personBeanlist!=null)
{
	for(int i=0;i<missing_personBeanlist.size();i++)
	{
		missing_personBean missing_person=missing_personBeanlist.get(i);
		%>
		
		 <tr>
		 <td><%= missing_person.getMissing_person_id() %>
		 <td><%= missing_person.getMissing_person_firstname() %>
		 <td><%= missing_person.getMissing_person_middlename()%>
		 <td><%= missing_person.getMissing_person_lastname() %>
		 <td><%= missing_person.getMissing_person_gender() %>
		 <td><%= missing_person.getMissing_person_age() %>
		 <td><%= missing_person.getReferenceperson_name() %>
		 <td><%= missing_person.getReferenceperson_number() %>
		 <td><%= missing_person.getReferenceperson_relation() %>
		 <td><%= missing_person.getArea_id() %>
		 <td><%= missing_person.getMissing_person_details() %>
		 <td><%= missing_person.getMissing_person_date() %>
		 <td><img height="30px" width="60px" alt="NO IMAGE FOUND TO DISPLAY" src="./upload/missing_person/<%=missing_person.getMissing_person_image()%>"></td>
		 
		 <td><a href="missing_person_delete?missing_person_id=<%= missing_person.getMissing_person_id() %>">Delete</a> &nbsp;&nbsp;&nbsp; <a href="missing_person_edit?missing_person_id=<%= missing_person.getMissing_person_id() %>">Edit</a>&nbsp;&nbsp;&nbsp;<a href="missing_person_view?missing_person_id=<%= missing_person.getMissing_person_id() %>">View</a>
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