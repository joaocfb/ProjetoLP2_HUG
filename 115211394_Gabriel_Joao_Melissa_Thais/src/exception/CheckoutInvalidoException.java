/**
 * 
 */
package exception;

/**
 * Classe do tipo Exception que ao fazer a verificacao do erro lança a mensagem no checkout do hospede no hotel
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
@SuppressWarnings("serial")
public class CheckoutInvalidoException extends Exception{
	
	/**
	 * Metodo que lanca a mensagem de erro quando o checkout do hospede
	 * nao for realizado corretamente
	 * @param mensagem relativa ao erro em especifico da verificacao
	 */
	public CheckoutInvalidoException(String msgErro){
		super("Erro ao realizar checkout. " + msgErro);
	}
}
