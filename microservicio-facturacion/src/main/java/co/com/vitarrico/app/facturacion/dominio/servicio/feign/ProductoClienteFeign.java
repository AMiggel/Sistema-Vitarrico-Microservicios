package co.com.vitarrico.app.facturacion.dominio.servicio.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import co.com.vitarrico.app.facturacion.dominio.dto.feign.ProductoDto;


@FeignClient(name = "servicio-inventario")
public interface ProductoClienteFeign {

	@GetMapping(value = "/producto/{id}")
	public ProductoDto buscarProductoPorId(@PathVariable(value = "id") Long id); 

	@PutMapping(value= "modificar-producto/{id}")
	public ProductoDto modificarProducto(@PathVariable (value = "id") Long id, @RequestBody ProductoDto producto);
}
