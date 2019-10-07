package co.com.vitarrico.app.clientes.dominio.servicio;

import java.util.List;

import co.com.vitarrico.app.clientes.persistencia.entidad.EntidadCliente;
import co.com.vitarrico.app.clientes.persistencia.entidad.feign.EntidadFactura;


public interface IServicioCliente {
	
	public List<EntidadCliente> listar();

	public EntidadCliente crearCliente(EntidadCliente cliente);

	public EntidadCliente buscarClientePorId(Long id);

	public void borrarCliente(Long id);

	public EntidadCliente asignarFacturaACliente(Long id, EntidadCliente cliente);
	
}
