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
	
	public CadastroInvalidoException(String erro){
		super("Erro no cadastro de Hospede. " + erro);
	}
}
