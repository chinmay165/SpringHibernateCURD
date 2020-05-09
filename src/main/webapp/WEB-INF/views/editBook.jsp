<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Book Details</title>
</head>
<body>

	<h2>Update Book Details</h2>
	<form action="updateBook" method="Post">
	
		<table>
			<tr>
				<th>Book Name</th>
				<td><input type="text" name="name" value="${bookSer.name }">
				<span><c:if test="${errlist.name!=null}">${errlist.name}</c:if></span></td>
			</tr>
			<tr>
				<th>Author</th>
				<td><input type="text" name="author" value="${bookSer.author }">
				<span ><c:if test="${errlist.author!=null}">${errlist.author}</c:if></span>
				</td>
			</tr>
			<tr>
				<th>Price</th>
				<td><input type="text" name="price" value="${bookSer.price }">
				<span><c:if test="${errlist.price!=null}">${errlist.price}</c:if></span>
				</td>
			</tr>
			
			<tr>
				<td><input type="text" name="bookId" value="${bookSer.bookId }"></td>
				<td><button type="submit" name="submitbtn" >Update</button> </td>
			</tr>
		</table>
	</form>

</body>
</html>