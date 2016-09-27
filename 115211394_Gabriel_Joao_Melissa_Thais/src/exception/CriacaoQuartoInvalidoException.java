/**
 * 
 */
package exception;

/**
 * @author nicolly
 *
 */
@SuppressWarnings("serial")
public class CriacaoQuartoInvalidoException extends Exception{
	
	public CriacaoQuartoInvalidoException(String erro){
		super("Nao criou o quarto." + erro);
	}
}
