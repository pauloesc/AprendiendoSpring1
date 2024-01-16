Si deseas mostrar contenido específico dependiendo del usuario que está autenticado y del usuario al que pertenece la página, puedes realizar comprobaciones dentro de tu página JSP utilizando expresiones condicionales de Java. En el ejemplo que proporcionaré a continuación, asumiré que tienes un objeto `Usuario` y que quieres mostrar información adicional si el usuario autenticado es el mismo que el usuario cuyo perfil se está visualizando.

Supongamos que tienes un objeto `Usuario` que tiene un campo `username`. En tu controlador o servicio, podrías agregar este objeto a la vista antes de mostrar la página JSP:

```java
@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/perfil/{username}")
    public String mostrarPerfil(@PathVariable String username, Model model, Principal principal) {
        Usuario usuario = usuarioService.obtenerUsuarioPorUsername(username);
        model.addAttribute("usuario", usuario);

        // Agregar el nombre de usuario autenticado a la vista
        if (principal != null) {
            model.addAttribute("usuarioAutenticado", principal.getName());
        }

        return "perfil";
    }
}
```

Luego, en tu página JSP, puedes usar expresiones condicionales para mostrar contenido adicional según si el usuario autenticado es el mismo que el usuario cuyo perfil se está viendo:

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Página de Perfil</title>
</head>
<body>

<sec:authorize access="isAuthenticated()">
    <c:if test="${usuario.username eq usuarioAutenticado}">
        <!-- Contenido adicional visible solo si el usuario autenticado es el mismo que el usuario cuyo perfil se está viendo -->
        <p>Estás viendo tu propio perfil. Aquí puedes ver información adicional.</p>
    </c:if>
</sec:authorize>

<!-- Resto del contenido del perfil -->

</body>
</html>
```

En este ejemplo:

- `${usuario.username eq usuarioAutenticado}` compara el nombre de usuario del usuario cuyo perfil se está viendo con el nombre de usuario del usuario autenticado. Si son iguales, se mostrará el contenido adicional.

Ajusta este ejemplo según la lógica y la estructura de tu aplicación.