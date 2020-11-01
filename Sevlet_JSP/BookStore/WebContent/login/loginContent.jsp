<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Login</h1>
	<form action="${pageContext.request.contextPath}/login" method="post">
	<table>
		<tr>
			<td>UserName</td>
			<td><input type="text" name="userName" value="" /></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="text" name="password" value="" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Login"></td>
		</tr>
	</table> 
	</form>
	<h2>${message }</h2>
</body>
</html>