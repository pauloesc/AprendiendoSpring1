package relacionEntreTablasUnoAmuchos;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Principal2 {

	public static void main(String[] args) {

		SessionFactory MiFabricaDeSessiones = 	new Configuration()
												.configure("hibernate2.cfg.xml")
												.addAnnotatedClass(Cliente.class)
												.addAnnotatedClass(Detalles_cliente.class)
												.addAnnotatedClass(Pedido.class)
												.buildSessionFactory();
		
		Session miSession = MiFabricaDeSessiones.openSession();
		
		try {
			
			Cliente c1 = new Cliente("cliente1","cliente1","cliente1");
			Detalles_cliente dc1 = new Detalles_cliente("d-cliente1", "d-cliente1", "d-cliente1");
			Pedido p1 = new Pedido( new Date(), "master");
			Pedido p2 = new Pedido( new Date(), "master2");
//			asociar a los pedidos el cliente
			p1.setCliente(c1);
			p2.setCliente(c1);
//			asociar cliente y pedidos
			c1.agregarPedidos(p1);
			c1.agregarPedidos(p2);
			//asocia cliente y detalles_cliente
			c1.setDetalles(dc1);			
			dc1.setCliente(c1);
			
			miSession.beginTransaction();
			//miSession.save(dc1); //no es necesario
			miSession.save(c1);
			
			//creo que lo siguiente si es necesario ya que no hay un metodo en cliente para garcar pedido
			//si hay un metodo para caprgar una lista de pedidos
			//de lo que si estoy seguro es que son necesarias las siguientes lineas
			miSession.save(p1);
			miSession.save(p2);
			miSession.getTransaction().commit();
			miSession.close();
			
			miSession = MiFabricaDeSessiones.openSession();
			Cliente c = miSession.get(Cliente.class, 1);
			List<Pedido> lpc = c.getPedidos();
			for (Pedido pedido : lpc) {
				System.out.println(pedido.getId());
			}
			miSession.close();
			
			
		} finally {
			// TODO: handle finally clause
		}
		
		
		
	}

}