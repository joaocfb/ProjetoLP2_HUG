/**
 * 
 */
package exception;

/**
 * 
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
@SuppressWarnings("serial")
public class CheckinInvalidoException extends Exception {
	
	public CheckinInvalidoException(String erro){
		super("Erro ao realizar checkin. " + erro);
	}
}
