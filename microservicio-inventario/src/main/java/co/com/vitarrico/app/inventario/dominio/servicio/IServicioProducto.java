package co.com.vitarrico.app.inventario.dominio.servicio;

import java.util.List;

import co.com.vitarrico.app.inventario.persistencia.entidad.EntidadProducto;

public interface IServicioProducto {

	public List<EntidadProducto> listar();
	
	public EntidadProducto crearProducto(EntidadProducto producto);
	public EntidadProducto buscarProductoPorId(Long id);
	public void borrarProducto(Long id);
	public EntidadProducto modificarProducto(Long id, EntidadProducto producto);

}
