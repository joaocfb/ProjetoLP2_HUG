/**
 * 
 */
package exception;

/**
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
@SuppressWarnings("serial")
public class CadastroHospedeInvalidoException extends Exception{
	
	public CadastroHospedeInvalidoException(String erro){
		super("Erro no cadastro de Hospede. " + erro);
	}
}
