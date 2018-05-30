<%@page import="Mindeft.CFMS.dao.areaDao"%>
<%@page import="Mindeft.CFMS.bean.AreaBean"%>
<%@page import="Mindeft.CFMS.dao.CrimeTypeDao"%>
<%@page import="Mindeft.CFMS.bean.CrimeTypeBean"%>
<%@page import="java.util.List"%>
<%@page import="Mindeft.CFMS.bean.crimeBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crime Edit</title>
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
crimeBean crimeBeanObj=(crimeBean)request.getAttribute("crimeBeanObj");
String crimeBeanObj_CrimeType_Id=crimeBeanObj.getCrimeType_Id();
String crimeBeanObj_area_id=crimeBeanObj.getArea_id();
%>

<form action="crime_update" name="crime_edit_form" id="crime_edit_form">
<input type="hidden" name="crime_id" id="crime_id" value="<%= crimeBeanObj.getCrime_id()%>">

<table>

<tr>
<th>Select Crime
<td>
<select name="CrimeType_Id" id="text3">
 <%
List<CrimeTypeBean> CrimeTypelist=new CrimeTypeDao().select();

if(CrimeTypelist!=null)
{
	for(int i=0;i<CrimeTypelist.size();i++)
	{	
		CrimeTypeBean CrimeType=CrimeTypelist.get(i);
		String CrimeTypelist_CrimeType_Id=CrimeType.getCrimeTypeId()+"";
		CrimeTypelist_CrimeType_Id=CrimeTypelist_CrimeType_Id.trim();
		
		if(CrimeType!=null)
		{
			if(crimeBeanObj_CrimeType_Id.equals(CrimeTypelist_CrimeType_Id))
			{
				%>
				<option value="<%= CrimeType.getCrimeTypeId()  %>" selected="selected"><%= CrimeType.getCrimeType()  %></option>
				<%
			}
			else
			{
				%>
				<option value="<%= CrimeType.getCrimeTypeId()  %>"><%= CrimeType.getCrimeType()  %></option>
				<%
			}
		}//nested if
	}//for
}//if
%>
</select>${ CrimeType_Id }
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
		String AreaBeanlist_area_id=area.getArea_id();
		
		if(area!=null)
		{
			
			if(crimeBeanObj_area_id.equals(AreaBeanlist_area_id))
			{
				%>
				<option value="<%= area.getArea_id() %>" selected="selected"><%= area.getArea_name()  %></option>
				<%
			}
			else
			{
				%>
				<option value="<%= area.getArea_id() %>"><%= area.getArea_name()  %></option>
				<%	
			}
		}//nested if
	}//for
}//if

%>
</select>${ area_id }
</tr>

<tr>
<th>Date Of Crime :
<td><input type="date" name="crime_date" id="text3">
<td>${ crime_date }
</tr>

<tr>
<th>Crime Detail :
<td><textarea row="3" name="crime_details" id="text3"><%= crimeBeanObj.getCrime_details() %></textarea>
<td>${ crime_details }
</tr>

<tr>
<th>Location Description :
<td><textarea row="3" name="location_description" id="text3"><%= crimeBeanObj.getLocation_description() %></textarea>
<td>${ location_description }
</tr>
 
<tr>
<td colspan="2"><center><input type="submit" name="btnsubmit" id="btnsubmit" value="Submit"  class="button button4"></center>
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