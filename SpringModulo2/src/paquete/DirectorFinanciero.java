package paquete;

public class DirectorFinanciero implements Empleados {

	@Override
	public String getTareas() {
		return "gestion y direccion de las operaciones financiera de la empresa";
	}

	@Override
	public String getInforme() {
		return informeFinanciero.getInformeFinanciero();
	}
	
	private CreacionInformeFinanciero informeFinanciero;

	
	public DirectorFinanciero(CreacionInformeFinanciero informeFinanciero) {
		this.informeFinanciero = informeFinanciero;
	}
	
	

}
