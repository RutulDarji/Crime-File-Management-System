<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Home</title>
<meta charset="utf-8">
<link href="layout/styles/layout.css" rel="stylesheet" type="text/css" media="all">
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
        <input type="hidden" name="user_id" id="user_id" value="${ session_userBeanObj.user_id}"> 
        <li><a href="user_police_station_search.jsp">Police Station</a></li>
          <li><a href="user_profile_page.jsp">Profile</a></li>
        <!--  <li><a href="user_profile_view?user_id">Profile</a></li>-->
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
      <h2 class="nospace font-x3">Indian Penal Code 1960</h2>
      <!-- <p class="nospace font-x2">Aenean semper elementum tellus ut placerat</p>-->
      <p class="nospace btmspace-50">
      Indian Penal Code is a very important set of regulation which is very important for the system to be operated in a proper way. It is the main criminal code of India. They are various offences that are made under this law. The Indian Penal Code includes all the relevant criminal offences dealing with offences against the state, offenses for public, offences for armed forces, kidnapping, murder, and rape. It deals with offense related to religion, offences against property and it has an important section for offences for marriage, cruelty from husband or relatives, defamation and so on so forth.       
      </p>
    </div>
    <!-- ################################################################################################ -->
  </div>
</div>
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<div class="wrapper row3">
  <main id="container" class="clear"> 
    <!-- container body -->
    <!-- ################################################################################################ -->
    <div class="btmspace-50 center">
      <h2>News Fields</h2>
      <p>Current And Important News You Must Know</p>
    </div>
    <div class="clear">
      <div class="one_quarter first center">
        <div class="boxedicon"><img src="images/news_related/passport.jpg" style=" height:100px; width:100px; "></div>
        <h3>Mumbai: Man tampers with passport to hide marriage from parents, arrested</h3>
       <!--   <p>Aenean semper elementum tellus, ut placerat leo. Quisque vehicula, urna sit amet pulvinar dapibus dui leo.</p>
		-->
		<a href="user_newsfeed1_passport.jsp">Read More...</a>
   </div>
      <div class="one_quarter center">
        <div class="boxedicon"><img src="images/news_related/Cyber-Crime.jpg" style=" height:100px; width:100px; "></div>
        <h3>1,600 arrests have been made related to cyber crimes under the Information Technology Act of 2000.</h3>
        <!--  <p>Aenean semper elementum tellus, ut placerat leo. Quisque vehicula, urna sit amet pulvinar dapibus dui leo.</p>
		-->
		<a href="user_newsfeed2_cybercrime.jsp">Read More...</a>
	  </div>
      <div class="one_quarter center">
        <div class="boxedicon"><img src="images/news_related/rape-pregnant.jpg" style=" height:100px; width:100px; "></div>
        <h3>Delhi shocker! Woman gang-raped by five in flat, jumps off balcony to escape</h3>
        <!--  <p>Aenean semper elementum tellus, ut placerat leo. Quisque vehicula, urna sit amet pulvinar dapibus dui leo.</p>
		-->
		<a href="user_newsfeed3_delhi_gang.jsp">Read More...</a>
	  </div>
      <div class="one_quarter center">
        <div class="boxedicon"><img src="images/news_related/samridh.jpg" style=" height:100px; width:100px; "></div>
        <h3>Cheating case: Now, Samruddha CMD Mahesh Motewar arrested</h3>
        <!--  <p>Aenean semper elementum tellus, ut placerat leo. Quisque vehicula, urna sit amet pulvinar dapibus dui leo.</p>
		-->
		<a href="user_newsfeed4_cheating.jsp">Read More...</a>
	  </div>
    </div>
    <!-- ################################################################################################ -->
    <!-- / container body -->
    <div class="clear"></div>
  </main>
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
        <li><a href="user_police_station_search.jsp">Police Station</a></li>
        <li><a href="user_complain_list.jsp">Complain List</a></li>   
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