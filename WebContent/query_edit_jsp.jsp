<%@page import="Mindeft.CFMS.bean.queryBean"%>
<%@page import="Mindeft.CFMS.dao.query_status_Dao"%>
<%@page import="Mindeft.CFMS.bean.query_status_Bean"%>
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


<%
queryBean queryBeanObj=(queryBean)request.getAttribute("queryBeanObj");
%>
<form action="query_update" name="query_edit_form" id="query_edit_form">

<input type="hidden" name="query_id" id="query_id" value="${ queryBeanObj.query_id }">
<input type="hidden" name="query_date" id="query_date" value="${ queryBeanObj.query_date }">
<input type="hidden" name="user_id" id="user_id" value="${ queryBeanObj.user_id }">

<table>

<tr>
<th>Enter Query Details
<td><textarea row="3" placeholder="Enter Details" name="query_details" id="text3" value="${ queryBeanObj.query_details}"><%= queryBeanObj.getQuery_details()  %></textarea>
<td>${ query_details }
</tr>

 <tr>
<th>Select Query_status::
<td>
<select name="query_status_id" id="text3">
<%
List<query_status_Bean> query_statuslist=new query_status_Dao().select();
//queryBean queryBeanObj=(queryBean)request.getAttribute("queryBeanObj");
String queryBeanObj_query_statusid=queryBeanObj.getQuery_status_id();
String query_statuslist_statusid=new String();

if(query_statuslist!=null)
{
	for(int i=0;i<query_statuslist.size();i++)
	{	
		query_status_Bean query=query_statuslist.get(i);
		query_statuslist_statusid=query.getQuery_status_id()+"";
		query_statuslist_statusid=query_statuslist_statusid.trim();
		
		
			if(query!=null)
			{
				if(queryBeanObj_query_statusid.equals(query_statuslist_statusid))
				{	
			
					%>
					<option value="<%= query.getQuery_status_id()  %>" selected="selected"><%= query.getQuery_status_type()  %></option>
					<% 
				}
				else
				{
					%>
					<option value="<%= query.getQuery_status_id()  %>"><%= query.getQuery_status_type()  %></option>
					<%
				}
			
			}//nested if
		
	}//for
}//if

%>
</select>
<td>${ query_status_id }
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