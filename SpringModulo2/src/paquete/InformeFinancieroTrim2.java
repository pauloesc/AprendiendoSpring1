package paquete;

import org.springframework.stereotype.Component;


//si en component no indicamos nombre, el nombre va a ser el nombre de la clase comenzando con minuscula.
@Component
public class InformeFinancieroTrim2 implements CreacionInformeFinanciero {

	@Override
	public String getInformeFinanciero() {
		return "presentacion informe trim2";
	}

}
