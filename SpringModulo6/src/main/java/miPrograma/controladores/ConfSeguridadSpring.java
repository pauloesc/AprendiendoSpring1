package miPrograma.controladores;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class ConfSeguridadSpring extends WebSecurityConfigurerAdapter {

	
	@Autowired
	private DataSource seguridadDataSource; //el paquete es javax.sql
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
//		UserBuilder u = User.withDefaultPasswordEncoder();
//		
//		auth.inMemoryAuthentication()
//		.withUser(u.username("user1").password("123").roles("admin"))
//		.withUser(u.username("user2").password("234").roles("user"))
//		.withUser(u.username("user3").password("345").roles("ayudante"))
//		.withUser(u.username("user4").password("456").roles("admin"));

		//para que la aplicacion obtenga la configuracion de la autenticacion
		//tendra que mirar la variable pasada a la funcion
		//es importante que las tablas y las columnas tengan nombres especificos
		auth.jdbcAuthentication().dataSource(seguridadDataSource);
		
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		http
		.authorizeRequests()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
		.loginPage("/miFormularioLogin")
		.loginProcessingUrl("/urlLogin")
		.permitAll()
		.and()
		.logout()
		.permitAll();
		
		
//		sacado de chatgpt
//		
//        http
//        .authorizeRequests()
//            .antMatchers("/admin/**").hasAnyRole("ADMIN", "MANAGER")
//            .antMatchers("/user/**").hasRole("USER")
//            .anyRequest().authenticated() // Acceso permitido solo para usuarios autenticados
//            .and()
//        .formLogin()
//            .loginPage("/login")
//            .permitAll()
//            .and()
//        .logout()
//            .permitAll();
		
		
	}
	
}
