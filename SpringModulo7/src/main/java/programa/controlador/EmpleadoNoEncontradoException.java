package programa.controlador;

public class EmpleadoNoEncontradoException extends RuntimeException {

	/*
	 * RECORDAR QUE LOS CONSTRUCORES NO SE HEREDAN, NECESITO CREAR CONSTRUCORES PARA ESTA CLASE.
	 */
	
	private static final long serialVersionUID = 1L;

	public EmpleadoNoEncontradoException() {
		super();
	}

	public EmpleadoNoEncontradoException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public EmpleadoNoEncontradoException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public EmpleadoNoEncontradoException(String arg0) {
		super(arg0);
	}

	public EmpleadoNoEncontradoException(Throwable arg0) {
		super(arg0);
	}

	
	
}
