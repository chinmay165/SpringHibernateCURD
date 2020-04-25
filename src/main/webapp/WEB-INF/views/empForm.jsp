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
	<h2>Employee Details</h2>
	<form:form action="saveEmployee" method="Post" modelAttribute="empEnty">
	
		<table>
			<tr>
				<th>Name</th>
				<td><input type="text" name="empName" ></td>
			</tr>
			<tr>
				<th>Designation</th>
				<td><input type="text" name="designation" ></td>
			</tr>
			<tr>
				<th>Gender</th>
				<td><input type="text" name="gender" ></td>
			</tr>
			
			<tr>
				
				<td><button type="submit" name="submitbtn" value="Save">Save</button> </td>
			</tr>
		</table>
	
	 </form:form>
	
	<br><br><br>
	
	<fieldset>
	
	
    <legend>Employee List</legend>
    <table class="resltTable">
      <tr>
        <th>Name</th>
        <th>Designation</th>
        <th>Gender</th>
      </tr>
      <c:forEach items="${empSer}" var="empEnty">
      <form action="editEmp">
        <tr>
        <td>${empEnty.empId}</td>	
          <td>${empEnty.empName}</td>
          <td>${empEnty.designation}</td>
          <td>${empEnty.gender}</td>
          <td><input type="text" name="empid" value="${empEnty.empId}"></td>
          <td><input type="Submit" name="Edit" value="Edit">
        </tr>
       </form> 
      </c:forEach>

    </table>
  </fieldset>
  
</body>
</html>