package co.com.vitarrico.app.clientes.dominio.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.vitarrico.app.clientes.dominio.servicio.IServicioCliente;
import co.com.vitarrico.app.clientes.persistencia.entidad.EntidadCliente;
import co.com.vitarrico.app.clientes.persistencia.repositorio.RepositorioCliente;

@Service
public class ServicioClienteImpl implements IServicioCliente{

	@Autowired
	RepositorioCliente repositorioCliente;
	
	@Override
	public List<EntidadCliente> listar() {
		return repositorioCliente.findAll();
	}

	@Override
	public EntidadCliente crearCliente(EntidadCliente cliente) {
		return repositorioCliente.save(cliente);
	}

	@Override
	public EntidadCliente buscarClientePorId(Long id) {
		return repositorioCliente.findById(id).orElse(null);
	}

	@Override
	public void borrarCliente(Long id) {
		repositorioCliente.deleteById(id);
	}

	@Override
	public EntidadCliente modificarCliente(Long id, EntidadCliente cliente) {
		EntidadCliente clienteActual = buscarClientePorId(id);
		clienteActual.setFacturas(cliente.getFacturas());
		return repositorioCliente.save(clienteActual);
	}

}
