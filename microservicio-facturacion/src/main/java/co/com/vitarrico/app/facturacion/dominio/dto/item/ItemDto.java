package co.com.vitarrico.app.facturacion.dominio.dto.item;

public class ItemDto {

	private Long id;
	
	private Long idProducto;

	private Integer cantidadProducto;
	
	private String nombreProducto;

	private Double precioProducto;
	
	private Double precioTotal;

	public ItemDto() {
		
	}
	
	public ItemDto(Long id, Integer cantidadProducto, String nombreProducto, Double precioProducto, Double precioTotal) {
		this.id=id;
		this.cantidadProducto = cantidadProducto;
		this.nombreProducto = nombreProducto;
		this.precioProducto = precioProducto;
		this.precioTotal=precioTotal;
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

	public Double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(Double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
