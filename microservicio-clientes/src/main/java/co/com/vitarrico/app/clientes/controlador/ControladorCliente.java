package co.com.vitarrico.app.clientes.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vitarrico.app.comun.entidad.EntidadCliente;

import co.com.vitarrico.app.clientes.dominio.servicio.IServicioCliente;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="/clientes")
public class ControladorCliente {
	
	@Autowired
	IServicioCliente servicioCliente;
	
	@GetMapping
	public List<EntidadCliente> listarClientes() {
		return servicioCliente.listar();
	}
	
	@PostMapping(value="/crear-cliente")
	public EntidadCliente crearCliente(@RequestBody EntidadCliente cliente) {
		return servicioCliente.crearCliente(cliente);
	}
	
	@GetMapping(value="/{id}")
	public EntidadCliente buscarCliente(@PathVariable (value="id") Long id) {
		return servicioCliente.buscarClientePorId(id);
	}

	@PutMapping(value="modificar-cliente/{id}")
	public EntidadCliente modificarCliente(@PathVariable (value="id")Long id, @RequestBody EntidadCliente cliente) {
		return servicioCliente.asignarFacturaACliente(id, cliente);
	}

}
