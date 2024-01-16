package relacionEntreTablasUnoAUnoUnidireccional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="detalles_cliente")
public class Detalles_cliente {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_dc")
	private int id_dc;
	
	@Column(name="web")
	private String  web;
	
	@Column(name="telefono")
	private String  telefono;
	
	@Column(name="direccion")
	private String  direccion;
	
	
	
	
	
	public Detalles_cliente() {
	}

	public Detalles_cliente(String web, String telefono, String direccion) {
		this.web = web;
		this.telefono = telefono;
		this.direccion = direccion;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}
