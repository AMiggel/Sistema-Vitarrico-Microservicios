package co.com.vitarrico.app.inventario.persistencia.repositorio.producto;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vitarrico.app.comun.entidad.EntidadProducto;





@Repository
public interface IRepositorioProducto extends JpaRepository<EntidadProducto, Long> {


	public List<EntidadProducto> findByNombreLikeIgnoreCase(String term);
	
	@Query("SELECT p FROM productos p WHERE p.nombre = :nombre" )
	EntidadProducto findByNombre(@Param("nombre") String nombre);
}