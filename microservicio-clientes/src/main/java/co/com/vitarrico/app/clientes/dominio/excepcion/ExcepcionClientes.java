package co.com.vitarrico.app.clientes.dominio.excepcion;

public class ExcepcionClientes extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public ExcepcionClientes(String mensaje) {
		super(mensaje);
	}
}
