/**
 * 
 */
package exception;

/**
 * Classe do tipo Exception que ao fazer a verificacao do erro lança a mensagem na remocao do hospede apos o checkout no hotel
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
@SuppressWarnings("serial")
public class RemocaoInvalidaException extends Exception{
	
	/**
	 * Metodo que lanca a mensagem de erro quando a remocao do hospede apos o checkout no hotel
	 * nao for realizada corretamente
	 * @param mensagem relativa ao erro em especifico da verificacao
	 */
	public RemocaoInvalidaException(String msgErro){
		super("Erro na remocao do Hospede. " + msgErro);
	}

}
