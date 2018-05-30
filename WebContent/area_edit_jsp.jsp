 <%@page import="Mindeft.CFMS.dao.areaDao"%>
<%@page import="Mindeft.CFMS.bean.AreaBean"%>
<%@page import="Mindeft.CFMS.dao.cityDao"%>
<%@page import="Mindeft.CFMS.bean.cityBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Area Edit</title>
<style>

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
    border: 2px solid #dddddd;
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
body
{
	color:white;
	font-size:20px;

}
</style>
</head>
<body>
<%@include file='myheader1.jsp'%>
<br><br><br><br><br>
<center>
<form action="area_update" name="area_edit_form" id="area_edit_form">
<input type="hidden" name="area_id" id="text3" value="${AreaBeanObj.area_id}">
<table>

<tr>
<th align="right"> Select City:
<td align="center"> 
<select name="city_id" id="text3"> 
<%
List<cityBean> citylist=new cityDao().select();
AreaBean AreaBeanObj=(AreaBean)request.getAttribute("AreaBeanObj");
String AreaBeanObj_city_id=AreaBeanObj.getCity_id();
String citylist_city_id=new String();

if(citylist!=null)
{
	for(int i=0;i<citylist.size();i++)
	{	
		cityBean city=citylist.get(i);
		citylist_city_id=city.getCity_id();
		
		if(city!=null)
		{
			if(AreaBeanObj_city_id.equals(citylist_city_id))
			{
				%>
				<option value="<%= city.getCity_id() %>" selected="selected"><%= city.getCity_name()  %></option>
				<%
			}
			else
			{
				%>
				<option value="<%= city.getCity_id() %>"><%= city.getCity_name()  %></option>
				<%
			}
			
		}//nested if
	}//for
}//if

%>
</select> 
<td align="left">${ city_id }
</tr>

<!-- 
<tr>
<th> Select Area:
<td> 
<select name="area_name"> 
<option value="">----Select Any Area----</option>
<option value="Vadaj">Vadaj</option>
<option value="Bopal">Bopal</option>
<option value="Paldi">Paldi</option>
<option value="C.G.Road">C.G.Road</option>
</select>${ area_name }
</tr>
 -->

<!-- 
<tr>
<th> Select Area:
<td> 
<select name="area_name"> 
<%
List<AreaBean> AreaBeanlist=new areaDao().select();

String AreaBeanObj_area_name=AreaBeanObj.getArea_name();
String AreaBeanlist_area_name=new String();

if(AreaBeanlist!=null)
{
	for(int i=0;i<AreaBeanlist.size();i++)
	{	
		AreaBean area=AreaBeanlist.get(i);
		AreaBeanlist_area_name=area.getArea_name();
		
		if(area!=null)
		{
			if(AreaBeanObj_area_name.equals(AreaBeanlist_area_name))
			{
				%>
				<option value="<%= area.getArea_name() %>" selected="selected"><%= area.getArea_name()  %></option>
				<%
			}
			else
			{
				%>
				<option value="<%= area.getArea_name() %>"><%= area.getArea_name()  %></option>
				<%
			}
			
		}//nested if
	}//for
}//if

%>
</select>${ area_name }
</tr>
 -->
 
 <tr>
<th align="right">Enter Area
<td align="center"><input type="text" placeholder="Enter Area" name="area_name" id="text3"  value="${AreaBeanObj.area_name}" >
<td align="left">${ area_name }
</tr>
 
 
<tr>
<th align="right"> Enter ZipCode
<td align="center"><input type="text" placeholder="Enter Zipcode" name="zipcode" id="text3" value="${AreaBeanObj.zipcode}"> 
<td align="left">${ zipcode }
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