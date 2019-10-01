package co.com.vitarrico.app.facturacion.dominio.dto.factura;

import java.util.Date;
import java.util.List;

import co.com.vitarrico.app.facturacion.dominio.dto.item.ItemDto;


public class FacturaDto {

	private String descripcion;

	private String observacion;

	private Date fechaCreacion;

	private List<ItemDto> items;
	
	private Double totalFactura;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public List<ItemDto> getItems() {
		return items;
	}

	public void addItems(ItemDto item) {
		this.items.add(item);
	}

	public Double getTotalFactura() {
		return totalFactura;
	}

	public void setTotalFactura(Double totalFactura) {
		this.totalFactura = totalFactura;
	}
	
	
	
}
