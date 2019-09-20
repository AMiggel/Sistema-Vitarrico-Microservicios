package co.com.vitarrico.app.facturacion.dominio.servicio.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.vitarrico.app.facturacion.dominio.dto.factura.FacturaDto;
import co.com.vitarrico.app.facturacion.dominio.dto.feign.ProductoDto;
import co.com.vitarrico.app.facturacion.dominio.dto.item.ItemDto;
import co.com.vitarrico.app.facturacion.dominio.servicio.IServicioFactura;
import co.com.vitarrico.app.facturacion.dominio.servicio.feign.ProductoClienteFeign;
import co.com.vitarrico.app.facturacion.persistencia.entidad.EntidadFactura;
import co.com.vitarrico.app.facturacion.persistencia.mapper.FacturaMapper;
import co.com.vitarrico.app.facturacion.persistencia.mapper.ItemFacturaMapper;
import co.com.vitarrico.app.facturacion.persistencia.repositorio.factura.RepositorioFactura;
import co.com.vitarrico.app.facturacion.persistencia.repositorio.item.IRepositorioItemFactura;

@Service
public class ServicioFacturaImpl implements IServicioFactura {

	@Autowired
	private RepositorioFactura repositorioFactura;

	@Autowired
	private FacturaMapper facturaMapper;

	@Autowired
	private ItemFacturaMapper itemFacturaMapper;

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
		
		List<ItemDto> items= new ArrayList<ItemDto>();
		
		for(ItemDto itemDto: factura.getItems()) {
			ProductoDto producto = productoClienteFeign.buscarProductoPorId(itemDto.getIdProducto());
			repositorioItemFactura.save(itemFacturaMapper.mappearDtoAEntidad(itemDto));
			itemDto.setNombreProducto(producto.getNombre());
			itemDto.setPrecioProducto(producto.getPrecio());
			modificarCantidadProductosDisponibles(producto, itemDto);
			items.add(itemDto);
		}
	
		factura.setItems(items);

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

	public void modificarCantidadProductosDisponibles(ProductoDto producto, ItemDto item) {
		Integer restarCantidad = producto.getCantidadDisponible() - item.getCantidadProducto();
		producto.setCantidadDisponible(restarCantidad);
		productoClienteFeign.modificarProducto(producto.getId(), producto);

	}

}
