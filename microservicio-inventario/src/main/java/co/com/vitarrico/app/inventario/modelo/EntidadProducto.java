package co.com.vitarrico.app.inventario.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "productos")
public class EntidadProducto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;

	
	private Double precio;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_creacion")
	private Date fechaCreacion;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_vencimiento")
	private Date fechaVencimiento;

	@Column(name = "tipo_producto")
	private String tipoProducto;

	@Column(name = "cantidad_disponible")
	private int cantidadDisponible;

	@Column(name = "cantidad_creada")
	private int cantidadCreada;


	public EntidadProducto() {
		
	}
	public EntidadProducto(Long id, String nombre,Double precio, Date fechaCreacion,
			Date fechaVencimiento, String tipoProducto, int cantidadDisponible, int cantidadCreada) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.fechaCreacion = fechaCreacion;
		this.fechaVencimiento = fechaVencimiento;
		this.tipoProducto = tipoProducto;
		this.cantidadDisponible = cantidadDisponible;
		this.cantidadCreada = cantidadCreada;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date createAt) {
		this.fechaCreacion = createAt;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public String getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public int getCantidadDisponible() {
		return cantidadDisponible;
	}

	public void setCantidadDisponible(int cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
	}

	public int getCantidadCreada() {
		return cantidadCreada;
	}

	public void setCantidadCreada(int cantidadCreada) {
		this.cantidadCreada = cantidadCreada;
	}

}
