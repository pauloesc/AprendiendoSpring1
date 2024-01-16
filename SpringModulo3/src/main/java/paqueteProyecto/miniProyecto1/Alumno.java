package paqueteProyecto.miniProyecto1;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Alumno {
	
	/*
	 * no poner primera letra de nombre de variables en mayuscula.
	 * hace que no funcionen algunas cosas pero sin dar error ni avisar.
	 */
	
	@NotNull()
	@Size(min = 3 , max = 10, message = "entre 3 y 10 letras")
	private String nombre;
	
	private String apellido;

	@validacionFormularios.Cpostal()
	private String postal;

	public String getPostal() {
		return postal;
	}
	public void setPostal(String postal) {
		this.postal = postal;
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
	
}
