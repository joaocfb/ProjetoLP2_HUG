/**
 * 
 */
package exception;

/**
 * @author thaisnat
 *
 */
@SuppressWarnings("serial")
public class MensagemErroException extends Exception{
	
	public MensagemErroException(String erro){
		super("Erro" + erro);
	}
}
