<%@page import="Mindeft.CFMS.dao.criminalDao"%>
<%@page import="Mindeft.CFMS.bean.criminalBean"%>
<%@page import="Mindeft.CFMS.dao.crimeDao"%>
<%@page import="Mindeft.CFMS.bean.crimeBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crime Criminal Table</title>
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

<form action="crime_criminal_insert" name="crime_criminal_table_form" id="area_table_form">
<table>

<tr>
<th>Select Crime
<td>
<select name="crime_id" id="text3">
<option value="">---Select Any Crime---</option>
 <%
List<crimeBean> crimeBeanlist=new crimeDao().select();

if(crimeBeanlist!=null)
{
	for(int i=0;i<crimeBeanlist.size();i++)
	{	
		crimeBean crimeBeanObj=crimeBeanlist.get(i);
		
		if(crimeBeanObj!=null)
		{
			%>
				<option value="<%= crimeBeanObj.getCrime_id()  %>" ><%= crimeBeanObj.getCrime_details()  %></option>
			<% 
		}//nested if
	}//for
}//if
%>
</select>${ crime_id }
</tr>


<tr>
<th>Select Criminal
<td>
<select name="criminal_id" id="text3">
<option value="">---Select Any Criminal---</option>
 <%
List<criminalBean> criminalBeanlist=new criminalDao().select();

if(criminalBeanlist!=null)
{
	for(int i=0;i<criminalBeanlist.size();i++)
	{	
		criminalBean criminalBeanObj=criminalBeanlist.get(i);
		System.out.println("Criminal id In tAble::" +criminalBeanObj.getCriminal_id());
		if(criminalBeanObj!=null)
		{
			%>
				<option value="<%= criminalBeanObj.getCriminal_id()  %>" ><%= criminalBeanObj.getCriminal_firstname()+  " " +criminalBeanObj.getCriminal_lastname()  %></option>
			<% 
		}//nested if
	}//for
}//if
%>
</select>${ criminal_id }
</tr>


<tr>
<td colspan="2"><center><input type="submit" name="btnsubmit" id="btnsubmit" value="OK" class="button button4"></center>
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