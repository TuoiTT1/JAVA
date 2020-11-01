
<%@page import="com.vn.dao.CategoryDAO"%>
<%@page import="com.vn.dao.impl.CategoryDAOImpl"%>
<%@page import="com.vn.entity.Category"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	CategoryDAO categoryDAO = new CategoryDAOImpl();
	List<Category> categories = categoryDAO.getAll();
%>
<nav>
	<ul>
		<c:forEach var="element" items="<%=categories %>">
			<li><a href="${pageContext.request.contextPath}/book?category=${element.id}"><c:out value="${element.title}"></c:out></a></li>
		</c:forEach>
	</ul>
</nav>
