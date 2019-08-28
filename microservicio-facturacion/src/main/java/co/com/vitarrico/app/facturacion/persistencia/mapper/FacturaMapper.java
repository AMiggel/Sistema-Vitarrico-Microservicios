package co.com.vitarrico.app.facturacion.persistencia.mapper;

import org.springframework.stereotype.Component;

import co.com.vitarrico.app.facturacion.dominio.dto.factura.FacturaDto;
import co.com.vitarrico.app.facturacion.persistencia.entidad.EntidadFactura;

@Component
public class FacturaMapper {

	public EntidadFactura mappearDtoAEntidad(FacturaDto facturaDto) {
		 EntidadFactura entidad = new EntidadFactura();
		 entidad.setDescripcion(facturaDto.getDescripcion());
		 entidad.setObservacion(facturaDto.getObservacion());
		 entidad.setFechaCreacion(facturaDto.getFechaCreacion());
		 entidad.setItems(facturaDto.getItems());
		return entidad;
	}
}
