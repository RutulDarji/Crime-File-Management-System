<%@page import="Mindeft.CFMS.bean.userBean"%>
<%@page import="Mindeft.CFMS.dao.security_questionDao"%>
<%@page import="Mindeft.CFMS.bean.security_questionBean"%>
<%@page import="Mindeft.CFMS.bean.cityBean"%>
<%@page import="java.util.List"%>
<%@page import="Mindeft.CFMS.dao.cityDao"%>
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


</style>
</head>
<%

userBean userBeanObj=(userBean)request.getAttribute("userBeanObj");

%>

<body>
<%@include file='myheader1.jsp'%>
<br><br><br><br><br>
<center>

<form action="user_update" name="user_edit_form" id="user_edit_form" method="post" enctype="multipart/form-data">
<input type="hidden" name="user_id" id="user_id" value="${userBeanObj.user_id}">
<input type="hidden" name="isActive" id="isActive" value="${userBeanObj.isActive}">
<input type="hidden" name="user_type_id" id="user_type_id" value="${userBeanObj.user_type_id}">

<table>

<tr>
<th>Enter FirstName::
<td><input type="text" placeholder="Enter Firstname" name="user_firstname" id="user_firstname" value="${userBeanObj.user_firstname}"> ${user_firstname}
</tr>

<tr>
<th>Enter MiddleName::
<td><input type="text" placeholder="Enter Middlename" name="user_middlename" id="user_middlename" value="${userBeanObj.user_middlename}"> ${ user_middlename }
</tr>

<tr>
<th>Enter LastName::
<td><input type="text" placeholder="Enter Lastname" name="user_lastname" id="user_lastname"  value="${userBeanObj.user_lastname}">${ user_lastname }
</tr>

<tr>
<th>Enter Email::
<td><input type="text" placeholder="Enter Email" name="email" id="email" value="${userBeanObj.email}">${ email }
</tr>

<tr>
<th>Enter Password::
<td><input type="password" placeholder="Enter Password" name="password" id="password" value="${userBeanObj.password}">${ password }
</tr>

<tr>
<th>Gender::
<td>
<% 
if(userBeanObj.getGender().equals("male"))
{
	%>
		<input type="radio" name="gender" id="gender" value="male" checked="checked">male
		<input type="radio" name="gender" id="gender" value="female">female ${ gender }
	<% 
}
else
{
	%>
	<input type="radio" name="gender" id="gender" value="male">male
	<input type="radio" name="gender" id="gender" value="female" checked="checked">female ${ gender }
<% 	
}

%>
</tr>

<tr>
<th>Enter Mobile Number::
<td><input type="text" placeholder="Enter mobile number" name="mobile" id="mobile" value="${userBeanObj.mobile}">${ mobile }
</tr>

<tr>
<th>Enter Address::
<td><textarea row="3" placeholder="Enter Address" name="address" id="address"><%= userBeanObj.getAddress() %></textarea>${ address }
</tr>

<tr>
<th> Select City:
<td> 
<select name="city_id"> 
<%
String userbeanObj_city_id=userBeanObj.getCity_id();
List<cityBean> citylist=new cityDao().select();

if(citylist!=null)
{
	for(int i=0;i<citylist.size();i++)
	{	
		cityBean city=citylist.get(i);
		String citylist_city_id=city.getCity_id();
		
		if(city!=null)
		{
			if(userbeanObj_city_id.equals(citylist_city_id))
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
</select> ${ city_id }
</tr>

<tr>
<th>Enter Date Of Birth::
<td><input type="date" name="date_of_birth" id="date_of_birth">${ date_of_birth }
</tr>

<tr>
<th> Select Security Question:
<td> 
<select name="security_question_id"> 
<%
String userbeanObj_que=userBeanObj.getSecurity_question_id();
List<security_questionBean> security_questionlist=new security_questionDao().select();

if(security_questionlist!=null)
{
	for(int i=0;i<security_questionlist.size();i++)
	{	
		security_questionBean security_question=security_questionlist.get(i);
		String security_questionlist_que=security_question.getSecurity_question_id();
		
		if(security_question!=null)
		{
			if(userbeanObj_que.equals(security_questionlist_que))
			{
				%>
				<option value="<%= security_question.getSecurity_question_id() %>" selected="selected"><%= security_question.getSecurity_question_type()  %></option>
				<%
			}
			else
			{
				%>
				<option value="<%= security_question.getSecurity_question_id() %>"><%= security_question.getSecurity_question_type()  %></option>
				<%
			}
		}//nested if
	}//for
}//if

%>
</select> ${ security_question_id }
</tr>

<tr>
<th>Security Answer::
<td><input type="text" placeholder="Enter answer" name="security_question_answer" id="security_question_answer" value="${userBeanObj.security_question_answer}">${ security_question_answer }
</tr>


<tr>
<th>Image :
<td><input type="file" name="user_image" id="user_image">${ user_image }
</tr>

<tr>
<td><input type="submit" name="btnsubmit" id="btnsubmit" value="Submit" class="button button4">
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