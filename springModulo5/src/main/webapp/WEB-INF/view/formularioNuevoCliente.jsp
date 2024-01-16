<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<form:form action="insertarCliente" modelAttribute="cliente" method="POST">

<%-- 	<form:label path="id">id</form:label> --%>
<%-- 	<form:input path="id"/> --%>
<!-- 	<br>	<br> -->
	
	<form:label path="nombre">nombre</form:label>
	<form:input path="nombre"/>
	<br>	<br>
	
	<form:label path="apellido">apellido</form:label>
	<form:input path="apellido"/>
	<br>	<br>
	
	<form:label path="email">email</form:label>
	<form:input path="email"/>
	<br>	<br>
	
	<input type="submit" value="enviiarr">

</form:form>

</body>
</html>