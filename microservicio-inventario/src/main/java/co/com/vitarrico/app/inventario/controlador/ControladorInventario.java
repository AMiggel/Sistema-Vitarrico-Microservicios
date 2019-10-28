package co.com.vitarrico.app.inventario.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vitarrico.app.comun.entidad.EntidadProducto;

import co.com.vitarrico.app.inventario.dominio.servicio.IServicioProducto;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value="/inventario")
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
	
	@PutMapping(value= "modificar-producto/{id}")
	public EntidadProducto modificarProducto(@PathVariable (value = "id") Long id, @RequestBody EntidadProducto producto) {
		return servicioProducto.modificarProducto(id, producto);
	}
	
	@PutMapping(value= "modificar-cantidad/{id}")
	public EntidadProducto modificarCantidadDisponible(@PathVariable (value = "id") Long id, @RequestBody EntidadProducto producto) {
		return servicioProducto.modificarCantidadDisponible(id, producto);
	}
	
	@DeleteMapping(value= "borrar-producto/{id}")
	public void borrarProducto(@PathVariable (value="id")Long id) {
		servicioProducto.borrarProducto(id);
		
	}
	
	@GetMapping(value="/productos/{nombre}")
	public EntidadProducto buscarProductoPorNombre (@PathVariable (value="nombre") String nombre) {
		return servicioProducto.buscarProductoPorNombre(nombre);
	}
	
}
