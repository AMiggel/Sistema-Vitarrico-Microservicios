package co.com.vitarrico.app.facturacion.persistencia.repositorio.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vitarrico.app.comun.entidad.EntidadItemFactura;

@Repository
public interface IRepositorioItemFactura extends JpaRepository<EntidadItemFactura, Long> {

}
