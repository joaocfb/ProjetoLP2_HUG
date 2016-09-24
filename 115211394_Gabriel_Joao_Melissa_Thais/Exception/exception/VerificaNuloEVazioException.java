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
public class VerificaNuloEVazioException extends Exception{
	
	public VerificaNuloEVazioException(String msg){
		super(msg + " nao pode ser nulo ou vazio.");
	}
}
