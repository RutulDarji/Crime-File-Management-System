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


<form action="" id="missing_person_list_form" name="missing_person_list_form">
<input type="hidden" name="missing_person_id" id="missing_person_id">

<!--  
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
</tr>
-->

<% List<missing_personBean> missing_personBeanlist=(ArrayList)request.getAttribute("missing_personBeanlist"); 
if(missing_personBeanlist!=null)
{
	for(int i=0;i<missing_personBeanlist.size();i++)
	{
		missing_personBean missing_person=missing_personBeanlist.get(i);
		%>
		
		<img height="100px" width="100px" align="center" alt="NO IMAGE FOUND TO DISPLAY" src="./upload/missing_person/<%=missing_person.getMissing_person_image()%>"></td>
		
		<table border=1>
		
		 <tr>
		 <td>Missing Person id</td>
		 <td><%= missing_person.getMissing_person_id() %>
		 </tr>
		 
		 <tr>
		 <td>Missing Person FirstName</td>		 
		 <td><%= missing_person.getMissing_person_firstname() %>
		 </tr>
		 
		 <tr>
		 <td>Missing Person MiddleName</td>
		 <td><%= missing_person.getMissing_person_middlename()%>
		 </tr>
		 
		 <tr>
		 <td>Missing Person LastName</td>
		 <td><%= missing_person.getMissing_person_lastname() %>
		 </tr>
		 
		 <tr>
		 <td>Missing Person Gender</td>
		 <td><%= missing_person.getMissing_person_gender() %>
		 </tr>
		 
		 <tr>
		 <td>Missing Person Age</td>
		 <td><%= missing_person.getMissing_person_age() %>
		 </tr>
		 
		 <tr>
		 <td>ReferencePerson Name</td>
		 <td><%= missing_person.getReferenceperson_name() %>
		 </tr>
		 
		 <tr>
		 <td>ReferencePerson Number</td>
		 <td><%= missing_person.getReferenceperson_number() %>
		 </tr>
		 
		 <tr>
		 <td>ReferencePerson Relation</td>
		 <td><%= missing_person.getReferenceperson_relation() %>
		 </tr>
		 
		 <tr>
		 <td>Area ID</td>
		 <td><%= missing_person.getArea_id() %>
		 </tr>
		 
		 <tr>
		 <td>Missing Person Details</td>
		 <td><%= missing_person.getMissing_person_details() %>
		 </tr>
		 
		 <tr>
		 <td>Missing Person Date</td>
		 <td><%= missing_person.getMissing_person_date() %>
		</tr>
		
		<!--  <tr>
		<td>Missing Person Image</td>
		<td><img height="30px" width="60px" alt="NO IMAGE FOUND TO DISPLAY" src="./upload/missing_person/<%=missing_person.getMissing_person_image()%>"></td>
		 </tr>-->
		   
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