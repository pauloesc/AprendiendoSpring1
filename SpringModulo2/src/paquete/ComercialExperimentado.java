package paquete;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//la anotacion @Component crea el bean
@Component("comercial_e")
//@Scope("prototype") esta comentado porque @PostConstruct y @PreDestroy no funcionan con @prototype
public class ComercialExperimentado implements Empleados{
	
	private CreacionInformeFinanciero informeFinanciero;
	
	@PostConstruct
	public void initt() {System.out.println("codigo de init");}
	
	@PreDestroy
	public void destroyy() {System.out.println("codigo de destruccion");}
	
	
	// hay que crear un constructor para que se pueda inyectar la dependencia
	//"informeFinanciero" cuando se cre el objeto.
	
	// @Autowired busca en todo el proyecto si hay alguna clase que implemente la
	// interface CreacionInformeFinanciero (que es la que esta en el constructor)
	// y si la encuentra es clase la que inyecta como dependencia.
	// Si hay mas de una clase que implementa la interface usamos "@Qualifier" y especificamos el nombre de la clase. 
	
	//observar que informeFinancieroTrim2 comienza en minuscula
	
	@Autowired
	public ComercialExperimentado( @Qualifier("informeFinancieroTrim2") CreacionInformeFinanciero informeFinanciero) {
		this.informeFinanciero = informeFinanciero;
	}
	
	//otra manera de inyectar la dependencia
	
	//@Autowired
	//public void setInformeFinanciero( @Qualifier("informeFinancieroTrim2") CreacionInformeFinanciero informeFinanciero) {
	//	this.informeFinanciero = informeFinanciero;
	//}

	
	//otra manera de inyectar la dependencia
	
	//@Autowired
	//@Qualifier("informeFinancieroTrim2")
	//private CreacionInformeFinanciero informeFinanciero;



	@Override
	public String getTareas() {
		return "vender vender y vender";
	}


	@Override
	public String getInforme() {
		return "informe generado por el c-e " + informeFinanciero.getInformeFinanciero();
	}
	

}
