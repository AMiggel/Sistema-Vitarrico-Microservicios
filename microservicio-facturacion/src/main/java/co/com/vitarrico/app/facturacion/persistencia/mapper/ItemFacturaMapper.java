package co.com.vitarrico.app.facturacion.persistencia.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import co.com.vitarrico.app.facturacion.dominio.dto.item.ItemDto;
import co.com.vitarrico.app.facturacion.persistencia.entidad.EntidadItemFactura;

@Component
public class ItemFacturaMapper {

	public EntidadItemFactura mappearDtoAEntidad(ItemDto item) {
		EntidadItemFactura entidad = new EntidadItemFactura();
		entidad.setCantidad(item.getCantidadProducto());
		entidad.setNombreProducto(item.getNombreProducto());
		entidad.setPrecioProducto(item.getPrecioProducto());
		entidad.setPrecioTotal(item.getPrecioTotal());
		
		return entidad;
	}

	public List<EntidadItemFactura> mappearListaItemsAEntidad (List<ItemDto> listaItemFactura){
		List<EntidadItemFactura> lista= new ArrayList<>();
				
		for (ItemDto itemDto: listaItemFactura ) {
		
			lista.add(new EntidadItemFactura(itemDto.getCantidadProducto(),itemDto.getNombreProducto(),itemDto.getPrecioProducto(),itemDto.getPrecioTotal()));
		}
		return lista;
	}
}
	
