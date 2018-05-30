<%@page import="Mindeft.CFMS.dao.crimeDao"%>
<%@page import="Mindeft.CFMS.bean.crimeBean"%>
<%@page import="Mindeft.CFMS.dao.security_questionDao"%>
<%@page import="Mindeft.CFMS.bean.security_questionBean"%>
<%@page import="Mindeft.CFMS.dao.cityDao"%>
<%@page import="Mindeft.CFMS.bean.cityBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>CrimeAccuse</title>

<meta charset="utf-8">
<link href="layout/styles/layout.css" rel="stylesheet" type="text/css" media="all">  
<link href="layout/styles/style.css" rel="stylesheet" type="text/css" media="all">
<script type="text/javascript">

function accuse()
{
		
	var f=document.crime_accuse_form;
	
	f.action="user_crime_add_another_accuse";
	
	f.submit();
	
}

</script>
<style>

table{
	border-collapse:collapse;
	}
	


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
#text2
{
	background: #40413c;
    color: #a2a9a9;
    width: 100px;
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
	left:690px;
	top:520px;

}
#abc1
{
	-webkit-appearance:radio;
	position:absolute;
	left:780px;
	top:520px;

}

#text2:hover
{

box-shadow: 12px 13px 0px rgba(204, 211, 51, 0.38),
-11px -14px 0px rgba(241, 96, 0, 0.28),
18px -24px 0px rgba(0, 0, 0, 0.34),
33px -6px 0px rgba(39, 74, 214, 0.28);
}
#text3:hover
{

box-shadow: 12px 13px 0px rgba(204, 211, 51, 0.38),
-11px -14px 0px rgba(241, 96, 0, 0.28),
18px -24px 0px rgba(0, 0, 0, 0.34),
33px -6px 0px rgba(39, 74, 214, 0.28);
}
.button {
  display: inline-block;
  border-radius: 4px;
  background-color: #f4511e;
  border: none;
  color: lightgray;
  text-align: center;
  font-size: 16px;
  padding: 20px;
  width: 300px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 5px;
   box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.19);
}

.button span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

.button span:after {
  content: '\00bb';
  position: absolute;
  opacity: 0;
  top: 0;
  right: -20px;
  transition: 0.5s;
}

.button:hover span {
  padding-right: 25px;
}

.button:hover span:after {
  opacity: 1;
  right: 0;
}
.button4 {
        background-color: #40413c;
    color: darkgrey;
	border-radius: 12px;
	font-size: 16px;
    border: 2px solid #2c3338;
}

.button4:hover {background-color: gray;}
#abc
{
	-webkit-appearance:radio;
	position:absolute;
	left:690px;
	top:470px;

}
#abc1
{
	-webkit-appearance:radio;
	position:absolute;
	left:780px;
	top:470px;

}

</style>


</head>

<body id="top">
<%@include file='myheader_user.jsp'%>
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<div class="wrapper row0" style="border-bottom-color:#272727;">
 
  <div id="topbar" class="clear">
	
    <!-- ################################################################################################ -->
    <div class="fl_left">
	<img src="images/logo/56295.jpg" style=" height:150px; width:150px; position:absolute;left:0px;border-radius:12px" >
			<!--<h1><b>Crime File Management System</b></h1>-->
    </div>
    <div class="fl_right">
	
      <!--<form class="clear" method="post" action="#">
        <fieldset>
          <legend>Search:</legend>
          <input type="text" name="sitesearch" id="sitesearch" value="">
          <button class="fa fa-search" type="submit" value="submit"><em>Search</em></button>
        </fieldset>
      </form>-->
	  
    </div>
    <!-- ################################################################################################ -->
  </div>
</div>
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<div class="wrapper row1" style="position:absolute;left:150px;top:60px;width:1348px;">
  <header id="header" class="clear"> 
    <!-- ################################################################################################ -->
    <div id="logo" class="fl_left">
      <h1 style="position:absolute;left:15px;">Crime File Management System</h1>
    </div>
    <!-- ################################################################################################ -->
    <nav id="mainav" class="fl_right">
      <ul class="clear">
        <li class="active"><a href="home_page_after.jsp">Home</a></li>
        <li><a class="drop" href="#">Services</a>
          <ul>
           <li><a href="user_missing_person_page.jsp">Missing Person</a></li>
            <li><a href="user_mostwanted_person.jsp">Most Wanted Person</a></li>
            <li><a href="user_crime_page.jsp">Complain</a></li>
            <li><a href="user_criminal_person.jsp">Criminal </a></li>
            <li><a href="user_query_table.jsp">Ask Query</a></li>
            <li><a href="user_complain_list.jsp">Complain List</a></li>
		</ul>
        </li>
        <!-- <input type="hidden" name="user_id" id="user_id" value="${ session_userBeanObj.user_id}"> -->
        <li><a href="user_police_station_search.jsp">Police Station</a></li>
        <li><a href="user_profile_page.jsp">Profile</a></li>
        <li><a href="about_us.jsp">About Us</a></li>
      	<li><a href="logout">Logout</a></li>
      </ul>
    </nav>
    <!-- ################################################################################################ -->
  </header>
</div>
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<br><br><br>
<div class="wrapper row2 bgded" style="background-image:url('images/demo/backgrounds/Crime Scene Wallpaper - 9186.jpg')">
  <div class="overlay"> 
    <!-- ################################################################################################ -->
    <div id="intro">

<h2 class=nonspace font-x3">Crime Accuse</h2>
<form action="user_crime_accuse_insert" name="crime_accuse_form" id="crime_accuse_form1" method="post" enctype="multipart/form-data">
<center>
<table>

<tr>
<th>Select Crime ::
<td>
<select name="crime_id" id="text3">

<%
List<crimeBean> crimeBeanlist=new crimeDao().select();
HttpSession crimeObj=request.getSession();
crimeBean crimeBeanObj=(crimeBean)crimeObj.getAttribute("crimeObj");
String crimeBeanObj_crime_details=crimeBeanObj.getCrime_details();

if(crimeBeanlist!=null)
{
	for(int i=0;i<crimeBeanlist.size();i++)
	{	
	
		crimeBean crime=crimeBeanlist.get(i);
		String	crimeBeanlist_crime_details=crime.getCrime_details();	
		
		if(crime!=null)
		{
			if(crimeBeanObj_crime_details.equals(crimeBeanlist_crime_details))
			{
				%>
				<option value="<%= crime.getCrime_id() %>"><%= crime.getCrime_details()  %></option>
				<%
			}
		}//nested if
	}//for
}//if
%>

</select>
<td> ${ crime_id }
</tr>

<tr>
<th>Enter FirstName::
<td><input type="text" placeholder="enter Firstname" name="crime_accuse_firstname" id="text3" value="${crime_accuseBeanObj.crime_accuse_firstname }"> 
<td>${crime_accuse_firstname}
</tr>

<tr>
<th>Enter MiddleName::
<td><input type="text" placeholder="enter Middlename" name="crime_accuse_middlename" id="text3" value="${crime_accuseBeanObj.crime_accuse_middlename }"> 
<td>${ crime_accuse_middlename }
</tr>

<tr>
<th>Enter LastName::
<td><input type="text" placeholder="enter Lastname" name="crime_accuse_lastname" id="text3" value="${crime_accuseBeanObj.crime_accuse_lastname }">
<td>${ crime_accuse_lastname }
</tr>

<tr>
<th>Gender::
<td>
<input type="radio" name="crime_accuse_gender" id="abc" value="male"><font color="white" style="position:absolute;left:720px;top:470px;">male</font>
<input type="radio" name="crime_accuse_gender" id="abc1" value="female"><font color="white" style="position:absolute;left:810px;top:470px;">female </font>
<td>${ crime_accuse_gender }
</tr>

<tr>
<th>Age::
<td><input type="text" placeholder="enter Age" name="crime_accuse_age" id="text3" value="${crime_accuseBeanObj.crime_accuse_age }">
<td>${ crime_accuse_age }
</tr>

<tr>
<th>Number::
<td><input type="text" placeholder="enter Number" name="crime_accuse_number" id="text3" value="${crime_accuseBeanObj.crime_accuse_number }">
<td>${ crime_accuse_number }
</tr>

<tr>
<th>Address:
<td><textarea row="3"  placeholder="enter Address" name="crime_accuse_address" id="text3">${crime_accuseBeanObj.crime_accuse_address }</textarea>
<td>${ crime_accuse_address }
</tr>

<tr>
<th>Image :
<td><input type="file" name="crime_accuse_image" id="text3">
<td>${ crime_accuse_image }
</tr>

<tr>
<td colspan="3">
<input type="submit" name="btnsubmit" id="btnsubmit" value="SUBMIT AND NEXT" class="button button4"> &nbsp;&nbsp;&nbsp;
<input type="button" name="btnadd"  value="SUBMIT AND ADD OTHER ACCUSE" class="button button4" onclick="accuse();"> &nbsp;&nbsp;&nbsp;
</tr>

<tr>
<td colspan="3">
<center>
<a href="user_crime_witness.jsp"><input type="button" name="btnadd"  value="SKIP & NEXT-->" class="button button4"></a> &nbsp;&nbsp;&nbsp;
</center>
</tr>



</table>
</form>

</center>


    </div>
    <!-- ################################################################################################ -->
  </div>
</div>

<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->


<div class="wrapper row4">
  <footer id="footer" class="clear"> 
    <!-- ################################################################################################ -->
    <div class="one_quarter first">
      <h6 class="title">Reach US</h6>
      <address class="btmspace-30">
      Minddeft Technologies PVT LTD.<br>
      B2/1209,Palladium,Behind Divya Bhaskar Press,Corporate Road Prahalad Nagar<br>
      Ahmedabad<br>
      380015
      </address>
      <ul class="nospace">
        <li class="btmspace-10"><span class="fa fa-clock-o"></span> Mon. - Fri. 9:00am - 7:00pm</li>
        <li class="btmspace-10"><span class="fa fa-phone"></span> +91-79-40192627 </li>
        <li><span class="fa fa-envelope-o"></span> info@CFMS.com</li>
      </ul>
    </div>
    <div class="one_quarter">
      <h6 class="title">Quick Links</h6>
      <ul class="nospace linklist">
        <li><a href="home_page_after.jsp">Home Page</a></li>
        <li><a href="user_crime_page.jsp">Complain</a></li>
        <li><a href="user_criminal_person.jsp">Criminal</a></li>
        <li><a href="user_missing_person_page.jsp">Missing Person</a></li>
        <li><a href="user_mostwanted_person.jsp">MostWanted Person</a></li>
        <li><a href="user_query_table.jsp">Ask Query</a></li>
        <li><a href="user_complain_list.jsp">Complain List</a></li>
        <li><a href="user_police_station_search.jsp">Police Station</a></li>
        <li><a href="about_us.jsp">About Us</a></li>
       </ul>
    </div>
    <div class="one_quarter">
      <h6 class="title">Services</h6>
      <article>
        <ul>
        <li>Application Enhancement &amp; Maintenance Services</li>
        <li>Application Integration Services</li>
        <li>Custom Application Development</li>
        <li>Legacy Application Migration And Modernization</li>
        <li>CMS solutions and Customization's</li>
        <li>Web Application Design And Development</li>
        
        </ul>

               
      </article>
    </div>
    <div class="one_quarter">
    </div>
    <!-- ################################################################################################ -->
  </footer>
</div>


<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<div class="wrapper row6">
  <div id="copyright" class="clear"> 
    <!-- ################################################################################################ -->
    <p class="fl_left">Copyright &copy; 2014 - All Rights Reserved - <a href="#">Domain Name</a></p>
    <!-- ################################################################################################ -->
  </div>
</div>



</body>
</html>