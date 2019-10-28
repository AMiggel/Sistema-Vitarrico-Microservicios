package co.com.vitarrico.app.inventario.dominio.servicio.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.vitarrico.app.comun.entidad.EntidadProducto;

import co.com.vitarrico.app.inventario.persistencia.repositorio.producto.IRepositorioProducto;
import co.com.vitarrico.app.inventario.dominio.excepcion.ExcepcionInventario;
import co.com.vitarrico.app.inventario.dominio.servicio.IServicioProducto;

@Service
public class ServicioProducto implements IServicioProducto {

	public static final String PRODUCTO_INEXISTENTE = "El producto no existe en la base de datos";
	public static final String CANTIDAD_CREADA_INVALIDA = "Debe ingresar una cantidad válida";

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private IRepositorioProducto repositorioProducto;

	@Override
	public List<EntidadProducto> listar() {
		return repositorioProducto.findAll();
	}

	@Override
	public EntidadProducto crearProducto(EntidadProducto producto) {

		int disponible = 0;
		EntidadProducto productoExistente = repositorioProducto.findByNombre(producto.getNombre());
		producto.setCantidadDisponible(producto.getCantidadCreada());
		if (producto.getCantidadCreada() <= 0) {
			throw new ExcepcionInventario(CANTIDAD_CREADA_INVALIDA);
		}

		if (productoExistente != null) {
			productoExistente.setCantidadCreada(producto.getCantidadCreada());
			disponible = productoExistente.getCantidadDisponible() + producto.getCantidadCreada();
			productoExistente.setCantidadDisponible(disponible);
			return repositorioProducto.save(productoExistente);
		} else {
			asignarFechaCreacion(producto);
			//enviarEmail(producto);
			return repositorioProducto.save(producto);
		
		}
	}

	@Override
	public EntidadProducto buscarProductoPorId(Long id) {
		EntidadProducto producto = repositorioProducto.findById(id).orElse(null);

		if (producto == null) {
			throw new ExcepcionInventario(PRODUCTO_INEXISTENTE);
		} else {
			return producto;
		}
	}

	@Override
	public void borrarProducto(Long id) {
		buscarProductoPorId(id);
		repositorioProducto.deleteById(id);
	}

	@Override
	public EntidadProducto modificarCantidadDisponible(Long id, EntidadProducto producto) {
		EntidadProducto productoActual = buscarProductoPorId(id);

		productoActual.setCantidadDisponible(producto.getCantidadDisponible());

		return repositorioProducto.save(productoActual);
	}

	@Override
	public EntidadProducto modificarProducto(Long id, EntidadProducto producto) {
		EntidadProducto productoActual = buscarProductoPorId(id);
		Integer diferencia = 0;
		Integer disponible = 0;

		if (producto.getCantidadDisponible() == 0) {
			diferencia = producto.getCantidadCreada() - productoActual.getCantidadCreada();
			disponible = productoActual.getCantidadDisponible() + diferencia;
			productoActual.setCantidadCreada(producto.getCantidadCreada());
			productoActual.setCantidadDisponible(disponible);
		}
		
		productoActual.setNombre(producto.getNombre());
		productoActual.setFechaVencimiento(producto.getFechaVencimiento());
		productoActual.setPrecio(producto.getPrecio());
		productoActual.setTipoProducto(producto.getTipoProducto());
		return repositorioProducto.save(productoActual);
	}

	public void asignarFechaCreacion(EntidadProducto producto) {
		producto.setFechaCreacion(Calendar.getInstance().getTime());
	}
	
	public void enviarEmail(EntidadProducto producto) {
		
		SimpleMailMessage mensaje= new SimpleMailMessage();
		mensaje.setTo("amarin@unac.edu.co");
		mensaje.setSubject("probando mensaje");
		mensaje.setText("se ha creado un producto :" + producto.getNombre()+"\ncantidad creada : " + producto.getCantidadCreada() );
		
		javaMailSender.send(mensaje);
	}

	@Override
	public EntidadProducto buscarProductoPorNombre(String nombre) {
		return repositorioProducto.findByNombre(nombre);
	}

}
