<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Demo Servlet</title>
</head>
<body>

	<%
		String message = (String) request.getAttribute("message");
		if (message != null && message != "") {
	%>
	<h1 style="color: red;">
		<%
			out.print(message);
		%>
	</h1>

	<%
		}
	%>
</body>
</html>