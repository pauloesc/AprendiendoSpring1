<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<p>Nombre del usuario:
		<sec:authentication property="principal.username" />
	</p>
	<p>Rol del usuario:
		<sec:authentication property="principal.authorities" />
	</p>

	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">
		<input type="submit" value="logout" />
	</form:form>

	<br>

	<sec:authorize access="hasRole('ADMINISTRADOR')">
		Cosas para admin
	</sec:authorize>
	
	<sec:authorize access="hasRole('USUARIO')">
		Cosas para user
	</sec:authorize>
	
	<sec:authorize access="hasRole('AYUDANTE')">
		Cosas para ayudante
	</sec:authorize>

</body>
</html>