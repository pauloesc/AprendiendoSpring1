package prueba.IoC;

public class SecretarioEmpleado implements Empleados {

	private String email;
	private String NombreEmpresa;
	private CreacionInformes informeNuevo;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombreEmpresa() {
		return NombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		NombreEmpresa = nombreEmpresa;
	}

	//este set es para inyectar la dependencia
	public void setInformeNuevo(CreacionInformes informeNuevo) {
		this.informeNuevo = informeNuevo;
	}

	@Override
	public String getTareas() {
		return "secretario empleado";
	}

	@Override
	public String getInforme() {
		return "informe de secretario: " + informeNuevo.getInforme();
	}

}
