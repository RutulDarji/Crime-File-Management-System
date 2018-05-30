<%@page import="Mindeft.CFMS.dao.police_stationDao"%>
<%@page import="Mindeft.CFMS.bean.police_station_Bean"%>
<%@page import="java.util.List"%>
<%@page import="Mindeft.CFMS.bean.criminalBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Criminal Edit</title>
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

<%
criminalBean criminalBeanObj=(criminalBean)request.getAttribute("criminalBeanObj"); 
%>

<center><h3>Criminal Details</h3></center>

<form action="criminal_update" name="criminal_edit_form" id="criminal_edit_form" method="post" enctype="multipart/form-data">
<input type="hidden" name="criminal_id" id="criminal_id" value="<%= criminalBeanObj.getCriminal_id() %>">

<table>


<tr>
<th>Enter FirstName::
<td><input type="text" placeholder="Enter Firstname" name="criminal_firstname" id="text3" value="<%= criminalBeanObj.getCriminal_firstname() %>">
<td> ${criminal_firstname}
</tr>

<tr>
<th>Enter MiddleName::
<td><input type="text" placeholder="Enter Middlename" name="criminal_middlename" id="text3" value="<%= criminalBeanObj.getCriminal_middlename() %>">
<td> ${ criminal_middlename }
</tr>

<tr>
<th>Enter LastName::
<td><input type="text" placeholder="Enter Lastname" name="criminal_lastname" id="text3" value="<%= criminalBeanObj.getCriminal_lastname() %>">
<td>${ criminal_lastname }
</tr>

<tr>
<th>Gender::
<td>
<%
if(criminalBeanObj.getCriminal_gender().equals("male"))
{
	%>
		<input type="radio" name="criminal_gender" id="criminal_gender" value="male" checked="checked">male
		<input type="radio" name="criminal_gender" id="criminal_gender" value="female">female ${ criminal_gender}
	<% 
}
else
{
	%>
	<input type="radio" name="criminal_gender" id="criminal_gender" value="male">male
	<input type="radio" name="criminal_gender" id="criminal_gender" value="female" checked="checked">female ${ criminal_gender}
	<%
}
%>
</tr>

<tr>
<th>Age::
<td><input type="text" placeholder="Enter Age" name="criminal_age" id="text3" value="<%= criminalBeanObj.getCriminal_age() %>">
<td>${ criminal_age }
</tr>


<tr>
<th>Criminal Details
<td><textarea row="3" placeholder="enter criminal details" name="criminal_details" id="text3"><%= criminalBeanObj.getCriminal_details() %></textarea>
<td>${ criminal_details }
</tr>

<tr>
<th>Select Police station Name ::
<td>
<select name="police_station_id" id="text3">
<option value="">IS NOT IN POLICESTATION</option>
<%

String criminalBeanObj_police_station_id=criminalBeanObj.getPolice_station_id();
List<police_station_Bean> police_stationlist=new police_stationDao().select();

if(police_stationlist!=null)
{
	for(int i=0;i<police_stationlist.size();i++)
	{	
		police_station_Bean police_station=police_stationlist.get(i);
		String police_stationlist_police_station_id=police_station.getPolice_station_id();
		
		if(police_station!=null)
		{
			if(criminalBeanObj_police_station_id.equals(police_stationlist_police_station_id))
			{	
				%>
				<option value="<%= police_station.getPolice_station_id() %>" selected="selected"><%= police_station.getPolice_station_name()  %></option>
				<%
			}
			else
			{
				%>
				<option value="<%= police_station.getPolice_station_id() %>"><%= police_station.getPolice_station_name()  %></option>
				<%
			}
		}//nested if
	}//for
}//if

%>

</select>
<td> ${ police_station_id }
</tr>

<tr>
<th>Is MostWanted 
<td>
<select name="mostwanted" id="text3">
<%
if(criminalBeanObj.getMostwanted().equals("0"))
{
	%>
		<option value="0" selected="selected">0 For Not Mostwanted</option>
		<option value="1">1 For Mostwanted</option>
	<% 
}
else
{
	%>
	<option value="0">0 For Not Mostwanted</option>
	<option value="1" selected="selected">1 For Mostwanted</option>
	<% 
}

%>
</select>
</tr>


<tr>
<th>Image :
<td><input type="file" name="criminal_image" id="text3">
<td>${ criminal_image }
</tr>

<tr>
<td colspna="2"><center><input type="submit" name="btnsubmit" id="btnsubmit" value="Submit" class="button button4"></center>
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