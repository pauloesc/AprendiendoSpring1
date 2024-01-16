package programa;

public class DatosEmpleados {
		
	private String domicilio;
	private String ciudad;
	private String codigoP;
	private String pais;
	
	public DatosEmpleados() {
		super();
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCodigoP() {
		return codigoP;
	}

	public void setCodigoP(String codigoP) {
		this.codigoP = codigoP;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "DatosEmpleados [domicilio=" + domicilio + ", ciudad=" + ciudad + ", codigoP=" + codigoP + ", pais="
				+ pais + "]";
	}
	
	
	
}
