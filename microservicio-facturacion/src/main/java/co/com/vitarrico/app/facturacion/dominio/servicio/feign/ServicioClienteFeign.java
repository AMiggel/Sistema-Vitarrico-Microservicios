package co.com.vitarrico.app.facturacion.dominio.servicio.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import co.com.vitarrico.app.facturacion.dominio.dto.factura.FacturaDto;
import co.com.vitarrico.app.facturacion.dominio.dto.feign.ClienteDto;

@FeignClient(name = "servicio-clientes", url="localhost:9001")
public interface ServicioClienteFeign {
	
	@GetMapping(value = "/cliente/{id}")
	public ClienteDto buscarClientePorId(@PathVariable (value="id") Long id);
		
	@PutMapping(value="modificar-cliente/{id}")
	public ClienteDto  asignarFacturaACliente(@PathVariable (value="id")Long id, @RequestBody ClienteDto cliente);
}
