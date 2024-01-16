<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form:form action="${pageContext.request.contextPath}/urlLogin" method="POST">

<!-- si el atributo error que viene en la url es diferente de null.... -->
<!-- url/?error -->
<c:if test="${param.error!=null}">
<p>Error al ingresar los datos</p>
</c:if>

<c:if test="${param.logout!=null}">
<p>Haz salido de sesion</p>
</c:if>


<!-- PARA QUE SPRING SEPA EN QUE CAMPOS VA EL USUARIO Y LA CONTRASENIA LOS -->
<!-- CAMPOS DEBEN LLAMARSE USERNAME Y PASSWORD -->
<label>Usuario</label>
<input type="text" name="username"/>
<label>password</label>
<input type="password"  name="password">

<input type="submit" value="Enviar">

</form:form>


</body>
</html>