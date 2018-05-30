<%@page import="Mindeft.CFMS.dao.missing_personDao"%>
<%@page import="Mindeft.CFMS.bean.missing_personBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Missing Person</title>
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
	
      
	  
    </div>
    <!-- ################################################################################################ -->
  </div>
</div>
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<div class="wrapper row1" style="position:absolute;left:150px;top:60px;width:width:1348px;">

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
			<li><a>MissingPerson</a></li>	
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
      <figure>
        <header class="heading">Missing Person </header>
        <ul class="nospace clear">
        <form action="" id="missing_person_list_form" name="missing_person_list_form">
		<input type="hidden" name="missing_person_id" id="missing_person_id">
        
        <%
        List<missing_personBean> missing_personBeanlist=new missing_personDao().select(); 
        
        if(missing_personBeanlist!=null)
        {
        	for(int i=0;i<missing_personBeanlist.size();i++)
        	{
        		missing_personBean missing_person=missing_personBeanlist.get(i);
        		if(i%4==0)
    			{
        			%>
        		 	<li class="one_quarter first"><a href="user_missing_person_view?missing_person_id=<%= missing_person.getMissing_person_id() %>"><img alt="NO IMAGE FOUND TO DISPLAY" src="./upload/missing_person/<%=missing_person.getMissing_person_image()%>" style="height:220px; width:220px; "></a><br><a href="user_missing_person_view?missing_person_id=<%= missing_person.getMissing_person_id() %>"><p><center> <%= missing_person.getMissing_person_firstname() + " " +missing_person.getMissing_person_middlename() + " " +missing_person.getMissing_person_lastname() %> </center></p></a></li>   
        			<%
    			}
        		else
        		{
        			%>
           		 	<li class="one_quarter"><a href="user_missing_person_view?missing_person_id=<%= missing_person.getMissing_person_id() %>"><img alt="NO IMAGE FOUND TO DISPLAY" src="./upload/missing_person/<%=missing_person.getMissing_person_image()%>" style="height:220px; width:220px; "></a><br><a href="user_missing_person_view?missing_person_id=<%= missing_person.getMissing_person_id() %>"><p><center> <%= missing_person.getMissing_person_firstname() + " " +missing_person.getMissing_person_middlename() + " " +missing_person.getMissing_person_lastname() %> </center></p></a></li>   
           			<%	
        		}
        	}
         
        }
        
           %>
           
        </ul>
        </form>
        
        <!--    <li class="one_quarter first"><a href="#"><img src="C:/Users/Prithvi/Desktop/Project Work/Essential Free Website Template from OS Templates/essential/images/demo/backgrounds/Crime Scene Wallpaper - 9186.jpg" style="height:220px; width:220px; " alt=""></a><br><a href="#"><p><center> Mukesh </center></p></a></li> 
		  -->
        
        
      </figure>
    </div>
    <!-- ################################################################################################ -->
    <!-- ################################################################################################ -->
    <div class="pagination">
      <ul>
        <li><a href="#">&laquo; Previous</a></li>
        <li class="current"><a href="#">1</a></li>
        <li><a href="#">2</a></li>
        <li><a href="#">Next &raquo;</a></li>
      </ul>
    </div>
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