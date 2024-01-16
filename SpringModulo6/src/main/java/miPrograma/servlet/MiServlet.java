package miPrograma.servlet;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import miPrograma.configuracion.Configuracion;

public class MiServlet extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		//especificamos donde esta la configuracion
		return new Class[] {Configuracion.class};
	}

	@Override
	protected String[] getServletMappings() {
		
		//en que ruta escucha el servlet
		return new String[] {"/"};
	}

}
