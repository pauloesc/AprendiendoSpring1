package miPrograma.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controlador2 {

	@GetMapping("/miFormularioLogin")
	public String loginFormulario() {
		return "login";
	}
	
}
