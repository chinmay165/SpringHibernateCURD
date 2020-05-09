<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>        
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Form</title>
</head>
<body>
		<h2>${welcomeMsg }</h2> 
	<form action="saveStudent" method="post">
		
			<table>
			<tr>
				<th>Roll No.</th>
				<td><input type="text" name="rollno" >
				<!-- <c:if test="${errlist.name!=null}">${errlist.name}</c:if></span></td> --><span>
			</tr>
			<tr>
				<th>Name :</th>
				<td><input type="text" name="sname" >
				<!-- <c:if test="${errlist.author!=null}">${errlist.author}</c:if></span> --><span >
				</td>
			</tr>
			<tr>
				<th>Stream :</th>
				<td><select  name="stream" >
						<option value="Science">Science</option>
						<option value="Commerce">Commerce</option>
						<option value="Arts">Arts</option>
						<option value="Computer">Computer</option>
				</select>
				<!-- <span><c:if test="${errlist.price!=null}">${errlist.price}</c:if></span> -->
				</td>
			</tr>
			
			<tr>
				
				<td><button type="submit" name="submitbtn" value="Save">Save</button> </td>
			</tr>
		</table>
		
	</form>

 <br><br><br><br>
	 
	 <h2>Student List</h2>
 
	<table>
		<tr>
			<th>iCard No</th>
			<th>Roll No.</th>
			<th>Name</th>
			<th>Stream</th>
		</tr>	
		<c:forEach items="${stdSers }" var="stdEy">
		
			<tr>
				<td>${stdEy.cardid }</td>
				<td>${stdEy.rollno }</td>
				<td>${stdEy.sname }</td>
				<td>${stdEy.stream }</td>
				
				<form action="editStudent" method="get">
					<td><input type="hidden" name="hid_cId" value="${stdEy.cardid }"></td>
					<td><button type="submit">Edit</button></td>		
				</form>
				<form action="deleteStudent" method="post">
					<td><input type="hidden" name="hid_cId" value="${stdEy.cardid }"></td>
					<td><button type="submit">Delete</button></td>		
				</form>
			</tr>
		
		</c:forEach>
	</table>	
	<h3>${msg }</h3>

</body>
</html>