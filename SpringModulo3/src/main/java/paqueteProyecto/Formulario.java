package paqueteProyecto;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


//La anotación @Controller en Spring es utilizada para marcar una clase como un
//controlador de Spring MVC. Un controlador es una clase que maneja las
//solicitudes HTTP y produce respuestas, generalmente utilizada en el
//desarrollo de aplicaciones web.

@Controller
@RequestMapping("/sub_url")
public class Formulario {

	@RequestMapping("/muestraf")
	public String muestraFormulario() {
		return "formulario_muestra";
		
	}
	
	
//	primera forma de tomar un parametro que viene en la url
	
//	@RequestMapping("/procesarf")
//	public String procesarFormulario(HttpServletRequest request, Model modelo) {
//		// alumnoNombre es el nombre del input (html)
//		String na = request.getParameter("alumnoNombre");
//		na = na + " .....mas texto extra añadido en el procesamiento del formulario";
//		modelo.addAttribute("textoProcesado", na);
//		return "formulario_respuesta";
//	}
	
	
	
//	Segunda forma de tomar un parametro que viene en la url
	
	@RequestMapping("/procesarf")
	public String procesarFormulario(@RequestParam("alumnoNombre") String na, Model modelo) {
		na = na + " .....mas texto extra añadido en el procesamiento del formulario";		
		modelo.addAttribute("textoProcesado", na);
		return "formulario_respuesta";
	}
	
}
