/**
 * 
 */
package exception;

/**
 * Classe do tipo Exception que ao fazer a verificacao do erro lança a mensagem na consulta do hospede no hotel
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
@SuppressWarnings("serial")
public class ConsultaHospedeInvalidaException extends Exception {
	
	/**
	 * Metodo que lanca a mensagem de erro quando a consulta do hospede no hotel
	 * nao for realizada corretamente
	 * @param mensagem relativa ao erro em especifico da verificacao
	 */
	public ConsultaHospedeInvalidaException(String msgErro){
		super("Erro na consulta de hospede. Hospede de email " + msgErro + " nao foi cadastrado(a).");
	}
}
