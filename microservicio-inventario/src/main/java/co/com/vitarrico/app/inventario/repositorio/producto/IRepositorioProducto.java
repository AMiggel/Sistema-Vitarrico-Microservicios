package co.com.vitarrico.app.inventario.repositorio.producto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.vitarrico.app.inventario.modelo.EntidadProducto;


@Repository
public interface IRepositorioProducto extends JpaRepository<EntidadProducto, Long> {

}
