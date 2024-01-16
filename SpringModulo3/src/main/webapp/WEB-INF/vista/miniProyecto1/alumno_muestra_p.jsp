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

El alumno con nombre: ${elAlumno.nombre}
<br>
El alumno con apellido: ${elAlumno.apellido}
<br>
<!-- observar que es cpostal y no Cpostal -->
El alumno con c postal: ${elAlumno.cpostal}
<br>
Se registro con exito
<br>
</body>
</html>