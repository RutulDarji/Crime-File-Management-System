<%@page import="java.util.ArrayList"%>
<%@page import="Mindeft.CFMS.dao.criminalDao"%>
<%@page import="Mindeft.CFMS.bean.criminalBean"%>
<%@page import="Mindeft.CFMS.dao.missing_personDao"%>
<%@page import="Mindeft.CFMS.bean.missing_personBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Missing Person View</title>

<link href="layout/styles/layout.css" rel="stylesheet" type="text/css" media="all">
</head>
<style>

td,tr
{
	font-size:20px;
}

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
<div class="wrapper row2 bgded" style="background-image:url('../images/demo/backgrounds/2.png');position:absolute;top:170px;">
	<div class="overlay" style="background-color:rgb(39, 39, 39)">
		<div id="breadcrumb">
		<ul>
			<li><a>Home</a></li>
			<li><a>Services</a></li>
			<li><a>Missing Person</a></li>
			<li><a>Missing Person View</a></li>	
		</ul>
		
		</div>
	</div>

</div>



<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<br><br><br><br><br><br><br><br><br><br>
<div class="wrapper row3">
  <main id="container" class="clear"> 
    <!-- container body -->
    <!-- ################################################################################################ -->
    <div id="gallery">
      
<form action="" id="missing_person_list_form" name="missing_person_list_form">
<input type="hidden" name="missing_person_id" id="missing_person_id">
<center>
<!--  
<tr>
<td>Missing Person id</td>
<td>Missing Person FirstName</td>
<td>Missing Person MiddleName</td>
<td>Missing Person lastName</td>

<td>Missing Person Gender</td>
<td>Missing Person Age</td>
<td>Reference Name</td>
<td>Reference Number</td>

<td>Reference Relation</td>
<td>Area id</td>
<td>Missing Person Detail</td>
<td>Missing Date</td>
<td>Image</td>
</tr>
-->

<% List<missing_personBean> missing_personBeanlist=(ArrayList)request.getAttribute("missing_personBeanlist"); 
if(missing_personBeanlist!=null)
{
	for(int i=0;i<missing_personBeanlist.size();i++)
	{
		missing_personBean missing_person=missing_personBeanlist.get(i);
		%>
		
		<img style="height:220px; width:220px;  alt="NO IMAGE FOUND TO DISPLAY" src="./upload/missing_person/<%=missing_person.getMissing_person_image()%>"></td>
		<br><br><br>
		<table>
		
		 <!--  
		 <tr>
		 <td>Missing Person id</td>
		 <td><%= missing_person.getMissing_person_id() %>
		 </tr>
		 -->
		 
		 <tr>
		 <td align="center">Missing Person FirstName</td>		 
		 <td align="center"><%= missing_person.getMissing_person_firstname() %>
		 </tr>
		 
		 <tr>
		 <td  align="center">Missing Person MiddleName</td>
		 <td align="center"><%= missing_person.getMissing_person_middlename()%>
		 </tr>
		 
		 <tr>
		 <td  align="center">Missing Person LastName</td>
		 <td align="center"><%= missing_person.getMissing_person_lastname() %>
		 </tr>
		 
		 <tr>
		 <td  align="center">Missing Person Gender</td>
		 <td align="center"><%= missing_person.getMissing_person_gender() %>
		 </tr>
		 
		 <tr>
		 <td  align="center">Missing Person Age</td>
		 <td align="center"><%= missing_person.getMissing_person_age() %>
		 </tr>
		 
		 <tr>
		 <td  align="center">ReferencePerson Name</td>
		 <td align="center"><%= missing_person.getReferenceperson_name() %>
		 </tr>
		 
		 <tr>
		 <td  align="center">ReferencePerson Number</td>
		 <td align="center"><%= missing_person.getReferenceperson_number() %>
		 </tr>
		 
		 <tr>
		 <td  align="center">ReferencePerson Relation</td>
		 <td align="center"><%= missing_person.getReferenceperson_relation() %>
		 </tr>
		 
		 <!--  <tr>
		 <td  align="center">Area ID</td>
		 <td align="center"><%= missing_person.getArea_id() %>
		 </tr>-->
		 
		 <tr>
		 <td  align="center">Missing Person Details</td>
		 <td align="center"><%= missing_person.getMissing_person_details() %>
		 </tr>
		 
		 <tr>
		 <td  align="center">Missing Person Date</td>
		 <td align="center"><%= missing_person.getMissing_person_date() %>
		</tr>
		
		<tr>
		<td>
		</tr>
		
		<tr>
		<td>
		</tr>
		
		<tr>
		<td>
		</tr>
		
		
		<tr>
		<td colspan="2" align="center"><a href="missing_person_view_report?missing_person_id=<%= missing_person.getMissing_person_id() %>">Get Report</a>
		</tr>
			   
<% }%>
	
	
	<% 
}
%>



</table>
</form>
</center>  
        
      
    </div>
    <!-- ################################################################################################ -->
    <!-- ################################################################################################ -->
    
    <!-- ################################################################################################ -->
    <!-- / container body -->
    <div class="clear"></div>
  </main>
</div>
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- Footer Start  -->
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