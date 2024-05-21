<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Handling Page</title>
</head>
<body>
	<h5 style="color: red;">
		Error Message
		<%=exception%></h5>
		<h5 align="center">Via EL syntax</h5>
		<h5 style="color:red;">Exception - ${pageContext.exception}</h5>
		<h5 style="color:red;">Exception - ${pageContext.exception.message}</h5>
		<h5 style="color:red;">Error code -${pageContext.errorData.statusCode}</h5>
		<h5 style="color:red;">Error causing page- ${pageContext.errorData.requestURI}</h5>
		
</body>
</html>