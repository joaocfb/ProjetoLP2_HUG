/**
 * 
 */
package exception;

/**
 * @author thaisnat
 *
 */
@SuppressWarnings("serial")
public class CheckinInvalidoException extends Exception {
	
	public CheckinInvalidoException(String erro){
		super("Erro ao realizar checkin. " + erro);
	}
}
