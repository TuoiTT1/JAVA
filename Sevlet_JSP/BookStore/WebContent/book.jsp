<%@page import="com.vn.entity.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BookStore</title>
<style type="text/css">
table, tr, th, td {
	border-collapse: collapse;
	border: 1px solid;
	padding: 0px 5px 0px 5px;
}
</style>
</head>
<body>
	<h1>Danh sách các đầu sách</h1>
	<table>
		<thead>
			<tr>
				<th>STT</th>
				<th>Tên sách</th>
				<th>Tác giả</th>
				<th>Nhà xuất bản</th>
				<th>Năm xuất bản</th>
				<th>Số lượng</th>
				<th>Giá gốc (VND)</th>
				<th>Mô tả</th>
			</tr>
		</thead>
		<tbody>
			<%
				List<Book> books = (List<Book>) request.getAttribute("books");
				int i = 0;
				for (Book b : books) {
					i++;
			%>
			<tr>
				<td><%=i%></td>
				<td><%=b.getName() != null ? b.getName() : ""%></td>
				<td><%=b.getAuthor() != null ? b.getAuthor() : ""%></td>
				<td><%=b.getPublisher() != null ? b.getPublisher() : ""%></td>
				<td><%=b.getYearOfPublication() != null ? b.getYearOfPublication() : ""%></td>
				<td><%=b.getQuantity() != null ? b.getQuantity() : ""%></td>
				<td><%=b.getPrice() != null ? b.getPrice() : ""%></td>
				<td><%=b.getDescription() != null ? b.getDescription() : ""%></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>

</body>
</html>