<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Thêm mới sách:</h3>
	<form action="${pageContext.request.contextPath}/product/save" method="post">
		<table border="0">
			<tr>
				<td>ID</td>
				<td><input type="text" name="id" value="${book.id}"
					readonly="readonly"/></td>
			</tr>
			<tr>
				<td>Category</td>
				<td><input type="text" name="category.id"
					value="${book.category.id}"  required="required"/></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" value="${book.name}" required="required"/></td>
			</tr>
			<tr>
				<td>Author</td>
				<td><input type="text" name="author" value="${book.author}" required="required"/></td>
			</tr>
			<tr>
				<td>Publisher</td>
				<td><input type="text" name="publisher"
					value="${book.publisher}" /></td>
			</tr>
			<tr>
				<td>Year Of Publication</td>
				<td><input type="text" name="yearOfPublication"
					value="${book.yearOfPublication}" /></td>
			</tr>
			<tr>
				<td>Quantity</td>
				<td><input type="text" name="quantity" value="${book.quantity}" required="required"/></td>
			</tr>
			<tr>
				<td>Price</td>
				<td><input type="text" name="price" value="${book.price}" /></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><input type="text" name="description"
					value="${book.description}" /></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type="submit" value="Lưu" /> 
					<a href="${pageContext.request.contextPath}/products"> Hủy</a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>