<%@page import="java.util.ArrayList"%>
<%@page import="Mindeft.CFMS.bean.AreaBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Area List</title>
<meta charset="utf-8">
    <title>Table</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
    <meta name="author" content="Muhammad Usman">

    <!-- The styles -->
    <link id="bs-css" href="css/bootstrap-cerulean.min.css" rel="stylesheet">

    <link href="css/charisma-app.css" rel="stylesheet" type="text/css" media="all">
    <link href='bower_components/fullcalendar/dist/fullcalendar.css' rel='stylesheet' type="text/css" media="all">
    <link href='bower_components/fullcalendar/dist/fullcalendar.print.css' rel='stylesheet'type="text/css" media="all">
    <link href='bower_components/chosen/chosen.min.css' rel='stylesheet' type="text/css" media="all">
    <link href='bower_components/colorbox/example3/colorbox.css' rel='stylesheet' type="text/css" media="all">
    <link href='bower_components/responsive-tables/responsive-tables.css' rel='stylesheet' type="text/css" media="all">
    <link href='bower_components/bootstrap-tour/build/css/bootstrap-tour.min.css' rel='stylesheet' type="text/css" media="all">
    <link href='css/jquery.noty.css' rel='stylesheet' type="text/css" media="all">
    <link href='css/noty_theme_default.css' rel='stylesheet' type="text/css" media="all">
    <link href='css/elfinder.min.css' rel='stylesheet' type="text/css" media="all">
    <link href='css/elfinder.theme.css' rel='stylesheet' type="text/css" media="all">
    <link href='css/jquery.iphone.toggle.css' rel='stylesheet' type="text/css" media="all">
    <link href='css/uploadify.css' rel='stylesheet' type="text/css" media="all">
    <link href='css/animate.min.css' rel='stylesheet' type="text/css" media="all">

    <!-- jQuery -->
    <script src="WebContent/bower_components/jquery/jquery.min.js"></script>

    <!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- The fav icon -->
    <link rel="shortcut icon" href="img/favicon.ico">


</head>
<style>

body
{
background-color: black;
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

.button5 {
    background-color: #4CAF50;
    border: 2px solid green;
     
}

.button4:hover {background-color: #e7e7e7;}

.button5:hover {background-color: #e7e7e7;}


</style>

<body>
<%@include file='myheader1.jsp'%>
<br><br><br><br><br>
<center>

<center>
<a href="area_table_jsp.jsp"> ADD </a>
</center>


<form action="" id="area_list_form" name="area_list_form">
<input type="hidden" name="area_id" id="area_id">
<table>
<tr>
<td>Area id</td>
<td>Area Name</td>
<td>Zipcode</td>
<td>City ID</td>
<td>Action</td>
</tr>

<% List<AreaBean> AreaBeanlist=(ArrayList)request.getAttribute("AreaBeanlist"); 
if(AreaBeanlist!=null)
{
	for(int i=0;i<AreaBeanlist.size();i++)
	{
		AreaBean AreaBeanObj=AreaBeanlist.get(i);
		%>
		
		 <tr>
		 <td><%= AreaBeanObj.getArea_id() %>
		 <td><%= AreaBeanObj.getArea_name()  %>
		 <td><%= AreaBeanObj.getZipcode()  %>
		 <td><%= AreaBeanObj.getCity_id()  %>
		 
		 <td><a href="area_delete?area_id= <%= AreaBeanObj.getArea_id() %>">Delete</a> &nbsp;&nbsp;&nbsp; <a href="area_edit?area_id= <%= AreaBeanObj.getArea_id() %>">Edit</a>&nbsp;&nbsp;&nbsp;<a href="area_view?area_id= <%= AreaBeanObj.getArea_id() %>">View</a>	
		 
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