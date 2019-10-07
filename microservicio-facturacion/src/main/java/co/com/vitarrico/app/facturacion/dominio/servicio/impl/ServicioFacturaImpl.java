package co.com.vitarrico.app.facturacion.dominio.servicio.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.vitarrico.app.facturacion.dominio.dto.factura.FacturaDto;
import co.com.vitarrico.app.facturacion.dominio.dto.feign.ClienteDto;
import co.com.vitarrico.app.facturacion.dominio.dto.feign.ProductoDto;
import co.com.vitarrico.app.facturacion.dominio.dto.item.ItemDto;
import co.com.vitarrico.app.facturacion.dominio.excepcion.ExcepcionFacturas;
import co.com.vitarrico.app.facturacion.dominio.servicio.IServicioFactura;
import co.com.vitarrico.app.facturacion.dominio.servicio.feign.ServicioClienteFeign;
import co.com.vitarrico.app.facturacion.dominio.servicio.feign.ServicioProductoFeign;
import co.com.vitarrico.app.facturacion.persistencia.entidad.EntidadFactura;
import co.com.vitarrico.app.facturacion.persistencia.mapper.FacturaMapper;
import co.com.vitarrico.app.facturacion.persistencia.mapper.ItemFacturaMapper;
import co.com.vitarrico.app.facturacion.persistencia.repositorio.factura.RepositorioFactura;
import co.com.vitarrico.app.facturacion.persistencia.repositorio.item.IRepositorioItemFactura;

@Service
public class ServicioFacturaImpl implements IServicioFactura {

	public static final String NO_HAY_PRODUCTOS_DISPONIBLES = "No hay productos disponibles del producto %s en el sistema";

	@Autowired
	private RepositorioFactura repositorioFactura;

	@Autowired
	private FacturaMapper facturaMapper;

	@Autowired
	private ItemFacturaMapper itemFacturaMapper;

	@Autowired
	private ServicioProductoFeign servicioProductoFeign;

	@Autowired
	private ServicioClienteFeign servicioClienteFeign;

	@Autowired
	private IRepositorioItemFactura repositorioItemFactura;

	@Override
	public List<EntidadFactura> listar() {
		return repositorioFactura.findAll();

	}

	@Override
	public EntidadFactura crearFactura(FacturaDto factura, Long idCliente) {
		for (int i = 0; i < factura.getItems().size(); i++) {
			ItemDto itemDto = factura.getItems().get(i);
			ProductoDto producto = servicioProductoFeign.buscarProductoPorId(itemDto.getIdProducto());
			validarCantidadDisponible(producto);
			itemDto.setNombreProducto(producto.getNombre());
			itemDto.setPrecioProducto(producto.getPrecio());
			itemDto.setCantidadProducto(50);
			modificarCantidadProductosDisponibles(producto, itemDto);
			calcularTotalProducto(producto.getPrecio(), itemDto);
			if (factura.getId() != null) {
				repositorioItemFactura.save(itemFacturaMapper.mappearDtoAEntidad(itemDto));
			}

		}
		calcularTotalFactura(factura.getItems(), factura);
		asignarFechaCreacion(factura);
		EntidadFactura entidadFactura = repositorioFactura.save(facturaMapper.mappearDtoAEntidad(factura));
		asignarFacturaAcliente(factura, idCliente);

		return entidadFactura;
	}

	public void asignarFacturaAcliente(FacturaDto factura, Long idCliente) {
		ClienteDto cliente = servicioClienteFeign.buscarClientePorId(idCliente);
		cliente.addFactura(factura);
		servicioClienteFeign.asignarFacturaACliente(cliente.getId(), cliente);
		System.out.println(factura.getItems().iterator().next().getCantidadProducto());
	}

	@Override
	public EntidadFactura buscarFacturaPorId(Long id) {
		return repositorioFactura.findById(id).orElse(null);
	}

	@Override
	public void borrarFactura(Long id) {
		repositorioFactura.deleteById(id);
	}

	public void modificarCantidadProductosDisponibles(ProductoDto producto, ItemDto item) {
		Integer restarCantidad = producto.getCantidadDisponible() - item.getCantidadProducto();
		producto.setCantidadDisponible(restarCantidad);
		servicioProductoFeign.modificarProducto(producto.getId(), producto);

	}

	public void validarCantidadDisponible(ProductoDto producto) {
		if (producto.getCantidadDisponible() <= 0) {
			throw new ExcepcionFacturas(String.format(NO_HAY_PRODUCTOS_DISPONIBLES, producto.getNombre()));
		}
	}

	public void calcularTotalProducto(Double precio, ItemDto item) {
		Double total = precio * item.getCantidadProducto();
		item.setPrecioTotal(total);
	}

	public void calcularTotalFactura(List<ItemDto> item, FacturaDto factura) {

		Double total = 0.0;

		for (int i = 0; i < item.size(); i++) {
			total += item.get(i).getPrecioTotal();
		}
		factura.setTotalFactura(total);
	}

	public void asignarFechaCreacion(FacturaDto factura) {
		factura.setFechaCreacion(Calendar.getInstance().getTime());
	}

}
