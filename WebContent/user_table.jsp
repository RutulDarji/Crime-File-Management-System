<%@page import="Mindeft.CFMS.dao.countryDao"%>
<%@page import="Mindeft.CFMS.bean.countryBean"%>
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
<title>Registration</title>
<meta charset="utf-8">
<link href="layout/styles/layout.css" rel="stylesheet" type="text/css" media="all">  
<link href="layout/styles/style.css" rel="stylesheet" type="text/css" media="all">
<script type='text/javascript' src='/CrimeFileManagementSystem/dwr/interface/ajex_data_Dao.js'></script>
  <script type='text/javascript' src='/CrimeFileManagementSystem/dwr/engine.js'></script>
  <script type='text/javascript' src='/CrimeFileManagementSystem/dwr/util.js'></script>

<script type="text/javascript">

function getAjexCountry(country_id) {

	
	dwr.util.removeAllOptions("state");
	
	if(country_id==''){
	var data=[{ state_name:'-- Select --', state_id:'' }];
	dwr.util.addOptions("state",data,"state_id","state_name");
	
	}else{
		//alert(stateId);
		//document.getElementById('cityLoader').style.visibility = 'visible';
		ajex_data_Dao.getAllState(country_id,function(data){
		dwr.util.addOptions("state",data,"state_id","state_name");
		  //  document.getElementById('cityLoader').style.visibility = 'hidden';
		});
	}
}

function getAjexCity(state_id) {

	
	dwr.util.removeAllOptions("city_id");
	
	if(state_id==''){
	var data=[{ city_name:'-- Select --', city_id:'' }];
	dwr.util.addOptions("city_id",data,"city_id","city_name");
	
	}else{
		//alert(stateId);
		//document.getElementById('cityLoader').style.visibility = 'visible';
		ajex_data_Dao.getAllCity(state_id,function(data){
		dwr.util.addOptions("city_id",data,"city_id","city_name");
		  //  document.getElementById('cityLoader').style.visibility = 'hidden';
		});
	}
}

function getAjexArea(city_id) {

	
	dwr.util.removeAllOptions("area");
	
	if(city_id==''){
	var data=[{ area_name:'-- Select --', area_id:'' }];
	dwr.util.addOptions("area",data,"area_id","area_name");
	
	}else{
		//alert(stateId);
		//document.getElementById('cityLoader').style.visibility = 'visible';
		ajex_data_Dao.getAjexArea(city_id,function(data){
		dwr.util.addOptions("area",data,"area_id","area_name");
		  //  document.getElementById('cityLoader').style.visibility = 'hidden';
		});
	}
}
</script>
</head>
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
.text2
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

.text2:hover
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
        <li class="active"><a href="home_page.jsp">Home</a></li>
        
        <li><a href="#">Police Station</a></li>
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

<h2 class=nonspace font-x3">Registration</h2>
<form action="user_insert" name="user_form" id="user_form" method="post" enctype="multipart/form-data">
<table>

<tr>
<th align="right">Enter FirstName::
<td align="center"><input id="text3" type="text" placeholder="Enter Firstname" name="user_firstname" value="${ userBeanObj.user_firstname }">
<td align="left"> ${user_firstname}
</tr>

<tr>
<th  align="right">Enter MiddleName::
<td  align="center"><input id="text3" type="text" placeholder="Enter Middlename" name="user_middlename" value="${ userBeanObj.user_middlename }">
<td align="left"> ${ user_middlename }
</tr>

<tr>
<th align="right">Enter LastName::
<td align="center"><input id="text3" type="text" placeholder="Enter Lastname" name="user_lastname"  value="${ userBeanObj.user_lastname }">
<td align="left"> ${ user_lastname }
</tr>

<tr>
<th align="right">Enter Email::
<td align="center"><input id="text3" type="text" placeholder="Enter Email" name="email" value="${ userBeanObj.email }">
<td align="left"> ${ email }
</tr>



<tr>
<th align="right">Enter Password::
<td align="center"><input id="text3" type="password" placeholder="Enter Password" name="password" value="${ userBeanObj.password }">
<td align="left"> ${ password }
</tr>

<tr>
<th align="right">Gender::
<td align="center"><font color="black">
<input id="abc" type="radio" name="gender"  value="male"><font color="white" style="position:absolute;left:720px;top:520px;">male</font>
<input id="abc1" type="radio" name="gender"  value="female"><font color="white" style="position:absolute;left:810px;top:520px;">female 
<td align="left"> ${ gender }</font>
</font>
</tr>

<tr>
<th align="right">Enter Mobile Number::
<td align="center"><input id="text3" type="text" placeholder="Enter mobile number" name="mobile" value="${ userBeanObj.mobile }">
<td align="left"> ${ mobile }
</tr>

<tr>
<th align="right">Enter Address::
<td align="center"><textarea row="3" placeholder="Enter Address" name="address" id="text3">${ userBeanObj.address }</textarea>
<td align="left"> ${ address }
</tr>

<tr>
<th align="right"> Select Country:
<td align="center"> 
 <select name="country_name" class="text2" onchange="java:getAjexCountry(this.value)"> 
<option value="">--Select Any Country--</option>
<%
List<countryBean> countrylist=new countryDao().select();

if(countrylist!=null)
{
	for(int i=0;i<countrylist.size();i++)
	{	
		countryBean countryBeanObj=countrylist.get(i);
		
		if(countryBeanObj!=null)
		{
			
%>
<option value="<%= countryBeanObj.getCountry_id() %>"><%= countryBeanObj.getCountry_name()  %></option>

<% 
		}//nested if
	}//for
}//if

%>

</select> 
<td align="left">${ country_name }
</tr>

<tr>
<th align="right">Select State:
<td align="center">
<select name="state" class="text2" id="state" onchange="java:getAjexCity(this.value)">
<option value="">--Select Any State--</option>
</select>
<td align="left"> ${ state }
</tr>

<tr>
<th align="right">Select City:
<td align="center">
<select name="city_id" class="text2" id="city_id" onchange="java:getAjexArea(this.value)">
<option value="">--select any City--</option>
</select>
<td align="left">  ${ city_id }
</tr>

<!--  
<tr>
<th align="right"> Select City:
<td align="center"> 
<select name="city_id" id="text3"> 
<%
List<cityBean> citylist=new cityDao().select();

if(citylist!=null)
{
	for(int i=0;i<citylist.size();i++)
	{	
		cityBean city=citylist.get(i);
		
		if(city!=null)
		{
			%>
			<option value="<%= city.getCity_id() %>"><%= city.getCity_name()  %></option>
			<%
		}//nested if
	}//for
}//if

%>
</select>
<td align="left">  ${ city_id }
</tr>
-->

<tr>
<th align="right">Enter Date Of Birth::
<td align="center"><input id="text3" type="date" name="date_of_birth" >
<td align="left"> ${ date_of_birth }
</tr>

<tr>
<th align="right"> Select Security Question:
<td align="center"> 
<select name="security_question_id" id="text3"> 
<%
List<security_questionBean> security_questionlist=new security_questionDao().select();

if(security_questionlist!=null)
{
	for(int i=0;i<security_questionlist.size();i++)
	{	
		security_questionBean security_question=security_questionlist.get(i);
		
		if(security_question!=null)
		{
			%>
			<option value="<%= security_question.getSecurity_question_id() %>"><%= security_question.getSecurity_question_type()  %></option>
			<%
		}//nested if
	}//for
}//if

%>
</select>
<td align="left">  ${ security_question_id }
</tr>

<tr>
<th align="right">Security Answer::
<td align="center"><input id="text3" type="text" placeholder="Enter answer" name="security_question_answer" value="${ userBeanObj.security_question_answer }">
<td align="left"> ${ security_question_answer }
</tr>


<tr>
<th align="right">Image :
<td align="center"><input id="text3" type="file" name="user_image">
<td align="left"> ${ user_image }
</tr>

<tr>
<td colspan="2" align="center"><input  type="submit" name="btnsubmit" id="btnsubmit" value="Submit" class="button button4">
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
        <li><a href="#">Home Page</a></li>
        <li><a href="#">Police Station</a></li>
        
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