<%@page import="Mindeft.CFMS.dao.user_type_Dao"%>
<%@page import="Mindeft.CFMS.bean.user_typeBean"%>
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
    color: black;
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

<form action="user_type_update" name="user_type_edit_form" id="user_type_edit_form">
<input type="hidden" name="user_type_id" id="user_type_id" value="${user_typeBeanObj.user_type_id}">
<table>


<!--
<tr>
<th> Select User:
<td> 
-->
<!-- 
<select name="user_type"> 
<option value="">----Select Any User----</option>
<option value="Admin">Admin</option>
<option value="civilian">civilian</option>
<option value="Normal">Normal</option>
</select>  ${ user_type }
</tr>
 -->
 <!--  
 <select name="user_type" id="text3">
 <%
List<user_typeBean> user_typelist=new user_type_Dao().select();
user_typeBean user_typeObj=(user_typeBean)request.getAttribute("user_typeBeanObj");
String user_typeBeanObj_type=user_typeObj.getUser_type();
String user_typelist_type=new String();


if(user_typelist!=null)
{
	for(int i=0;i<user_typelist.size();i++)
	{	
		user_typeBean user_type=user_typelist.get(i);
		
		if(user_type!=null)
		{
			user_typelist_type=user_type.getUser_type();
				if(user_typeBeanObj_type.equals(user_typelist_type))
				{
			
					%>
					<option value="<%= user_type.getUser_type()  %>" selected="selected"><%= user_type.getUser_type()  %></option>

					<% 
				}
				else
				{
					%>
					<option value="<%= user_type.getUser_type()  %>"><%= user_type.getUser_type()  %></option>

					<% 					
				}
		}//nested if
	}//for
}//if

%>
 </select>
 <td>${ user_type }
-->

<tr>
<th>Enter User Type::
<td><input type="text" name="user_type" id="text3" value="${user_typeBeanObj.user_type}">
<td>${ user_type }
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