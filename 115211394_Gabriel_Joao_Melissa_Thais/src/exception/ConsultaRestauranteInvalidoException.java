/**
 * 
 */
package exception;

/**
 * Classe do tipo Exception que ao fazer a verificacao do erro lança a mensagem na consulta de pratos ou refeicoes no restaurante
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
@SuppressWarnings("serial")
public class ConsultaRestauranteInvalidoException extends Exception{
	
	/**
	 * Metodo que lanca a mensagem de erro quando a consulta de pratos ou refeicoes no restaurante
	 * nao for realizada corretamente
	 * @param mensagem relativa ao erro em especifico da verificacao
	 */
	public ConsultaRestauranteInvalidoException(String msgErro){
		super("Erro na consulta do restaurante." + msgErro);
	}
}
