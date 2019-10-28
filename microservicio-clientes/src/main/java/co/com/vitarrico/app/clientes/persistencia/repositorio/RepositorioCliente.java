package co.com.vitarrico.app.clientes.persistencia.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vitarrico.app.comun.entidad.EntidadCliente;


public interface RepositorioCliente extends JpaRepository<EntidadCliente, Long > {

	@Query("SELECT c FROM clientes c WHERE c.nombre = :nombre AND c.apellido= :apellido" )
	public EntidadCliente findByNombreAndApellido(@Param("nombre") String nombre, @Param("apellido") String apellido);
}
