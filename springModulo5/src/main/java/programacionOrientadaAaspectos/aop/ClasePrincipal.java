package programacionOrientadaAaspectos.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import programacionOrientadaAaspectos.dao.ClienteDao;

public class ClasePrincipal {

	public static void main(String[] args) {
	
		AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext( Configuracion.class );
		//obtener el bean clienteDao
		// "clienteDao" es el nombre de la clase comenzando en minuscula
		ClienteDao elCliente = contexto.getBean("clienteDao", ClienteDao.class);
		
		//insertar cliente
		elCliente.insertarCliente();
		System.out.println("");
		
		elCliente.insertarClienteConParametros("hola", 5);
		System.out.println("");
		
		try {
			elCliente.lanzaException();
		}catch(Exception e) {
			System.out.println("dentro del catch");
		}
		System.out.println("");
		
		try {
			elCliente.antesyDespues();
		}catch(Exception e) {
			System.out.println("dentro del exception");
		}
		//cerrar contexto
		contexto.close();
	}
}
