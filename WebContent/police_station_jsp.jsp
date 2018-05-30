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

<form action="police_station_insert" name="police_station_form" id="police_station_form">
<table>

<!--  
<tr>
<th>Select Police station Name::
<td>
<select name="police_station_name" id="police_station_name">
<option value="">---Select Any---</option>
<option value="Juna wadaj Police Chowki">Juna wadaj Police Chowki</option>
<option value="Nava Wadaj Police Chowki Bus Stop">Nava Wadaj Police Chowki Bus Stop</option>
<option value="Bopal Police Station">Bopal Police Station</option>
</select> ${ police_station_name }
</tr>
-->

<tr>
<th>Enter Police Station Name::
<td><input type="text" placeholder="Enter Police Station Name" name="police_station_name" id="text3" value="${police_station_BeanObj.police_station_name }"> 
<td>${ police_station_name }
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
			<option value="<%= area.getArea_id() %>" selected="selected"><%= area.getArea_name()  %></option>
			<%

		}//nested if
	}//for
}//if

%>

</select>
<td>${ area_id }
</tr>


<tr>
<th>Enter Contact::
<td><input type="text" id="text3" name="contact" value="${police_station_BeanObj.contact }"> 
<td>${ contact }
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