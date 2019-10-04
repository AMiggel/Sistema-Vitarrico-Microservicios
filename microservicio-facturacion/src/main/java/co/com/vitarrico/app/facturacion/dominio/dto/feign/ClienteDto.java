package co.com.vitarrico.app.facturacion.dominio.dto.feign;

import java.util.Date;
import java.util.List;

import co.com.vitarrico.app.facturacion.dominio.dto.factura.FacturaDto;


public class ClienteDto {
	
	private Long id;

	private String nombre;

	private String apellido;
	
	private String email;

	private Date fechaCreacion;

	private List<FacturaDto> facturas;
	
	public void addFactura(FacturaDto factura) {
		facturas.add(factura);
	}

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getEmail() {
		return email;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public List<FacturaDto> getFacturas() {
		return facturas;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public void setFacturas(List<FacturaDto> facturas) {
		this.facturas = facturas;
	}
	
	
}
