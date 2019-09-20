package co.com.vitarrico.app.facturacion.dominio.dto.feign;

import java.util.Date;

public class ProductoDto {

	private Long id;

	private String nombre;

	private Double precio;
	
	private Integer cantidadDisponible;
	
	private Date fechaCreacion;

	private Date fechaVencimiento;

	private String tipoProducto;

	private int cantidadCreada;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public Integer getCantidadDisponible() {
		return cantidadDisponible;
	}
	
	

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public String getTipoProducto() {
		return tipoProducto;
	}

	public int getCantidadCreada() {
		return cantidadCreada;
	}

	public void setCantidadDisponible(Integer cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
	}

	
	
}
