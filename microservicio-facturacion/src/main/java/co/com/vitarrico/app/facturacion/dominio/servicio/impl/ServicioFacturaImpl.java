package co.com.vitarrico.app.facturacion.dominio.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.vitarrico.app.facturacion.dominio.dto.FacturaDto;
import co.com.vitarrico.app.facturacion.dominio.servicio.IServicioFactura;
import co.com.vitarrico.app.facturacion.dominio.servicio.feign.ProductoClienteFeign;

import co.com.vitarrico.app.facturacion.modelo.feign.Producto;
import co.com.vitarrico.app.facturacion.persistencia.entidad.EntidadFactura;
import co.com.vitarrico.app.facturacion.persistencia.entidad.EntidadItemFactura;
import co.com.vitarrico.app.facturacion.persistencia.repositorio.factura.RepositorioFactura;
import co.com.vitarrico.app.facturacion.persistencia.repositorio.item.IRepositorioItemFactura;


@Service
public class ServicioFacturaImpl implements IServicioFactura {

	@Autowired
	private RepositorioFactura repositorioFactura;

	@Autowired
	private ProductoClienteFeign productoClienteFeign;

	@Autowired
	private IRepositorioItemFactura repositorioItemFactura;

	@Override
	public List<EntidadFactura> listar() {
		return repositorioFactura.findAll();

	}

	@Override
	public EntidadFactura crearFactura(FacturaDto factura) {

		EntidadFactura entidadFactura = new EntidadFactura();
		entidadFactura.setDescripcion(factura.getDescripcion());
		entidadFactura.setObservacion(factura.getObservacion());
		
		List<EntidadItemFactura> items = new ArrayList<EntidadItemFactura>();
		for (int i = 0; i < factura.getIdProducto().length; i++) {
			EntidadItemFactura item = new EntidadItemFactura();
			Producto producto = productoClienteFeign.buscarProductoPorId(factura.getIdProducto()[i]);
			item.setNombreProducto(producto.getNombre());
			item.setPrecioProducto(producto.getPrecio());
			item.setCantidad(factura.getCantidadProducto()[i]);
			items.add(item);
			entidadFactura.setItems(items);
			repositorioItemFactura.save(item);
		}
		return repositorioFactura.save(entidadFactura);
	}

	@Override
	public EntidadFactura buscarFacturaPorId(Long id) {
		return repositorioFactura.findById(id).orElse(null);
	}

	@Override
	public void borrarFactura(Long id) {
		repositorioFactura.deleteById(id);
	}

	@Override
	public EntidadFactura modificarFactura(Long id, EntidadFactura factura) {
		return null;
	}

}
