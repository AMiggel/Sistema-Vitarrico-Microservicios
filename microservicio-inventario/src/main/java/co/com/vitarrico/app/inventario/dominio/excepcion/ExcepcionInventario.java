package co.com.vitarrico.app.inventario.dominio.excepcion;

public class ExcepcionInventario extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public ExcepcionInventario(String mensaje) {
		super(mensaje);
	}
}
