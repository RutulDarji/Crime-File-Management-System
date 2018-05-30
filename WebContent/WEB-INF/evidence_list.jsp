<%@page import="java.util.ArrayList"%>
<%@page import="Mindeft.CFMS.bean.evidenceBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="" id="evidence_list_form" name="evidence_list_form">
<input type="hidden" name="evidence_id" id="evidence_id">
<table border=1>
<tr>
<td>Evidence Id</td>
<td>Evidence Date</td>
<td>Evidence Details</td>
<td>Evidence Image</td>
<td>Crime Id</td>
<td>Action</td>
</tr>

<% List<evidenceBean> AreaBeanlist=(ArrayList)request.getAttribute("AreaBeanlist"); 
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

</body>
</html>