package programacionOrientadaAaspectos.aspectos;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoginConAspecto {

	
	/*
	 * si solo escribimos @Before("execution(public void insertarCliente())"),
	 * el metodo antesInsertar() se ejecutara antes de cualquier metodo
	 * llamado insertarCliente() independientemente de a que clase pertenezca 
	 */
	
	/*
	 * si solo escribimos @Before("execution(public void insertar*())"),
	 * el metodo antesInsertar() se ejecutara antes de cualquier metodo
	 * llamado insertar[lo que sea]() independientemente de a que clase pertenezca 
	 */
	
	/*
	 * tambien funciona @Before("execution(public * insertar*())")
	 * se saco el tipo de retorno de la funcion y se pueso un *
	 */
	
	/*
	 *	tambien funciona @Before("execution(public * insertar*(..))")
	 *	funciona con cualquier tipo de retorno y cualquier parametro
	 */
	
	@Before("execution(public void programacionOrientadaAaspectos.dao.ClienteDao.insertarCliente())")
	public void antesInsertar() {
		System.out.println("antes de insertar");
	}
	
	
	
	//como reutilizar @before
	@Pointcut("execution(public void programacionOrientadaAaspectos.dao.ClienteDao.insertarCliente())")
	private void paraClientes() {}
	
	@Before("paraClientes()")
	public void antesInsertar2() {
	}
	@Before("paraClientes()")
	public void antesInsertar3() {
	}
	
	/*
	 * IMPORTANTE: el orden de ejecucion de los metodos esta dado por el orden el el codigo, osea,
	 * primero se ejecuta el primer etodo declarado, etc.
	 */
	
	
	//como recuperar los parametros
	@Before("execution(public String insertarClienteConParametros(String, int))")
	public void antesInsertarConParametros(JoinPoint mijoin) {		
		Object[] argss = mijoin.getArgs();
		
		String a = (String) argss[0];
		int b = (int) argss[1];
		System.out.println("texto: " + a + " " + "numero: " + b);
		
	}
	
//	La anotación @AfterReturning se utiliza para especificar métodos que deben ejecutarse
//	después de que un método de destino ha sido ejecutado exitosamente y ha retornado un valor.
	@AfterReturning( pointcut = "execution(public String insertarClienteConParametros(String, int))", returning = "s" )
	public void aaaaaaaa(String s) {
		System.out.println("desde el after-returing");
	}
	
	@AfterThrowing(pointcut = "execution(public void lanzaException())", throwing = "error")
	public void despuesdeException(Throwable error) {
		
		System.out.println("<=======");
		System.out.println(error.getMessage());
		System.out.println("=======>");
		System.out.println("procesando el error lanzado");
		
	}
	
//    La anotación @After se utiliza para especificar métodos que deben ejecutarse después de que un método
//    de destino haya sido ejecutado, independientemente de si el método ha terminado exitosamente o
//    ha lanzado una excepción.
//    No puedes acceder directamente al valor retornado por el método de destino utilizando @After.
	@After("execution(public String insertarClienteConParametros(String, int))")
	public void afterAdvice() {
		System.out.println("after");
	}
	
	
	@Around("execution(public void antesyDespues())")
	public void antesYdespues(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("3");
		joinPoint.proceed();
		throw new RuntimeException("eee");
		//System.out.println("4");
	}
	
	@AfterThrowing(pointcut = "execution(public void antesyDespues())", throwing = "error")
	public void despuesdeException2(Throwable error) {
		
		System.out.println("<===2====");
		System.out.println(error.getMessage());
		System.out.println("====2===>");
		System.out.println("procesando el error lanzado");
		
	}
	
}
