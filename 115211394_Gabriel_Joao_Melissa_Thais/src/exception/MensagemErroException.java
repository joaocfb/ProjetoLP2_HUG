/**
 * 
 */
package exception;

/**
 * Classe do tipo Exception que ao fazer a verificacao do erro lança mensagem de erro
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
@SuppressWarnings("serial")
public class MensagemErroException extends Exception{
	
	/**
	 * Metodo que lanca a mensagem de erro quando a operacao
	 * nao for realizada corretamente
	 * @param mensagem relativa ao erro em especifico da verificacao
	 */
	public MensagemErroException(String msgErro){
		super("Erro" + msgErro);
	}
}
