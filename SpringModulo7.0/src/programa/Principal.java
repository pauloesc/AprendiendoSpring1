package programa;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Principal {

	public static void main(String[] args) {
	
		ObjectMapper mapeador = new ObjectMapper();
		
		File json = new File("datosJason/cliente.json");
		
		try {
			Empleado e = mapeador.readValue(json, Empleado.class);
			System.out.println(e.getNombre());
			
			String[] idioms = e.getIdiomas();
			for (String texto : idioms) {
				System.out.println(texto);
			}
			
			System.out.println(e.getDatos_registroo());
			
		} catch (Exception ee) {
			ee.printStackTrace();
		}
		finally {
		}

	}

}
