<%@page import="Mindeft.CFMS.bean.security_questionBean"%>
<%@page import="Mindeft.CFMS.bean.stateBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Mindeft.CFMS.bean.countryBean"%>
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

<form action="" id="" name="">
<input type="hidden" name="security_question_id" id="security_question_id">
<table border="1">
<!--  
<tr>
<td>Security Question</td>
<td>Security Question Type</td>
</tr>
-->

<% List<security_questionBean> security_question_list=(ArrayList)request.getAttribute("security_question_list"); 
if(security_question_list!=null)
{
	for(int i=0;i<security_question_list.size();i++)
	{
		security_questionBean security_question=security_question_list.get(i);
		%>
		
		 <tr>
		 <td>Security Question ID</td>
		 <td><%= security_question.getSecurity_question_id() %>
		 </tr>
		 
		 <tr>
		 <td>Security Question</td>
		 <td><%= security_question.getSecurity_question_type()  %>
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