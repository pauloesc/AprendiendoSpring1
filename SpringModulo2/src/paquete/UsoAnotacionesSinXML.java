package paquete;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UsoAnotacionesSinXML {

	public static void main(String[] args) {
	
		//como iniciar cuando el archivo de configuracion esta en una clase y no en el xml
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ConfiguracionesSinXML.class);
		ComercialExperimentado persona1 = ac.getBean("comercial_e", ComercialExperimentado.class);
		
		System.out.println(persona1.getTareas());
		System.out.println(persona1.getInforme());
		ac.close();
		
		System.out.println("-----------------");
		
		ac = new AnnotationConfigApplicationContext(ConfiguracionesSinXML.class);
		Empleados persona2 = ac.getBean("id_director_financier", Empleados.class);
		System.out.println(persona2.getInforme());
		System.out.println(persona2.getTareas());
		ac.close();
		
		System.out.println("-----------------");
		
		ac = new AnnotationConfigApplicationContext(ConfiguracionesSinXML.class);
		Empleados persona3 = ac.getBean("otroEmpleado", Empleados.class);
		System.out.println(persona3.getInforme());
		System.out.println(persona3.getTareas());
		System.out.println( ((OtroEmpleado) persona3).getNombre() );
		ac.close();
		
		
		
		
	}

}



