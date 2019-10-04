package co.com.vitarrico.app.facturacion.persistencia.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.vitarrico.app.facturacion.dominio.dto.factura.FacturaDto;
import co.com.vitarrico.app.facturacion.persistencia.entidad.EntidadFactura;

@Component
public class FacturaMapper {

	@Autowired
	ItemFacturaMapper itemFacturaMapper;

	public EntidadFactura mappearDtoAEntidad(FacturaDto facturaDto) {
		EntidadFactura entidad = new EntidadFactura();
		entidad.setId(facturaDto.getId());
		entidad.setDescripcion(facturaDto.getDescripcion());
		entidad.setObservacion(facturaDto.getObservacion());
		entidad.setFechaCreacion(facturaDto.getFechaCreacion());
		entidad.setItems(itemFacturaMapper.mappearListaItemsAEntidad(facturaDto.getItems()));
		entidad.setTotalFactura(facturaDto.getTotalFactura());
		return entidad;
	}

	public FacturaDto mappearEntidadADto(EntidadFactura entidadFactura) {
		FacturaDto dto = new FacturaDto();
		dto.setId(entidadFactura.getId());
		dto.setDescripcion(entidadFactura.getDescripcion());
		dto.setFechaCreacion(entidadFactura.getFechaCreacion());
		dto.setObservacion(entidadFactura.getObservacion());
		dto.setItems(itemFacturaMapper.mappearListaEntidadItemsADto(entidadFactura.getItems()));
		dto.setTotalFactura(entidadFactura.getTotalFactura());
		return dto;
	}
}
