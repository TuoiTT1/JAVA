<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<header>
	<h2>BookStore</h2>
	<div class="topnav">
		<a class="active" href="${pageContext.request.contextPath}">Trang chủ</a>
		<!-- 		<a href="#contact">Contact</a>  -->
		<!-- 		<a href="#about">About</a> -->
		<div class="account">
			<c:choose>
				<c:when test="${sessionScope.userName == null}">
					<a href="#">Đăng ký</a>
					<a href="${pageContext.request.contextPath}/login">Đăng nhập</a>
				</c:when>
				<c:otherwise>
					<a href="#">Xin chào, <c:out value="${sessionScope.userName}" /></a>
					<a href="${pageContext.request.contextPath}/logout">Đăng xuất</a>
				</c:otherwise>
			</c:choose>
		</div>
	</div>

</header>
