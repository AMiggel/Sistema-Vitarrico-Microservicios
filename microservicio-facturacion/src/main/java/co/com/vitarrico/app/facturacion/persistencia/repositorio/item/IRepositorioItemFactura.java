package co.com.vitarrico.app.facturacion.persistencia.repositorio.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.vitarrico.app.facturacion.persistencia.entidad.EntidadItemFactura;


@Repository
public interface IRepositorioItemFactura extends JpaRepository<EntidadItemFactura, Long> {

}
