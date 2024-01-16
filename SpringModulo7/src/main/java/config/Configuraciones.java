package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//indica que es una clase de configuracion
//las clases de configuraciones pueden definir beans
@Configuration

@EnableWebMvc
@ComponentScan("programa")
public class Configuraciones {

}
