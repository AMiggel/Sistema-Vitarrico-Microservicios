package co.com.vitarrico.app.facturacion.dominio.dto.item;

public class ItemDto {

	private Long idProducto;

	private Integer cantidadProducto;
	
	private String nombreProducto;

	private Double precioProducto;

	public ItemDto() {
		
	}
	
	public ItemDto(Integer cantidadProducto, String nombreProducto, Double precioProducto) {
		this.cantidadProducto = cantidadProducto;
		this.nombreProducto = nombreProducto;
		this.precioProducto = precioProducto;
	}

	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public Integer getCantidadProducto() {
		return cantidadProducto;
	}

	public void setCantidadProducto(Integer cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
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