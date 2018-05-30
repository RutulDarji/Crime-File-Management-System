<%@page import="Mindeft.CFMS.dao.countryDao"%>
<%@page import="Mindeft.CFMS.bean.countryBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
  
  <script type='text/javascript' src='/CrimeFileManagementSystem/dwr/interface/ajex_data_Dao.js'></script>
  <script type='text/javascript' src='/CrimeFileManagementSystem/dwr/engine.js'></script>
  <script type='text/javascript' src='/CrimeFileManagementSystem/dwr/util.js'></script>

<script type="text/javascript">

function getAjexCountry(country_id) {

	alert("Helo" + country_id);
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

	alert("Helo" + state_id);
	dwr.util.removeAllOptions("city");
	
	if(state_id==''){
	var data=[{ city_name:'-- Select --', city_id:'' }];
	dwr.util.addOptions("city",data,"city_id","city_name");
	
	}else{
		//alert(stateId);
		//document.getElementById('cityLoader').style.visibility = 'visible';
		ajex_data_Dao.getAllCity(state_id,function(data){
		dwr.util.addOptions("city",data,"city_id","city_name");
		  //  document.getElementById('cityLoader').style.visibility = 'hidden';
		});
	}
}

function getAjexArea(city_id) {

	alert("Helo" + city_id);
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
<body>

<form action="" method="post" name="ajex_country_state_city">

<table>

<tr>
<th> Select Country:
<td> 
 <select name="country_name" id="text3" onchange="java:getAjexCountry(this.value)"> 
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
<td>${ country_name }
</tr>

<tr>
<th>Select State:
<td>
<select name="state" id="state" onchange="java:getAjexCity(this.value)">
<option value="">--Select Any State--</option>
</select>
</tr>

<tr>
<th>Select City:
<td>
<select name="city" id="city" onchange="java:getAjexArea(this.value)">
<option value="">--select any City--</option>
</select>
</tr>

<tr>
<th>Select Area:
<td>
<select name="area" id="area">
<option value="">--select any Area--</option>
</select>
</tr>

</table>

</form>

</body>
</html>