package instatistics.exception;
/**
 * <b>Classe</b> che descrive l'errore per un filed errato.
 * @author Micheli Elisa
 * @author Mattioli Sara
 */
public class metodNotFound extends Exception {
	
	private static final long serialVersionUID = 1L;
/**
 * 
 * @param message message
 */
	public metodNotFound (String message){
		super(message);
	}
}
