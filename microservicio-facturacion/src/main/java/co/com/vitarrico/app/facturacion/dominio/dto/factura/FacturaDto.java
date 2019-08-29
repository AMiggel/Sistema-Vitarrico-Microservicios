package co.com.vitarrico.app.facturacion.dominio.dto.factura;

import java.util.Date;
import java.util.List;

import co.com.vitarrico.app.facturacion.persistencia.entidad.EntidadItemFactura;


public class FacturaDto {

	private String descripcion;

	private String observacion;

	private Date fechaCreacion;

	private Long[] idProducto;

	private Integer[] cantidadProducto;

	private List<EntidadItemFactura> items;

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

	public Long[] getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long[] idProducto) {
		this.idProducto = idProducto;
	}

	public Integer[] getCantidadProducto() {
		return cantidadProducto;
	}

	public void setCantidadProducto(Integer[] cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}

	public List<EntidadItemFactura> getItems() {
		return items;
	}

	public void setItems(List<EntidadItemFactura> items) {
		this.items = items;
	}

	
}