package co.com.vitarrico.app.facturacion.dominio.excepcion;

public class ExcepcionFacturas extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public ExcepcionFacturas(String mensaje) {
		super(mensaje);
	}
}
