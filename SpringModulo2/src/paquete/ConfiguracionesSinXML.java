package paquete;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//lineas para configurar el proyecto (no mas xml)
@Configuration
@ComponentScan("paquete")
@PropertySource("classpath:valor.properties")
public class ConfiguracionesSinXML {

	{System.out.println("fdnjdsnbihsudnbfiuhdsnbfiudshnbf");}
	
	/*
	 * definir el bean Informe-Financiero-Compras
	 * el nombre del bean sera: id_informeFinancieroDepartamentoCompras
	 */
	@Bean
	CreacionInformeFinanciero id_informeFinancieroDepartamentoCompras() {
		return new InformeFInancieroCompras();
	}
	
	
	
	/*
	 * definicion del bean direcctor financiero
	 */
	@Bean
	public Empleados id_director_financier() {
		return new DirectorFinanciero( id_informeFinancieroDepartamentoCompras() );
	}
		
		
	
}
