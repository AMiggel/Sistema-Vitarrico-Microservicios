package co.com.vitarrico.app.inventario.dominio.servicio;

import java.util.List;

import com.vitarrico.app.comun.entidad.EntidadProducto;



public interface IServicioProducto {

	public List<EntidadProducto> listar();

	/**
	 * Permite crear un producto nuevo
	 * 
	 * @param usuario
	 * @return la entidad del producto
	 */
	public EntidadProducto crearProducto(EntidadProducto producto);

	/**
	 * Permite buscar un producto ya creado por id
	 * 
	 * @param id
	 * @return la entidad del producto
	 */
	public EntidadProducto buscarProductoPorId(Long id);

	public void borrarProducto(Long id);

	public EntidadProducto modificarProducto(Long id, EntidadProducto producto);

	public EntidadProducto modificarCantidadDisponible(Long id, EntidadProducto producto);
	
	public EntidadProducto buscarProductoPorNombre(String nombre);
}
