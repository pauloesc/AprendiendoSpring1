package prueba.IoC;

public class JefeEmpleado  implements Empleados{

	private CreacionInformes informeNuevo;
	public JefeEmpleado(CreacionInformes informeNuevo) {
		this.informeNuevo = informeNuevo;
	}

	@Override
	public String getTareas() {
		return "Jefe empleado";
	}

	@Override
	public String getInforme() {
		return "informe de jefe: " + informeNuevo.getInforme();
	}
	
}
