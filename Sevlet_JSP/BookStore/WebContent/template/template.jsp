<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BookStore</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css"/>
</head>
<body>
	<jsp:include page="_header.jsp"></jsp:include>

	<section>
		<jsp:include page="_sidebar.jsp"></jsp:include>
		<article><jsp:include page="${param.content}.jsp" /></article>
	</section>

	<jsp:include page="_footer.jsp"></jsp:include>


</body>
</html>