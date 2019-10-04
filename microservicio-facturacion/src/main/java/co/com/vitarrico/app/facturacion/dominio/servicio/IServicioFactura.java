package co.com.vitarrico.app.facturacion.dominio.servicio;

import java.util.List;

import co.com.vitarrico.app.facturacion.dominio.dto.factura.FacturaDto;
import co.com.vitarrico.app.facturacion.persistencia.entidad.EntidadFactura;

public interface IServicioFactura {
	
	public List<EntidadFactura> listar();

	public EntidadFactura crearFactura(FacturaDto factura,Long idCliente);

	public EntidadFactura buscarFacturaPorId(Long id);

	public void borrarFactura(Long id);


}
