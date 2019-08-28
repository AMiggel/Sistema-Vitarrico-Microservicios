package co.com.vitarrico.app.facturacion.dominio.servicio.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.vitarrico.app.facturacion.dominio.dto.factura.FacturaDto;
import co.com.vitarrico.app.facturacion.dominio.dto.feign.Producto;
import co.com.vitarrico.app.facturacion.dominio.servicio.IServicioFactura;
import co.com.vitarrico.app.facturacion.dominio.servicio.feign.ProductoClienteFeign;
import co.com.vitarrico.app.facturacion.persistencia.entidad.EntidadFactura;
import co.com.vitarrico.app.facturacion.persistencia.entidad.EntidadItemFactura;
import co.com.vitarrico.app.facturacion.persistencia.mapper.FacturaMapper;
import co.com.vitarrico.app.facturacion.persistencia.repositorio.factura.RepositorioFactura;
import co.com.vitarrico.app.facturacion.persistencia.repositorio.item.IRepositorioItemFactura;

@Service
public class ServicioFacturaImpl implements IServicioFactura {

	@Autowired
	private RepositorioFactura repositorioFactura;

	@Autowired
	private FacturaMapper facturaMapper;

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

		List<EntidadItemFactura> items = new ArrayList<EntidadItemFactura>();
		for (int i = 0; i < factura.getIdProducto().length; i++) {
			EntidadItemFactura item = new EntidadItemFactura();
			Producto producto = productoClienteFeign.buscarProductoPorId(factura.getIdProducto()[i]);
			item.setNombreProducto(producto.getNombre());
			item.setPrecioProducto(producto.getPrecio());
			item.setCantidad(factura.getCantidadProducto()[i]);
			items.add(item);
			factura.setItems(items);
			repositorioItemFactura.save(item);
		}

		Calendar fecha = Calendar.getInstance();
		factura.setFechaCreacion(fecha.getTime());
		return repositorioFactura.save(facturaMapper.mappearDtoAEntidad(factura));
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
	
	public void modificarCantidadProductosDisponibles (Producto producto) {
		productoClienteFeign.modificarProducto(producto.getId(), producto);
		
	}

}
