package co.com.vitarrico.app.clientes.dominio.servicio.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.vitarrico.app.clientes.dominio.excepcion.ExcepcionClientes;
import co.com.vitarrico.app.clientes.dominio.servicio.IServicioCliente;
import co.com.vitarrico.app.clientes.persistencia.entidad.EntidadCliente;
import co.com.vitarrico.app.clientes.persistencia.repositorio.RepositorioCliente;

@Service
public class ServicioClienteImpl implements IServicioCliente {

	public static final String YA_EXISTE_CON_ESTE_NOMBRE_Y_APELLIDO = "Ya hay un cliente registrado con el mismo nombre y apellido";
	public static final String CLIENTE_NO_EXISTE = "No se encuentra este cliente";

	@Autowired
	RepositorioCliente repositorioCliente;

	@Override
	public List<EntidadCliente> listar() {
		return repositorioCliente.findAll();
	}

	@Override
	public EntidadCliente crearCliente(EntidadCliente cliente) {
		EntidadCliente clienteExistente = repositorioCliente.findByNombreAndApellido(cliente.getNombre(),
				cliente.getApellido());
		if (clienteExistente != null) {
			throw new ExcepcionClientes(YA_EXISTE_CON_ESTE_NOMBRE_Y_APELLIDO);
		} else {
			asignarFechaCreacion(cliente);
			return repositorioCliente.save(cliente);
		}
	}

	@Override
	public EntidadCliente buscarClientePorId(Long id) {

		EntidadCliente cliente = repositorioCliente.findById(id).orElse(null);
		if (cliente == null) {
			throw new ExcepcionClientes(CLIENTE_NO_EXISTE);
		} else {
			return cliente;
		}
	}

	@Override
	public void borrarCliente(Long id) {
		buscarClientePorId(id);
		repositorioCliente.deleteById(id);
	}

	@Override
	public EntidadCliente asignarFacturaACliente(Long id, EntidadCliente cliente) {
		System.out.println(cliente.getFacturas().iterator().next().getItems());
		return repositorioCliente.save(cliente);
	}
	

	public void asignarFechaCreacion(EntidadCliente cliente) {
		cliente.setFechaCreacion(Calendar.getInstance().getTime());
	}

}
