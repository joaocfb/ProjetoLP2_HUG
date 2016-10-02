/**
 * 
 */
package exception;

/**
 * Classe do tipo Exception que ao fazer a verificacao do erro lança a mensagem na criacao do quarto no hotel
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
@SuppressWarnings("serial")
public class CriacaoQuartoInvalidoException extends Exception{
	
	/**
	 * Metodo que lanca a mensagem de erro quando a criacao do quarto no hotel
	 * nao for realizada corretamente
	 * @param mensagem relativa ao erro em especifico da verificacao
	 */
	public CriacaoQuartoInvalidoException(String msgErro){
		super("Nao criou o quarto." + msgErro);
	}
}
