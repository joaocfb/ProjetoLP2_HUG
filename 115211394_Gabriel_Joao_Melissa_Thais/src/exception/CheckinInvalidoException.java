/**
 * 
 */
package exception;

/**
 * Classe do tipo Exception que ao fazer a verificacao do erro lança a mensagem no checkin do hospede no hotel
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
@SuppressWarnings("serial")
public class CheckinInvalidoException extends Exception {
	
	/**
	 * Metodo que lanca a mensagem de erro quando o checkin do hospede
	 * nao for realizado corretamente
	 * @param mensagem relativa ao erro em especifico da verificacao
	 */
	public CheckinInvalidoException(String msgErro){
		super("Erro ao realizar checkin. " + msgErro);
	}
}
