package programa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) //si hay propiedades en el json que no estan en la clase empleado ingnoralas
public class Empleado {

	private int id;
	private String nombre;
	private String apellido;
	private boolean activo;
	private String[] idiomas;
	private DatosEmpleados datos_registroo;
	
	public Empleado() {
	}


	public DatosEmpleados getDatos_registroo() {
		return datos_registroo;
	}


	public void setDatos_registroo(DatosEmpleados datos_registroo) {
		this.datos_registroo = datos_registroo;
	}


	public String[] getIdiomas() {
		return idiomas;
	}


	public void setIdiomas(String[] idiomas) {
		this.idiomas = idiomas;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public boolean isActivo() {
		return activo;
	}


	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	
	
}
