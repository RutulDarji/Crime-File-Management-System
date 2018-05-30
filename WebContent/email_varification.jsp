<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
 function mail()
 {
	 var f=document.email_validation;
	 f.email=email;
	 f.action="send_otp";
	 f.submit();	 
 }
  
</script>
<style>
body
{
	color:white;
	font-size:20px;
}
</style>
</head>


<body>

<form action="otp_check" name="email_validation" id="email_validation">

<table>

<tr>
<td>Enter Email::
<td><input type="text" name="email" id="email" value="${ email }"> ${ email }
<td><input type="button" name="btnotp" value="SEND OTP" onclick="mail()">
</tr>

<tr>
<td>Enter OTP::
<td><input type="text" name="otp" id="otp"> ${ otp }
</tr>

<tr>
<td><input type="submit" name="btnsubmit" id="btnsubmit">
</tr>


</table>

</form>

</body>
</html>