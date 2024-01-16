package programacionOrientadaAaspectos.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration //indica que es una clase para hacer configuraciones
@EnableAspectJAutoProxy //indica que vamos a usar programacion orientada a aspectos
@ComponentScan("programacionOrientadaAaspectos") //indica donde ir a buscar los aspectos
public class Configuracion {

}
