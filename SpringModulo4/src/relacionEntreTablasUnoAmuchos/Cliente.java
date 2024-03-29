package relacionEntreTablasUnoAmuchos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
// esta clase se asociara con la tabla clientes, que ya esta creada en la bd.
@Table(name="cliente")
public class Cliente {

	//@Column(name="id") asocia la variable a la columna llamada id.
	//con @Id indicamos el campo que es primary key
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="nombre")
	private String  nombre;
	@Column(name="apellido")
	private String  apellido;
	@Column(name="direccion")
	private String  direccione;

	
	//cualquier cambio se propagara a detalles cliente
	@OneToOne( cascade = CascadeType.ALL )
	
	/*
	 * En este contexto, name = "id" indica que la columna id en la entidad actual se utilizará
	 * como la clave foránea para establecer la relación con la entidad Detalles_cliente
	 * 
	 * IMPORTANTE: hibernet no crea la clave foranea
	 */
	
	/*
	 * Si cambio la anotación @JoinColumn(name = "id") a @JoinColumn(name = "ddd"),
	 * estaría indicando que la columna que actúa como clave foránea para establecer
	 * la relación entre la entidad actual y Detalles_cliente es la columna llamada ddd (si no existe la crea) en lugar de id.
	 */
	
	@JoinColumn(name = "id") 
	private Detalles_cliente detalles = null;
	
	
	
	//indica quien es la clave foranea en la otra entidad
	@OneToMany( mappedBy = "cliente", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH} ) 
	private List<Pedido> pedidos = new ArrayList<Pedido>();
	
	
	
	public Cliente() {
	}
	
	
	public Cliente(String nombre, String apellido, String direccione) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccione = direccione;
	}


	@Override
	public String toString() {
		return "Clientes ==>> [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", direccione=" + direccione
				+ "]";
	}

	
	public void agregarPedidos(Pedido pedido) {
		this.pedidos.add(pedido);
		pedido.setCliente(this);
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
	public Detalles_cliente getDetalles() {
		return detalles;
	}
	public void setDetalles(Detalles_cliente detalles) {
		this.detalles = detalles;
	}


	public List<Pedido> getPedidos() {
		return pedidos;
	}


	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	
	
}
