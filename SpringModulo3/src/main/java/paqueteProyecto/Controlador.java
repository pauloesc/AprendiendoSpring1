package paqueteProyecto;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controlador {

	@RequestMapping()
	public String MuestraPagina() {
		
		//retorna el nombre del jsp (sin la extension)
		return "ejemplo";
	}
	
}
