/**
 * 
 */
package exception;

/**
 * Classe do tipo Exception que ao fazer a verificacao do erro lança a mensagem que a informacao dada nao pode ter atributos em nulo ou vazio
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
@SuppressWarnings("serial")
public class VerificaNuloEVazioException extends Exception{
	
	/**
	 * Metodo que lanca a mensagem de erro quando a informacao dada pelo usuario 
	 * for nula ou vazia
	 * @param mensagem relativa ao erro em especifico da verificacao
	 */
	public VerificaNuloEVazioException(String msgErro){
		super(msgErro + " nao pode ser nulo ou vazio.");
	}
}
