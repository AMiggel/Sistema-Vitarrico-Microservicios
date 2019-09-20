package co.com.vitarrico.app.facturacion.persistencia.entidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "items_factura")
public class EntidadItemFactura {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Integer cantidad;

	private String nombreProducto;

	private Double precioProducto;
	
	

	public EntidadItemFactura() {
	}

	public EntidadItemFactura(Integer cantidad, String nombreProducto, Double precioProducto) {
		this.cantidad = cantidad;
		this.nombreProducto = nombreProducto;
		this.precioProducto = precioProducto;
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

}
