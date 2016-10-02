/**
 * 
 */
package exception;

/**
 * Classe do tipo Exception que ao fazer a verificacao do erro lança a mensagem na consulta da hospedagem do hospede no hotel
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
@SuppressWarnings("serial")
public class ConsultaHospedagemInvalidaException extends Exception{
	
	/**
	 * Metodo que lanca a mensagem de erro quando a consulta da hospedagem do hospede no hotel
	 * nao for realizada corretamente
	 * @param mensagem relativa ao erro em especifico da verificacao
	 */
	public ConsultaHospedagemInvalidaException(String msgErro){
		super("Erro na consulta de hospedagem. " + msgErro + " nao esta hospedado(a).");
	}
}
