<%@page import="java.util.List"%>
<%@page import="Mindeft.CFMS.dao.crimeDao"%>
<%@page import="Mindeft.CFMS.bean.crimeBean"%>
<%@page import="Mindeft.CFMS.bean.police_station_Bean"%>
<%@page import="Mindeft.CFMS.dao.police_stationDao"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Complain</title>
<meta charset="utf-8">
<link href="layout/styles/layout.css" rel="stylesheet" type="text/css" media="all">  
<link href="layout/styles/style.css" rel="stylesheet" type="text/css" media="all">
</head>
<style>
table{
	border-collapse:collapse;
	}
th,td{
 border-bottom: 0px solid #ddd;
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
</style>




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
    <!-- ##############l################################################################################## -->
    <div id="intro">
	<h2 class=nonspace font-x3">Complain</h2>
	
	<form action="user_complain_insert" name="complain_table_form" id="complain_table_form">
<center>
<table>

<input type="hidden" name="user_id" id="user_id" value="${ session_userBeanObj.user_id }">

<tr>
<th>Select Crime ::
<td>
<select name="crime_id" id="text3">
<%
HttpSession crimeObj=request.getSession();
crimeBean crimeBeanObj=(crimeBean)crimeObj.getAttribute("crimeObj");
String crimeBeanObj_crime_details=crimeBeanObj.getCrime_details();
System.out.print("Pass Crime  is"+crimeBeanObj_crime_details);

List<crimeBean> crimeBeanlist=new crimeDao().select();
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
<td>${ crime_id }
</tr>



<tr>
<th>Select Police station ::
<td>
<select name="police_station_id" id="text3">
<option value="">---Select Any---</option>
<%
List<police_station_Bean> police_stationlist=new police_stationDao().select();
String crimeBeanObj_area=crimeBeanObj.getArea_id();

if(police_stationlist!=null)
{
	for(int i=0;i<police_stationlist.size();i++)
	{	
		police_station_Bean police_station=police_stationlist.get(i);
		String police_station_area=police_station.getArea_id();	
		
		if(police_station!=null)
		{
			if(crimeBeanObj_area.equals(police_station_area))
			{	
				%>
				<option value="<%= police_station.getPolice_station_id() %>"><%= police_station.getPolice_station_name()  %></option>
				<%
			}
		}//nested if
	}//for
}//if
%>

</select> 
<td>${ police_station_id }
</tr>

<!--  
<tr>
<th>Complain Date :
<td><input type="date" id="text3" name="complain_date" >
<td>${ complain_date }
</tr> 
-->

<tr>
<th>Complain Details :
<td><textarea row="3" id="text3" placeholder="Enter Details" name="complain_details" > ${ complainBeanObj.complain_details } </textarea>
<td>${ complain_details }
</tr>

<tr>
<td colspan="2"><center><input type="submit" name="btnsubmit" id="btnsubmit" value="Next" class="button button4"></center>
</tr>

</table>
</form>
</center>
	
	
	
	
	
	
	
	<!-- 34i3858346873658348756475687465876756384658374 -->
	
	
	
	
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