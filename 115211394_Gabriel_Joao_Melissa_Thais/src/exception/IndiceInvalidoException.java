/**
 * 
 */
package exception;

/**
 * Classe do tipo Exception que ao fazer a verificacao do erro lança a mensagem na consulta do indice relativo ao hospede 
 * antes do seu checkout no hotel
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
@SuppressWarnings("serial")
public class IndiceInvalidoException extends Exception{
	
	/**
	 * Metodo que lanca a mensagem de erro quando a consulta do indice relativo ao hospede
	 * nao for realizada corretamente
	 * @param mensagem relativa ao erro em especifico da verificacao
	 */
	public IndiceInvalidoException(String msgErro){
		super("Erro na consulta de transacoes. Indice invalido." + msgErro);
	}
}
