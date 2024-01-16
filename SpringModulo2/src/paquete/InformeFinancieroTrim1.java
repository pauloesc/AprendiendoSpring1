package paquete;

import org.springframework.stereotype.Component;

@Component
public class InformeFinancieroTrim1 implements CreacionInformeFinanciero {

	@Override
	public String getInformeFinanciero() {
		return "presentacion de informe financiero del trimestre 1";
	}
	
}
