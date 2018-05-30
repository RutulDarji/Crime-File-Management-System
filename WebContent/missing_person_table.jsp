<%@page import="Mindeft.CFMS.dao.areaDao"%>
<%@page import="Mindeft.CFMS.bean.AreaBean"%>
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
 	background-color: rgba(248, 219, 25, 0.29);
}
td {
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
    background-color: rgba(240, 195, 11, 0.32);
    border: 2px solid green;
}


.button4:hover {background-color: #e7e7e7;}

#text3
{
    background: #40413c;
    color: #a2a9a9;
    width: 250px;
	padding: 6px 15px 6px 35px;
	transition: 500ms all ease;
	border: 1px solid #333;
	border-radius: 10px;
	box-shadow: 0 1px 0 #ccc inset;
}

#abc
{
	-webkit-appearance:radio;
	position:absolute;
	left:580px;
	top:520px;

}
#abc1
{
	-webkit-appearance:radio;
	position:absolute;
	left:720px;
	top:520px;

}

#text3:hover
{

box-shadow: 12px 13px 0px rgba(204, 211, 51, 0.38),
-11px -14px 0px rgba(241, 96, 0, 0.28),
18px -24px 0px rgba(0, 0, 0, 0.34),
33px -6px 0px rgba(39, 74, 214, 0.28);
}

</style>
</head>
<body>
<%@include file='myheader1.jsp'%>
<br><br><br><br><br>
<center>


<center><h3>Missing Person Details</h3></center>

<form action="missing_person_insert" name="missing_person_form" id="missing_person_form" method="post" enctype="multipart/form-data">

<table>

<tr>
<th>Enter FirstName::
<td><input type="text" placeholder="Enter Firstname" name="missing_person_firstname" id="text3" value="${missing_personBeanObj.missing_person_firstname}"> 
<td>${missing_person_firstname}
</tr>

<tr>
<th>Enter MiddleName::
<td><input type="text" placeholder="Enter Middlename" name="missing_person_middlename" id="text3" value="${missing_personBeanObj.missing_person_middlename}"> 
<td>${ missing_person_middlename }
</tr>

<tr>
<th>Enter LastName::
<td><input type="text" placeholder="Enter Lastname" name="missing_person_lastname" id="text3" value="${missing_personBeanObj.missing_person_lastname}">
<td>${ missing_person_lastname }
</tr>

<tr>
<th>Gender::
<td>
<input type="radio" name="missing_person_gender" id="missing_person_gender" value="male">male
<input type="radio" name="missing_person_gender" id="missing_person_gender" value="female">female
<td>${ missing_person_gender}
</tr>

<tr>
<th>Age::
<td><input type="text" placeholder="Enter Age" name="missing_person_age" id="text3" value="${missing_personBeanObj.missing_person_age}">
<td>${ missing_person_age }
</tr>

<tr>
<th>Reference Person Name::
<td><input type="text" placeholder="Enter Referenceperson name" name="referenceperson_name" id="text3" value="${missing_personBeanObj.referenceperson_name}"> 
<td>${ referenceperson_name }
</tr>

<tr>
<th>Reference Person Relation::
<td><input type="text" placeholder="Enter Relation" name="referenceperson_relation" id="text3" value="${missing_personBeanObj.referenceperson_relation}">
<td>${referenceperson_relation }
</tr>

<tr>
<th>Reference Person Number::
<td><input type="text" placeholder="Enter Number" name="referenceperson_number" id="text3" value="${missing_personBeanObj.referenceperson_number}">
<td>${ referenceperson_number }
</tr>

<tr>
<th> Select Area:
<td> 
<select name="area_id" id="text3"> 
<%
List<AreaBean> AreaBeanlist=new areaDao().select();

if(AreaBeanlist!=null)
{
	for(int i=0;i<AreaBeanlist.size();i++)
	{	
		AreaBean area=AreaBeanlist.get(i);
		
		if(area!=null)
		{
				%>
				<option value="<%= area.getArea_id() %>"><%= area.getArea_name()  %></option>
				<%
		
			
		}//nested if
	}//for
}//if

%>
</select>
<td>${ area_id }
</tr>

<tr>
<th>Enter Missing Person Details
<td><textarea row="3" placeholder="Enter Details" name="missing_person_details" id="text3">${missing_personBeanObj.missing_person_firstname}</textarea>
<td>${ missing_person_details }
</tr>

<tr>
<th>Date Of Missing :
<td><input type="date" name="missing_person_date" id="text3">
<td>${ missing_person_date }
</tr> 

<tr>
<th>Image :
<td><input type="file" name="missing_person_image" id="text3">
<td>${ missing_person_image }
</tr>

<tr>
<td colspan="3"><center><input type="submit" name="btnsubmit" id="btnsubmit" value="Submit" class="button button4"></center>
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