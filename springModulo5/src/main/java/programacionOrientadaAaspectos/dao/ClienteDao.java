package programacionOrientadaAaspectos.dao;

import org.springframework.stereotype.Component;

@Component
public class ClienteDao {

	public void insertarCliente() {
		System.out.println("insertar cliente");
	}
	
	public String insertarClienteConParametros(String texto, int numero) {
		System.out.println("insertar cliente con parametros");
		return "retorno texto ";
	}
	
	
	public void lanzaException() {
		System.out.println("dentro de lanzar exception");
		throw new RuntimeException("error lanzado !!!!!");
	}
	
	
	public void antesyDespues() {
		
		System.out.println("1");
		System.out.println("2");
	}
	
}
