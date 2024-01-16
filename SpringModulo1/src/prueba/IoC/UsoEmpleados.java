package prueba.IoC;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsoEmpleados{

	public static void main(String[] args) {
		
		/*
		 * ejemplo de IoC.
		 */
		ClassPathXmlApplicationContext Ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
		//getBean pide dos argumentos
		//el alias del bean
		//el nombre de la interface o superclase que retorna el bean
		Empleados Juan = Ioc.getBean("miEmpleado1", Empleados.class);
		System.out.println(Juan.getTareas());
		System.out.println(Juan.getInforme());
		Ioc.close();
		
		System.out.println("----");
		
		ClassPathXmlApplicationContext Ioc2 = new ClassPathXmlApplicationContext("applicationContext.xml");
		SecretarioEmpleado Marta = Ioc2.getBean("miEmpleado2", SecretarioEmpleado.class);
		System.out.println(Marta.getTareas());
		System.out.println(Marta.getInforme());
		System.out.println(Marta.getNombreEmpresa() );
		System.out.println(Marta.getEmail() );
		Ioc2.close();		
		
	}

}
