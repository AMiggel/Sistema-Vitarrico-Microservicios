package co.com.vitarrico.app.inventario.persistencia.repositorio.producto;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.com.vitarrico.app.inventario.persistencia.entidad.EntidadProducto;


@Repository
public interface IRepositorioProducto extends JpaRepository<EntidadProducto, Long> {

	@Query("SELECT p FROM productos p WHERE p.nombre = :nombre" )
	EntidadProducto findByNombre(@Param("nombre") String nombre);
}