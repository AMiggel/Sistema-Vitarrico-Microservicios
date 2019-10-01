package co.com.vitarrico.app.inventario.dominio.servicio.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.vitarrico.app.inventario.persistencia.entidad.EntidadProducto;
import co.com.vitarrico.app.inventario.persistencia.repositorio.producto.IRepositorioProducto;
import co.com.vitarrico.app.inventario.dominio.excepcion.ExcepcionInventario;
import co.com.vitarrico.app.inventario.dominio.servicio.IServicioProducto;

@Service
public class ServicioProducto implements IServicioProducto {

	public static final String PRODUCTO_INEXISTENTE = "El producto no existe en la base de datos";
	public static final String CANTIDAD_CREADA_INVALIDA = "Debe ingresar una cantidad válida";

	@Autowired
	private IRepositorioProducto repositorioProducto;

	@Override
	public List<EntidadProducto> listar() {
		return repositorioProducto.findAll();
	}

	@Override
	public EntidadProducto crearProducto(EntidadProducto producto) {

		producto.setCantidadDisponible(producto.getCantidadCreada());
		EntidadProducto productoExistente = repositorioProducto.findByNombre(producto.getNombre());
		int disponible = 0;

		if (producto.getCantidadCreada() <= 0) {
			throw new ExcepcionInventario(CANTIDAD_CREADA_INVALIDA);
		}
		if (productoExistente != null) {
			productoExistente.setCantidadCreada(producto.getCantidadCreada());
			disponible = productoExistente.getCantidadDisponible() + producto.getCantidadCreada();
			productoExistente.setCantidadDisponible(disponible);
			return repositorioProducto.save(productoExistente);
		} else {
			asignarFechaCreacion(producto);
			return repositorioProducto.save(producto);
		}
	}

	@Override
	public EntidadProducto buscarProductoPorId(Long id) {
		EntidadProducto producto = repositorioProducto.findById(id).orElse(null);

		if (producto == null) {
			throw new ExcepcionInventario(PRODUCTO_INEXISTENTE);
		} else {
			return producto;
		}
	}

	@Override
	public void borrarProducto(Long id) {
		buscarProductoPorId(id);
		repositorioProducto.deleteById(id);
	}

	@Override
	public EntidadProducto modificarProducto(Long id, EntidadProducto producto) {
		EntidadProducto productoActual = buscarProductoPorId(id);
		Integer diferencia = 0;
		Integer disponible = 0;

		if (producto.getCantidadDisponible() == 0) {
			diferencia = producto.getCantidadCreada() - productoActual.getCantidadCreada();
			disponible = productoActual.getCantidadDisponible() + diferencia;
			productoActual.setCantidadCreada(producto.getCantidadCreada());
			productoActual.setCantidadDisponible(disponible);
	
		} else {
			productoActual.setCantidadDisponible(producto.getCantidadDisponible());
		}

		return repositorioProducto.save(productoActual);
	}

	public void asignarFechaCreacion(EntidadProducto producto) {
		producto.setFechaCreacion(Calendar.getInstance().getTime());
	}

}
