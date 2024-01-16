package programa;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Principal {

	public static void main(String[] args) {
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("YourPersistenceUnitName");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        entityManager.close();
//        entityManagerFactory.close();
		
		//.addAnnotatedClass(null) especifica con que clase vamos a trabajar
		SessionFactory MiFabricaDeSessiones = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Clientes.class).buildSessionFactory();
		Session miSession = MiFabricaDeSessiones.openSession();
		

		try {
			Clientes c1 = new Clientes("paulo","sanchez","ciudad a");
			Clientes c2 = new Clientes("noel","cuello","ny");
			miSession.beginTransaction();
			miSession.save(c1);
			miSession.save(c2);
			miSession.getTransaction().commit();
			System.out.println(miSession.get(Clientes.class, c1.getId()).toString());
		} finally {
			miSession.close();
		}
		
		
		System.out.println("------------");
		
		
		try {
			miSession = MiFabricaDeSessiones.openSession();
			/*
			 * en la consulta hql observar que puse nombre y no Nombre.
			 * nombre (sin mayuscula) es el nombre de la variable en mi clase Clientes
			 */
			String hql = "from Clientes alias_del_cliente where alias_del_cliente.nombre='paulo'";
			List<Clientes> lista = miSession.createQuery(hql).getResultList();
			imprimirListaClientes(lista);
		} finally {
			miSession.close();
		}
		
		
		System.out.println("------------");
		
		
		try {
			miSession = MiFabricaDeSessiones.openSession();
			String hql = "from Clientes alias_del_cliente where alias_del_cliente.nombre='paulo' or alias_del_cliente.direccione='ciudad a'";
			List<Clientes> lista = miSession.createQuery(hql, Clientes.class).getResultList();
			imprimirListaClientes(lista);
		} finally {
			miSession.close();
		}
		
		System.out.println("------------");
		
		//actualizar cliente (con id 1)
		try {
			miSession = MiFabricaDeSessiones.openSession();
			miSession.beginTransaction();
			Clientes c1 = miSession.get(Clientes.class, 1);
			c1.setDireccione("sydney");
			miSession.getTransaction().commit();
			
			String hql = "from Clientes";
			List<Clientes> lista = miSession.createQuery(hql).getResultList();
			imprimirListaClientes(lista);
		} finally {
			miSession.close();
		}
		
		System.out.println("-----....-------");
		
		
		/*
		 * para mas informacion 
		 * https://rubensa.wordpress.com/2016/06/10/tutorial-de-jpa-2-criteria-api/
		 */
		try {
			miSession = MiFabricaDeSessiones.openSession();
			CriteriaBuilder builder = miSession.getCriteriaBuilder();
			/*
			 * se está creando un objeto CriteriaQuery, que es una representación de una consulta a
			 * la base de datos utilizando Criteria API.
			 * La consulta se configurará para RETORNAR instancias de la clase Clientes.
			 */
		    CriteriaQuery<Clientes> criteriaQuery = builder.createQuery(Clientes.class);
		    
		    //FROM
		    Root<Clientes> tabla = criteriaQuery.from(Clientes.class);
		    criteriaQuery.select(tabla);
		    
		    //CLAUSALAS PARA WHERE
		    Predicate predicate = builder.equal( tabla.get("nombre"), "noel" );
		    Predicate predicate2 = builder.equal( tabla.get("direccione"), "ny" );
		    Predicate pAnd = builder.and(predicate,predicate2); // UNO LOS PREDICADOS
		    criteriaQuery.where(predicate);
		    
		    List<Clientes> resultList = miSession.createQuery(criteriaQuery).getResultList();
			imprimirListaClientes(resultList);
		} finally {
			miSession.close();
		}
		
		System.out.println("------------");
		
		
		try {
			miSession = MiFabricaDeSessiones.openSession();
			miSession.beginTransaction();
			CriteriaBuilder builder = miSession.getCriteriaBuilder();
			CriteriaUpdate<Clientes> actualizarClientes = builder.createCriteriaUpdate(Clientes.class);
			//from
			Root<Clientes> tabla = actualizarClientes.from(Clientes.class);
			
			//update
			actualizarClientes.set("direccione", "Brazil");
			
			//where
		    Predicate predicate = builder.equal( tabla.get("nombre"), "noel" );
		    actualizarClientes.where(predicate);
			
		    miSession.createQuery(actualizarClientes).executeUpdate();
		    miSession.getTransaction().commit();
		    
		    //ahora voy a imprimir la base de datos
			String hql = "from Clientes";
			List<Clientes> lista = miSession.createQuery(hql).getResultList();
			imprimirListaClientes(lista);
			
		} finally {
			miSession.close();
		}
		
		System.out.println("------------");
		
	}

	private static void imprimirListaClientes(List<Clientes> lista) {
		for (Clientes clientes : lista) {
			System.out.println(clientes.toString());
		}
	}

}
