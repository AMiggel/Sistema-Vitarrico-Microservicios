package co.com.vitarrico.app.facturacion.dominio.servicio;

import java.util.List;

import com.vitarrico.app.comun.entidad.EntidadFactura;

import co.com.vitarrico.app.facturacion.dominio.dto.factura.FacturaDto;

public interface IServicioFactura {
	
	public List<EntidadFactura> listar();

	public EntidadFactura crearFactura(FacturaDto factura,Long idCliente);

	public EntidadFactura buscarFacturaPorId(Long id);

	public void borrarFactura(Long id);


}
