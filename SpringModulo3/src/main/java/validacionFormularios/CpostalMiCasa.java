package validacionFormularios;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CpostalMiCasa implements ConstraintValidator<Cpostal, String> {

	private String prefijoAlmacenadoEnAnotacion;
	
	@Override
	public void initialize(Cpostal elCodigo) {
		//para inicializar valores
			prefijoAlmacenadoEnAnotacion = elCodigo.value();
	}
	
	@Override
	//String value tiene el texto ingresado por el usuario en el formulario
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value != null && value.contains(this.prefijoAlmacenadoEnAnotacion) ) {
			return true;
		}
		else {
			return false;
		}
	}

	
}
