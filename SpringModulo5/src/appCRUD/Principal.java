package appCRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import programa.Clientes;

public class Principal {

	public static void main(String[] args) {
	
		
		SessionFactory MiFabricaDeSessiones = new Configuration().configure("hibernate2.cfg.xml").addAnnotatedClass(Clientes.class).buildSessionFactory();
		Session miSession = MiFabricaDeSessiones.openSession();
		

	}

}
