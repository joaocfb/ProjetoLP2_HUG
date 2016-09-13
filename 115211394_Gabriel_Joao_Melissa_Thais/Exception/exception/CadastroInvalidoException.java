/**
 * 
 */
package exception;

/**
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
@SuppressWarnings("serial")
public class CadastroInvalidoException extends Exception{
	
	public CadastroInvalidoException(String msg){
		super(msg);
	}
}
