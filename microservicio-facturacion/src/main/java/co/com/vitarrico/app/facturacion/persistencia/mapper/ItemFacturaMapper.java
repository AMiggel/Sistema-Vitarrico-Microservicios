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
		entidad.setId(item.getId());
		entidad.setCantidadProducto(item.getCantidadProducto());
		entidad.setNombreProducto(item.getNombreProducto());
		entidad.setPrecioProducto(item.getPrecioProducto());
		entidad.setPrecioTotal(item.getPrecioTotal());

		return entidad;
	}

	public ItemDto mappearEntidadADto(EntidadItemFactura item) {
		ItemDto itemDto = new ItemDto();
		itemDto.setId(item.getId());
		itemDto.setCantidadProducto(item.getCantidadProducto());
		itemDto.setNombreProducto(item.getNombreProducto());
		itemDto.setPrecioProducto(item.getPrecioProducto());
		itemDto.setPrecioTotal(item.getPrecioTotal());

		return itemDto;
	}

	public List<EntidadItemFactura> mappearListaItemsAEntidad(List<ItemDto> listaItemFactura) {
		List<EntidadItemFactura> lista = new ArrayList<>();

		for (ItemDto itemDto : listaItemFactura) {

			lista.add(new EntidadItemFactura(itemDto.getId(),itemDto.getCantidadProducto(), itemDto.getNombreProducto(),
					itemDto.getPrecioProducto(), itemDto.getPrecioTotal()));
		}
		return lista;
	}

	public List<ItemDto> mappearListaEntidadItemsADto(List<EntidadItemFactura> listaEntidadItemFactura) {
		List<ItemDto> lista = new ArrayList<>();

		for (EntidadItemFactura entidadItem : listaEntidadItemFactura) {

			lista.add(new ItemDto(entidadItem.getId(),entidadItem.getCantidadProducto(), entidadItem.getNombreProducto(),
					entidadItem.getPrecioProducto(), entidadItem.getPrecioTotal()));
		}
		return lista;
	}

}
