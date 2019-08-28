package co.com.vitarrico.app.facturacion.modelo.feign;

public class Producto {

	private Long id;

	private String nombre;

	private Double precio;

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

}
