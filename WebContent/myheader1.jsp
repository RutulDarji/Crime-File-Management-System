<%@page import="Mindeft.CFMS.bean.userBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
a:link, a:visited {
    background-color: #45423d;
    color: lightgray;
	padding:13px 25px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
}


a:hover, a:active {
    background-color: black;
}


font
{
	color:white;
}
</style>

</head>

<body background="images/demo/backgrounds/N8Vxb0P.jpg">

<%
//HttpSession login_session=request.getSession();
//userBean userBeanObj=(userBean)login_session.getAttribute("userBeanObj");
userBean session_userBeanObj=(userBean)session.getAttribute("session_userBeanObj");

if(session_userBeanObj!=null)
{
	System.out.print("HELLO");
}
else
{
	System.out.print("BYE");
	response.sendRedirect("login_page.jsp");
}

%>


<img src="images/logo/56295.jpg" width="180" height="180" style="border-radius:12px">

<div style="position:absolute;top:10%;left:13%;width:1080px">

<p><font color="white" size="10" > Crime File Management System </font> </p>
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
<br><br>
</div>
<div style="position:absolute;top:20%;left:12.5%;width:1350px;height:50;text-align:right;background-color: #a9a9a9"><font size="4" color="white">
<a href="index.jsp" target="_self">Home</a> <a href="logout" target="_self">Logout</a></font>
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</div>


</body>
</html>