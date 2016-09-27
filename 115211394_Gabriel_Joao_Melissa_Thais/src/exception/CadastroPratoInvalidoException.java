/**
 * 
 */
package exception;

/**
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
@SuppressWarnings("serial")
public class CadastroPratoInvalidoException extends Exception{

	public CadastroPratoInvalidoException(String erro){
		super("Erro no cadastro do prato. " + erro);
	}
}
