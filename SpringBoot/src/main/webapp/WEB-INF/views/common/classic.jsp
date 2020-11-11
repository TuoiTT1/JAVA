<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<title><tiles:getAsString name="title" /></title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"></link>
	<script src="${pageContext.request.contextPath}/js/main.js"></script>
	
	<!--  pageContext.request.contextPath = http://localhost:9999/ProductManagermenet/ -->
	
</head>

<body>

	<!--Header-->
	<header>
	 	<tiles:insertAttribute name="header" />
	</header>
	
	
	<div class="main">
		  <tiles:insertAttribute name="menu" />
		  <div class="content">
		    <tiles:insertAttribute name="body" />
		  </div>
	</div>
	<tiles:insertAttribute name="footer" />
		
</body>
</html>
