package programa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
// esta clase se asociara con la tabla clientes, que ya esta creada en la bd.
@Table(name="clientes")
public class Clientes {

	//@Column(name="id") asocia la variable a la columna llamada id.
	//con @Id indicamos el campo que es primary key
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	@Column(name="Nombre")
	private String  nombre;
	@Column(name="Apellido")
	private String  apellido;
	@Column(name="Direccion")
	private String  direccione;

	
	public Clientes() {
	}
	
	
	public Clientes(String nombre, String apellido, String direccione) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccione = direccione;
	}


	@Override
	public String toString() {
		return "Clientes ==>> [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", direccione=" + direccione
				+ "]";
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
	public String getDireccione() {
		return direccione;
	}
	public void setDireccione(String direccione) {
		this.direccione = direccione;
	}

	
}
