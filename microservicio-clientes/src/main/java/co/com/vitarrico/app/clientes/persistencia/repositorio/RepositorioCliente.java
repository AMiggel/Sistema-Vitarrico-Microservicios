package co.com.vitarrico.app.clientes.persistencia.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.vitarrico.app.clientes.persistencia.entidad.EntidadCliente;

public interface RepositorioCliente extends JpaRepository<EntidadCliente, Long > {

}
