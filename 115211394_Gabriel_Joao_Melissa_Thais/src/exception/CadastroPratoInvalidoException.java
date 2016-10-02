/**
 * 
 */
package exception;

/**
 * Classe do tipo Exception que ao fazer a verificacao do erro lança a mensagem no cadastro do prato no restaurante
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
@SuppressWarnings("serial")
public class CadastroPratoInvalidoException extends Exception{
	
	/**
	 * Metodo que lanca a mensagem de erro quando o cadastro do prato
	 * nao for realizado corretamente
	 * @param mensagem relativa ao erro em especifico da verificacao
	 */
	public CadastroPratoInvalidoException(String msgErro){
		super("Erro no cadastro do prato. " + msgErro);
	}
}
