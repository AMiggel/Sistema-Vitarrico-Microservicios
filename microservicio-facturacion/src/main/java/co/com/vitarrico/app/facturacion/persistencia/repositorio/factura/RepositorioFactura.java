package co.com.vitarrico.app.facturacion.persistencia.repositorio.factura;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.vitarrico.app.facturacion.persistencia.entidad.EntidadFactura;


@Repository
public interface RepositorioFactura extends JpaRepository<EntidadFactura, Long>{

}
