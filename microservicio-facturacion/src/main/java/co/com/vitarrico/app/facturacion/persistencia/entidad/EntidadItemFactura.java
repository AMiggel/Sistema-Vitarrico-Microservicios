package co.com.vitarrico.app.facturacion.persistencia.entidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "items_factura")
public class EntidadItemFactura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Integer cantidad;

	private String nombreProducto;

	private Double precioProducto;
	
	private Double precioTotal;
	

	public EntidadItemFactura() {
	}

	public EntidadItemFactura(Long id, Integer cantidad, String nombreProducto, Double precioProducto, Double precioTotal) {
		this.cantidad = cantidad;
		this.id=id;
		this.nombreProducto = nombreProducto;
		this.precioProducto = precioProducto;
		this.precioTotal=precioTotal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public Double getPrecioProducto() {
		return precioProducto;
	}

	public void setPrecioProducto(Double precioProducto) {
		this.precioProducto = precioProducto;
	}

	public Double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(Double precioTotal) {
		this.precioTotal = precioTotal;
	}
	
}
