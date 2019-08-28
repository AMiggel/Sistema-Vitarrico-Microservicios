package co.com.vitarrico.app.inventario.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.vitarrico.app.inventario.modelo.EntidadProducto;
import co.com.vitarrico.app.inventario.dominio.servicio.IServicioProducto;

@RestController
public class ControladorInventario {

	@Autowired
	private IServicioProducto servicioProducto;
	
	@GetMapping(value="/productos")
	public List<EntidadProducto> obtenerProductos(){
		return servicioProducto.listar();
	}
	
	@PostMapping(value="/crear-producto")
	public EntidadProducto crearProducto(@RequestBody EntidadProducto producto) {
		return servicioProducto.crearProducto(producto);
	}
	
	@GetMapping(value = "/producto/{id}")
	public EntidadProducto buscarProductoPorId(@PathVariable(value = "id") Long id) {
		return servicioProducto.buscarProductoPorId(id);
	}
}
