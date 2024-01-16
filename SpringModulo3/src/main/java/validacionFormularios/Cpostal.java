package validacionFormularios;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

//@Constraint(validatedBy = nombre de clase con logica de validacion.class)
@Constraint(validatedBy = CpostalMiCasa.class)

//indica sobre que se `pueden aplicar la anotacion
@Target({ElementType.METHOD, ElementType.FIELD})

//Especifica cuando se va a chequear si la anotacion se cumple o no
@Retention(RetentionPolicy.RUNTIME)
public @interface Cpostal {

	//mensaje por defecto
	public String value() default "28";
	
	//mensaje de error cuando se incumpla la validacion
	public String message() default "error personal";
	
	
	//no lo use
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	
	
}
