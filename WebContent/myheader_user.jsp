<%@page import="Mindeft.CFMS.bean.userBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

//HttpSession login_session=request.getSession();
//userBean userBeanObj=(userBean)login_session.getAttribute("userBeanObj");
userBean session_userBeanObj=(userBean)session.getAttribute("session_userBeanObj");
System.out.print("Inside USer Session Bean");
if(session_userBeanObj!=null)
{
	System.out.print("HELLO");
}
else
{
	System.out.print("BYE");
	response.sendRedirect("login_page.jsp");
}

%>

</body>
</html>