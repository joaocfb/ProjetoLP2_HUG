/**
 * 
 */
package exception;

/**
 * Classe do tipo Exception que ao fazer a verificacao do erro lança a mensagem na checagem de hospedagens ativas no hotel
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
@SuppressWarnings("serial")
public class HospedagemAtivaInvalidaException extends Exception {
	
	/**
	 * Metodo que lanca a mensagem de erro quando a checagem da hospedagem do hospede no hotel
	 * nao for realizada corretamente
	 * @param mensagem relativa ao erro em especifico da verificacao
	 */
	public HospedagemAtivaInvalidaException(String msgErro){
		super("Erro ao checar hospedagem ativa. Email do(a) hospede " + msgErro);
	}
}
