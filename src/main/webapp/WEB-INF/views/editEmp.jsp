<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="updateEmp" method="Post">
		<table>
			<tr>
				<th>Name</th>
				<td><input type="text" name="empName" value="${edit.empName}"></td>
			</tr>
			<tr>
				<th>Designation</th>
				<td><input type="text" name="designation" value="${edit.designation}"></td>
			</tr>
			<tr>
				<th>Gender</th>
				<td><input type="text" name="gender" value="${edit.gender}"></td>
			</tr>
			
			<tr>
				<th>Gender</th>
				<td><input type="text" name="empId" value="${edit.empId}"></td>
			</tr>
			<tr>
				
				<td><button type="submit" name="submitbtn" value="Update">Save</button> </td>
			</tr>
		</table>
</form>		
</body>
</html>