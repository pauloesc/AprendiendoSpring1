package miPrograma.objetosDAO;

import java.util.List;
import entidades.Cliente;

public interface Cliente_DAO {

	public List<Cliente> getClientes();

	public void setInsertarCliente(Cliente clienteWeb);

	public Cliente getClienteId(int id);

	public void modificar(Cliente clienteModificar);
	
}
