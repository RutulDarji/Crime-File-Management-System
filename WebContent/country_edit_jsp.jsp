<%@page import="Mindeft.CFMS.dao.countryDao"%>
<%@page import="Mindeft.CFMS.bean.countryBean"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
function selectcountry(ch)
{
	alert("hello");
	var f=document.country_update_form;
	alert("hello" + ch);
	var element = document.getElementById('country_name');
	for (var i = 0; i < element.options.length; i++) {
        if (element.options[i].text== ch) {
        	element.options[i].selected = true;
     		break;
        }
    }
}

</script>

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

<form action="country_update" name="country_update_form" id="country_update_form">
<input type="hidden" name="country_id" id="country_id" value="${countryBeanObj.country_id}">

<table>

<!--  
<tr>
<th> Select Country:
<td> 
<select name="country_name" id="country_name"> 
<option value="">----Select Any Country----</option>
<option value="India">India</option>
<option value="China">China</option>
<option value="Australia">Australia</option>
<option value="Pakistan">Pakistan</option>
<option value="Canada">Canada</option>
</select>${ country_name }
</tr>

-->

<!--  
<tr>
<th> Select Country:
<td> 
<select name="country_name" id="country_name">

<%
List<countryBean> countrylist=new countryDao().select();
countryBean countryBeanObj=(countryBean)request.getAttribute("countryBeanObj");
String countryBeanObj_country=countryBeanObj.getCountry_name();
String countrylist_country=new String();
if(countrylist!=null)
{
	for(int i=0;i<countrylist.size();i++)
	{	
		countryBean country=countrylist.get(i);
		
		if(country!=null)
		{
			countrylist_country=country.getCountry_name();
				if(countryBeanObj_country.equals(countrylist_country))
				{
			
					%>
					<option value="<%= country.getCountry_name()  %>" selected="selected"><%= country.getCountry_name()  %></option>

					<% 
				}
				else
				{
					%>
					<option value="<%= country.getCountry_name()  %>"><%= country.getCountry_name()  %></option>

					<% 					
				}
		}//nested if
	}//for
}//if

%>
</select>${ country_name }
</tr>

-->

<tr>
<th>Enter Country :
<td><input type="text" placeholder="Enter Country" name="country_name" id="text3" value="${countryBeanObj.country_name}">
<td> ${ country_name }
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