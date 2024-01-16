<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/url_Recursos/css/csss.css">
</head>
<body>

<c:forEach var="cliente" items="${clientes}">

<p>${cliente.id}</p>
<p>${cliente.nombre}</p>
<p>${cliente.apellido}</p>
<p>${cliente.email}</p>

<!-- contruir una url y pasarle un valor del tipo ?id=${cliente.id} -->
<!-- en var esta el nombre de la url -->
<c:url var="linkActualizar" value="vistaModificar" >
	<c:param name="id" value="${cliente.id}" />
</c:url>

<!-- observar que es lo que hay en href -->
<a href="${linkActualizar}">Modificar</a>

<p>----------------------------------</p>
	
</c:forEach>

<!--
http://localhost:8080/springModulo5/cliente/lista pasa a
http://localhost:8080/springModulo5/cliente/formularioNuevoCliente
-->
<a href="formularioNuevoCliente">Ingrese registros</a>

</body>
</html>