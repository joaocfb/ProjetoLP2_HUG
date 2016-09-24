/**
 * 
 */
package exception;

/**
 * @author nicolly
 *
 */
@SuppressWarnings("serial")
public class CadastroRefeicaoInvalidaException extends Exception{
	
	public CadastroRefeicaoInvalidaException(String erro){
		super("Erro no cadastro de refeicao" + erro);
	}
}
