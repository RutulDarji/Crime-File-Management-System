<%@page import="java.util.ArrayList"%>
<%@page import="Mindeft.CFMS.bean.AreaBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Area view</title>
<style>

table {
    border-collapse: collapse;
	width:60%;
}
th
{
    padding: 15px;
     color:white;
   
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
font
{
	color:white;
	font-size:20px;

}

</style>

<body>
<%@include file='myheader1.jsp'%>
<br><br><br><br><br>
<center>
<font>
<form action="" id="area_list_form" name="area_list_form">
<input type="hidden" name="area_id" id="area_id">

<table>
<!-- 
<tr>
<td>Area id</td>
<td>Area Name</td>
<td>Zipcode</td>
<td>City ID</td>

</tr>
 -->
 
<% List<AreaBean> AreaBeanlist=(ArrayList)request.getAttribute("AreaBeanlist"); 
if(AreaBeanlist!=null)
{
	for(int i=0;i<AreaBeanlist.size();i++)
	{
		AreaBean AreaBeanObj=AreaBeanlist.get(i);
		%>
		
		 <tr>
		 <td>Area id</td>
		 <td><%= AreaBeanObj.getArea_id() %>
		 </tr>
		 
		 <tr>
		 <td>Area Name</td>
		 <td><%= AreaBeanObj.getArea_name()  %>
		 </tr>
		 
		 <tr>
		 <td>Zipcode</td>
		 <td><%= AreaBeanObj.getZipcode()  %>
		 </tr>
		 
		 <tr>
		 <td>City ID</td>
		 <td><%= AreaBeanObj.getCity_id()  %>
		 
		 </tr>
		   
<% }%>
	
	
	<% 
}
%>


</table>

</form>
</font>
</center>
<br><br><br><br><br><br><br><br>
<br><br><br>
<br><br>


<%@include file='myFooter.html'%>



</body>
</html>