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
public class CheckoutInvalidoException extends Exception{
	
	public CheckoutInvalidoException(String erro){
		super("Erro ao realizar checkout. " + erro);
	}
}
