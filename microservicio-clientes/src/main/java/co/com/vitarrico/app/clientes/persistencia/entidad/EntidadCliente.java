package co.com.vitarrico.app.clientes.persistencia.entidad;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;

import co.com.vitarrico.app.clientes.persistencia.entidad.feign.EntidadFactura;

@Entity(name = "clientes")
public class EntidadCliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;

	private String apellido;

	@Email
	private String email;

	@Column(name = "fecha_creacion")
	@Temporal(TemporalType.DATE)
	private Date fechaCreacion;

	@OneToMany( fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<EntidadFactura> facturas;

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

	public List<EntidadFactura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<EntidadFactura> facturas) {
		this.facturas = facturas;
	}


}
