<%@page import="Mindeft.CFMS.dao.security_questionDao"%>
<%@page import="Mindeft.CFMS.bean.security_questionBean"%>
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


<form action="security_question_update" name="security_question_edit" id="security_question_edit">
<input type="hidden" name="security_question_id" id="security_question_id" value="${security_questionBeanObj.security_question_id}">
<table>

<!-- 
<tr>
<th>Select Security Question::
<td>
<select name="security_question_type" id="security_question_type">
<option value="">---Select Any---</option>
<option value="Which is Your Favourite Colour ?">Which is Your Favourite Colour ?</option>
<option value="Which is Your Favourite Food ?">Which is Your Favourite Food ?</option>
<option value="Which is Your Favourite Place ?">Which is Your Favourite Place ?</option>
<option value="Which is Your Favourite Game ?">Which is Your Favourite Game ?</option>
</select> ${ security_question_type }
</tr>
 -->
 
 <!--  
<tr>
<th>Select Security Question::
<td>
<select name="security_question_type" id="security_question_type">
 <%
 List<security_questionBean> security_question_list=new security_questionDao().select();
security_questionBean security_questionBeanObj=(security_questionBean)request.getAttribute("security_questionBeanObj"); 

String security_questionBeanObj_type=security_questionBeanObj.getSecurity_question_type();
String security_question_list_type=new String(); 

if(security_question_list!=null)
{
	for(int i=0;i<security_question_list.size();i++)
	{	
		security_questionBean security_question=security_question_list.get(i);
		
		if(security_question!=null)
		{
			security_question_list_type=security_question.getSecurity_question_type();
				if(security_questionBeanObj_type.equals(security_question_list_type))
				{
			
					%>
					<option value="<%= security_question.getSecurity_question_type()  %>" selected="selected"><%= security_question.getSecurity_question_type()  %></option>

					<% 
				}
				else
				{
					%>
					<option value="<%= security_question.getSecurity_question_type()  %>"><%= security_question.getSecurity_question_type()  %></option>

					<% 					
				}
		}//nested if
	}//for
}//if

%> 
</select> ${ security_question_type }
</tr> 
-->

<tr>
<th>Enter Security Question:
<td><input type="text" name="security_question_type" id="text3" value="${security_questionBeanObj.security_question_type}" > 
<td>${ security_question_type }
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