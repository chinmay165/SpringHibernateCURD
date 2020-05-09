<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		
		<h2>Add Book</h2>
	<form:form action="saveBook" method="Post">
	
		<table>
			<tr>
				<th>Book Name</th>
				<td><input type="text" name="name" >
				<span><c:if test="${errlist.name!=null}">${errlist.name}</c:if></span></td>
			</tr>
			<tr>
				<th>Author</th>
				<td><input type="text" name="author" >
				<span ><c:if test="${errlist.author!=null}">${errlist.author}</c:if></span>
				</td>
			</tr>
			<tr>
				<th>Price</th>
				<td><input type="text" name="price" >
				<span><c:if test="${errlist.price!=null}">${errlist.price}</c:if></span>
				</td>
			</tr>
			
			<tr>
				
				<td><button type="submit" name="submitbtn" value="Save">Save</button> </td>
			</tr>
		</table>
	
	 </form:form>
	 
	 
	 <br><br><br><br>
	 
	 <h2>Book List</h2>
 
	<table>
		<tr>
			<th>Book Sr.No</th>
			<th>Name</th>
			<th>Author</th>
			<th>Price</th>
		</tr>	
		<c:forEach items="${bookSer }" var="bookEnty">
		
			<tr>
				<td>${bookEnty.bookId }</td>
				<td>${bookEnty.name }</td>
				<td>${bookEnty.author }</td>
				<td>${bookEnty.price }</td>
				
				<form action="editBook" method="get">
					<td><input type="hidden" name="hid_bId" value="${bookEnty.bookId }"></td>
					<td><button type="submit">Edit</button></td>		
				</form>
				<form action="deleteBook" method="post">
					<td><input type="hidden" name="hid_bId" value="${bookEnty.bookId }"></td>
					<td><button type="submit">Delete</button></td>		
				</form>
			</tr>
		
		</c:forEach>
	</table>	
	
</body>
</html>