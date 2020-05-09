<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration From</title>
<style type="text/css">

.error {
	color: red;
}
</style>
</head>


<body>
	
    <form:form action="saveData" method="post" modelAttribute="regEnty">
      <h2>Registration From</h2>
      
      <table>
        <tr>
          <th>Name</th>
          <td>
            <td><input type="text" name="name" ></td>
          </td>
        </tr>
        <tr>
          <th>Sex</th>
          <td>
          	<td><select name="sex">
          			<option value="">Select</option>
          			<option value="male">Male</option>
          			<option value="female">Female</option>
          			<option value="other">Other</option>
          		</select>	
          	</td>
          </td>
        </tr>
        <tr>
          <th>Address</th>
          <td>
            <td><input type="text" name="addr" ></td>
          </td>
        </tr>
        <tr> 
          <th>Email</th>
          <td>
            <td><input type="text" name="email" ></td>
          </td>
        </tr>
        <tr>
        	<td><td><button type="submit">Save</button></td></td>
        </tr>
      </table>
    </form:form>
    
    <br><br>
<br><br> 

	<h2>Registered List</h2>   
	
	<table border="1">
		<tr>
			<th>Reg. ID</th>
			<th>Name</th>
			<th>Sex</th>
			<th>Address</th>
			<th>Email</th>
		</tr>
		
		<c:forEach items="${regSer}" var="regEnty">
			<tr>
				<td>${regEnty.regId }</td>
				<td>${regEnty.name }</td>
				<td>${regEnty.sex }</td>
				<td>${regEnty.addr }</td>
				<td>${regEnty.email }</td>
				
			<form action="editReg" method="get">
				<td><input type="hidden" name="hid_regId" value="${regEnty.regId }"></td>
				<td><button type="Submit">Edit</button></td>
			</form>
			<form action="deleteData" method="post">
				<td><input type="hidden" name="hid_regId" value="${regEnty.regId }"></td>
				<td><button type="Submit">Delete</button></td>
			</form>	
			</tr>
		
		</c:forEach>
	</table>

</body>
</html>