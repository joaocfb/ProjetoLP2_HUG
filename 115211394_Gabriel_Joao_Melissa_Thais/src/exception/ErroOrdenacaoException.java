/**
 * 
 */
package exception;

/**
 * Classe do tipo Exception que ao fazer a verificacao do erro lança a mensagem na ordenacao dos pratos e refeicoes no menu do restaurante
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
@SuppressWarnings("serial")
public class ErroOrdenacaoException extends Exception{
	
	/**
	 * Metodo que lanca a mensagem de erro quando a ordenacao dos pratos e refeicoes no menu do restaurante
	 * nao for realizada corretamente
	 * @param mensagem relativa ao erro em especifico da verificacao
	 */
	public ErroOrdenacaoException(String msgErro){
		super("Erro Ordenacao " + msgErro);
	}
}
