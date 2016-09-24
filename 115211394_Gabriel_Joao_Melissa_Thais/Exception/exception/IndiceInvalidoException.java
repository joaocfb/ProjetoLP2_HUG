/**
 * 
 */
package exception;

/**
 * @author nicolly
 *
 */
@SuppressWarnings("serial")
public class IndiceInvalidoException extends Exception{
	
	public IndiceInvalidoException(String erro){
		super("Erro na consulta de transacoes. Indice invalido." + erro);
	}
}
