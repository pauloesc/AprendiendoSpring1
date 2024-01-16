package paqueteProyecto.miniProyecto1;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/alumno")
public class AlumnoControlador {

	@InitBinder
	public void miBainder(WebDataBinder wdb) {
		StringTrimmerEditor ste = new StringTrimmerEditor(false);
		wdb.registerCustomEditor(String.class, ste);
	}
	
	@RequestMapping("/formulario_m")
	public String muestraFormulario(Model modelo) {
		Alumno a = new Alumno();
		
		//si quisieramos que al mostrar el formulario se muestre un dato en particular
		a.setApellido("apeape");
		
		modelo.addAttribute("elAlumno", a);
		
		//observar que en lo retornado esta la direccion de la carpeta
		return "miniProyecto1/alumno_muestra_f";	
	}
	
	@RequestMapping("/formulario_p")
	//Si observamos el html vemos que el form tiene id="elAlumno".
	//el objeto BindingResult tiene los resultados de validacion.
	//con @Valid indicamos que estamos usando validacion.
	public String procesarFormulario( 	@Valid
										@ModelAttribute("elAlumno") Alumno alumnoo,
										BindingResult resultadoValidacion) {		
		
		//realizamos unas modificaciones a los datos enviados por el usuario
		//dicha modificacion cuando llegua a la vista esta presente 
		alumnoo.setApellido("apellidoSetteado");
		
		if (resultadoValidacion.hasErrors()) {
			return "miniProyecto1/alumno_muestra_f";
		}
		else {
			return "miniProyecto1/alumno_muestra_p";	
		}
	}
	
}
