<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- modelAttribute indica de donde tiene que tomar la informacion -->
<form:form action="formulario_p" modelAttribute="elAlumno">

<!-- path= hace referencia al nombre de losmetodos getes y seter en la clase alumno -->
<!-- observar que no es getNombre ni setNombre... es nombre -->
<!-- cuando el formulario se carga se llama al metodo get -->
<!-- cuando el formulario se envia (el cliente lo envia) se llama al metodo set -->
<form:label path="nombre">Nombre</form:label>
<form:input path="nombre"/>
<form:errors path="nombre"></form:errors>
<br>
<br>
<form:label path="apellido">Apellido</form:label>
<form:input path="apellido"/>
<br>
<br>
<form:label path="postal">codigo postal</form:label>
<form:input path="postal"/>
<form:errors path="postal"></form:errors>
<br>
<br>
<input type="submit" value="Enviar">

</form:form>

</body>
</html>