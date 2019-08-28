package co.com.vitarrico.app.inventario.dominio.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.vitarrico.app.inventario.modelo.EntidadProducto;
import co.com.vitarrico.app.inventario.dominio.servicio.IServicioProducto;
import co.com.vitarrico.app.inventario.repositorio.producto.IRepositorioProducto;

@Service
public class ServicioProducto implements IServicioProducto {

	@Autowired
	private IRepositorioProducto repositorioProducto;
	
	@Override
	public List<EntidadProducto> listar() {
		return repositorioProducto.findAll();
	}

	@Override
	public EntidadProducto crearProducto(EntidadProducto producto) {
		return repositorioProducto.save(producto);
	}

	@Override
	public EntidadProducto buscarProductoPorId(Long id) {
		return repositorioProducto.findById(id).orElse(null);
	}

	@Override
	public void borrarProducto(Long id) {
		repositorioProducto.deleteById(id);
	}

	@Override
	public EntidadProducto modificarProducto(Long id, EntidadProducto producto) {
		EntidadProducto productoAModificar= buscarProductoPorId(id);
		productoAModificar.setCantidadDisponible(producto.getCantidadDisponible());
		return repositorioProducto.save(productoAModificar);
	}

}
