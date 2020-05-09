<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Registration Details</title>
</head>
<body>

	<form action="updateData" method="post" >
      <h2>Update Registration Details</h2>
      
      <table>
        <tr>
          <th>Name</th>
          <td>
            <td><input type="text" name="name" value="${editReg.name }"></td>
          </td>
        </tr>
        <tr>
          <th>Sex</th>
          <td>
          	<td><select name="sex" >
          	<c:if test="${editReg.sex eq 'male' }">
          	 	<option selected="selected" value="male">Male</option>
          	 	<option  value="female">Female</option>
          	 	<option  value="other">Other</option>
          	 	       
   			</c:if>
   					
          	
          	<c:if test="${editReg.sex eq'female' }">
				<option  value="male">Male</option>
          	 	<option  selected="selected" value="female">Female</option>
          	 	<option  value="other">Other</option>   			
			</c:if>		
          	
          	<c:if test="${editReg.sex eq 'other' }">
				<option  value="male">Male</option>
          	 	<option   value="female">Female</option>
          	 	<option  selected="selected" value="other">Other</option>   			
			</c:if>
          			
          		</select>	
          	</td>
          </td>
        </tr>
        <tr>
          <th>Address</th>
          <td>
            <td><input type="text" name="addr" value="${editReg.addr }"></td>
          </td>
        </tr>
        <tr> 
          <th>Email</th>
          <td>
            <td><input type="text" name="email" value="${editReg.email }"></td>
          </td>
        </tr>
        <tr>
        <td>
        	<td><input type="hidden" name="regId" value="${editReg.regId }"></td>
        	<td><td><button type="submit" >Update</button></td></td>
        </tr>
      </table>
    </form>

</body>
</html>