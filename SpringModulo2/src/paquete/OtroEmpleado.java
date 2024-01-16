package paquete;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OtroEmpleado implements Empleados {

	@Value("${nnombre}")
	public String Nombre;
	
	
	public String getNombre() {
		return Nombre;
	}

	@Override
	public String getTareas() {
		// TODO Auto-generated method stub
		return "otro empl";
	}

	@Override
	public String getInforme() {
		// TODO Auto-generated method stub
		return "otro empl";
	}

}
