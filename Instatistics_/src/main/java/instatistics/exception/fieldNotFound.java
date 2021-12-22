package instatistics.exception;
/**
 * <b>Classe</b> che descrive l'errore per un filed errato.
 * @author Micheli Elisa
 * @author Mattioli Sara
 */
public class fieldNotFound extends Exception {
	
	private static final long serialVersionUID = 1L;

	public fieldNotFound (String message){
		super(message);
	}
}
