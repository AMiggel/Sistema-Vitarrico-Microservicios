package co.com.vitarrico.app.facturacion.dominio.dto.feign;

public class Producto {

	private Long id;

	private String nombre;

	private Double precio;
	
	private Integer cantidadDisponible;

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

	public void setCantidadDisponible(Integer cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
	}

	
}
