package programa.entidad;

public class Empleado {

	private String Nombre;
	private String Apellido;
	
	public Empleado() {
	}

	
	
	public Empleado(String nombre, String apellido) {
		Nombre = nombre;
		Apellido = apellido;
	}



	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	
}
