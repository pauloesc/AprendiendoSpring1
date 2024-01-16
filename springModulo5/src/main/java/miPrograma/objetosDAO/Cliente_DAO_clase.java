package miPrograma.objetosDAO;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entidades.Cliente;


@Repository //sirve para que "Cliente_DAO_clase" pueda ser interpretado como un bean por spring. 

public class Cliente_DAO_clase implements Cliente_DAO {

	/*
	 * Cuando anotas un método con @Transactional en Spring, estás indicando que ese método
	 * debe ejecutarse dentro de una transacción. Spring gestiona automáticamente la creación,
	 * confirmación y reversión de la transacción.
	 * 
	 */
	
	@Override
	@Transactional
	public List<Cliente> getClientes() {

		//obtener la session
		
		/*
		 * Se puede sacar @Transactional pero tengo ue usar 
		 * Session miSesion = this.sessionFactory.openSession();
		 * con
		 * miSesion.beginTransaction();
		 * mas
		 * miSesion.close();
		 */
		Session miSesion = this.sessionFactory.getCurrentSession();
		
		CriteriaBuilder builder = miSesion.getCriteriaBuilder();
	    CriteriaQuery<Cliente> criteriaQuery = builder.createQuery(Cliente.class);
	    Root<Cliente> tabla = criteriaQuery.from(Cliente.class);
	    criteriaQuery.select(tabla);
	    List<Cliente> resultList = miSesion.createQuery(criteriaQuery).getResultList();
	    
		return resultList;
	}

	
	//inyeccion de dependencia de tipo SessionFactory
	//la variable se llama igual al bean que esta definido en el xml
	@Autowired
	private SessionFactory sessionFactory;


	@Override
	@Transactional
	public void setInsertarCliente(Cliente clienteWeb) {
		Session miSesion = this.sessionFactory.getCurrentSession();
		miSesion.save(clienteWeb);
		
	}


	@Override
	@Transactional
	public Cliente getClienteId(int id) {
		Session miSesion = this.sessionFactory.getCurrentSession();
		return miSesion.get(Cliente.class, id);
	}


	@Override
	@Transactional
	public void modificar(Cliente clienteModificar) {
		Session miSesion = this.sessionFactory.getCurrentSession();
		//Cliente c = miSesion.get(Cliente.class, clienteModificar.getId());
		//System.out.println(clienteModificar);
		miSesion.update(clienteModificar);		
	}
	
}
