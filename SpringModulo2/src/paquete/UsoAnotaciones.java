package paquete;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsoAnotaciones {

	public static void main(String[] args) {

		
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		ComercialExperimentado persona1 = ac.getBean("comercial_e", ComercialExperimentado.class);
		
		System.out.println(persona1.getTareas());
		System.out.println(persona1.getInforme());
		
		ac.close();
		
		System.out.println("-----------------");
		
		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		ComercialExperimentado p1 = ac.getBean("comercial_e", ComercialExperimentado.class);
		ComercialExperimentado p2 = ac.getBean("comercial_e", ComercialExperimentado.class);
		if (p1==p2) {
			System.out.println("Iguales");
			}
		else {
			System.out.println("Diferentes");
			}
		
		ac.close();
		
	}

}
