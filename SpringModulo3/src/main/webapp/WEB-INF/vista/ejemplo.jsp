<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
pagina de ejemplo (html)
<br>

<!-- observar que sub_url no tiene una / por delante -->
<a href="sub_url/muestraf">Formulario</a>
<br>

<a href="alumno/formulario_m">Formulario</a>
<br>

<!-- ${pageContext.request.contextPath} me situa en la carpeta web webapp -->
<img alt="texto de la imagen" src="${pageContext.request.contextPath}/url_Recursos/img/manzana.jpeg">
<br>

<!-- marca un error pero funciona -->
<span>Contenido de la variable pageContext.request.contextPath es:  ${pageContext.request.contextPath}</span>
<br>

</body>
</html>