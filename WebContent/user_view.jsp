<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<table>
<tr> <th>Image</th><th>Title</th><th>Description</th><th>Price</th><th>Date</th>
</tr>
<s:iterator value="userList" var="user">
	<tr>
		<td><s:property value="userIdNo"/></td>
		<td><s:property value="userPassword"/></td>
		<td><s:property value="userEmail"/></td>
		<td><s:property value="userType"/></td>
		<td><s:property value="userDateOfRegister"/></td>
		<td><s:property value="userPassword"/></td>
		<td><s:property value="userImage"/></td>
		<td><s:property value="userToken"/></td>
	</tr>
</s:iterator>
</table>




</body>
</html>