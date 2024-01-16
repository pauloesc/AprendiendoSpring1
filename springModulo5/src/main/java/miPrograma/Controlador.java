package miPrograma;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import entidades.Cliente;
import miPrograma.objetosDAO.Cliente_DAO;

@Controller
@RequestMapping("/cliente")
public class Controlador {
	
	@GetMapping("/lista")
	public String listaClientes( Model m ){
		List<Cliente> lc = this.clienteDatos.getClientes();
		m.addAttribute("clientes", lc);
		return "lista-clientes";
	}


	@GetMapping("/formularioNuevoCliente")
	public String formularioParaNuevoCliente( Model m ) {
		Cliente c = new Cliente();
		m.addAttribute("cliente", c);
		return "formularioNuevoCliente";
	}
	
	
	@PostMapping("/insertarCliente")
	public String insertarClientee( @ModelAttribute("cliente") Cliente clienteWeb){
		clienteDatos.setInsertarCliente(clienteWeb);
		return "redirect:/cliente/lista";
	}
	
	
	@GetMapping("/vistaModificar")	
	public String vistaModificarCliente( @RequestParam("id") int id,  Model m ) {
		Cliente c = this.clienteDatos.getClienteId(id);
		m.addAttribute("cliente", c);
		return "vistaModificar";
	}
	
	
	@PostMapping("/modificarCliente")
	public String modificarClientee( @ModelAttribute("cliente") Cliente clienteModificar){
		clienteDatos.modificar(clienteModificar);
		return "redirect:/cliente/lista";
	}
	
	//inyeccion de objetos de tipos Cliente_DAO
	@Autowired
	private Cliente_DAO clienteDatos;

}


