<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Student Details</title>
</head>
<body>

	<form action="updateStudent" method="post" >
      <h2>Update Student Details</h2>
      
      <table>
        
        <tr>
          <th>iCard No.</th>
            <td><input type="text" name="cardid" readonly="readonly" value="${stdData.cardid }"></td>
        </tr>
        
        <tr>
          <th>Roll No.</th>
            <td><input type="text" name="rollno" value="${stdData.rollno }"></td>
        </tr>
        
        <tr>
          <th>Name</th>
            <td><input type="text" name="sname" value="${stdData.sname }"></td>
        </tr>
        
        <tr>
          <th>Stream</th>
          
          	<td><select name="stream" >
          	<c:if test="${stdData.stream eq 'Science' }">
          	 	<option selected="selected" value="Science">Science</option>
          	 	<option value="Commerce">Commerce</option>
				<option value="Arts">Arts</option>
				<option value="Computer">Computer</option>
          	 	       
   			</c:if>
   					
          	
          	<c:if test="${stdData.stream eq 'Commerce' }">
          	 	<option value="Science">Science</option>
          	 	<option selected="selected" value="Commerce">Commerce</option>
				<option value="Arts">Arts</option>
				<option value="Computer">Computer</option>
          	 	       
   			</c:if>		
          	
          	<c:if test="${stdData.stream eq 'Arts' }">
          	 	<option value="Science">Science</option>
          	 	<option value="Commerce">Commerce</option>
				<option selected="selected" value="Arts">Arts</option>
				<option value="Computer">Computer</option>
          	 	       
   			</c:if>
          	
          	<c:if test="${stdData.stream eq 'Computer' }">
          	 	<option value="Science">Science</option>
          	 	<option value="Commerce">Commerce</option>
				<option value="Arts">Arts</option>
				<option selected="selected" value="Computer">Computer</option>
          	 	       
   			</c:if>		
          		</select>	
          	</td>
          
        </tr>
        
        <tr>
        
        	<!-- <td><input type="hidden" name="cardid" value="${stdData.cardid }"></td> -->
        	<td><td><button type="submit" >Update</button></td>
        </tr>
      </table>
    </form>
	

</body>
</html>