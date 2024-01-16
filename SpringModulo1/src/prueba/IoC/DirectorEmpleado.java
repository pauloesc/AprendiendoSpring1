package prueba.IoC;

public class DirectorEmpleado implements Empleados {

	private CreacionInformes informeNuevo;
	
	//este constructor es util para inyectar la dependencia "Informe"
	public DirectorEmpleado(CreacionInformes informeNuevo) {
		this.informeNuevo = informeNuevo;
	}

	@Override
	public String getTareas() {
		return "director empleado";
	}

	@Override
	public String getInforme() {
		return "Informe de director: " + informeNuevo.getInforme();
	}
	
//	metodo init, ejecuta tareas antes de que el bean este disponible
	public void init_nombre() {
		System.out.println("dentro del metodo init: " + informeNuevo.getInforme());
	}
//	metodo destroy, ejecuta tareas antes de que el bean sea eliminado
	public void destroy_nombre() {
		System.out.println("dentro del metodo destroy");
	}
	

}
