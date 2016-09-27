/**
 * 
 */
package exception;

/**
 * @author thaisnat
 *
 */
@SuppressWarnings("serial")
public class AtualizacaoInvalidaException extends Exception{
	
	public AtualizacaoInvalidaException(String erro){
		super("Erro na atualizacao do cadastro de Hospede. " + erro);
	}
}
