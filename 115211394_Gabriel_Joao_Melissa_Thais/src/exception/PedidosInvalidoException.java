/**
 * 
 */
package exception;

/**
 * Classe do tipo Exception que ao fazer a verificacao do erro lança a mensagem na realizacao do pedido de um prato ou refeicao
 * do hospede no restaurante
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
@SuppressWarnings("serial")
public class PedidosInvalidoException extends Exception{
	
	/**
	 * Metodo que lanca a mensagem de erro quando o pedido de um prato ou refeicao do hospede no restaurante
	 * nao for realizado corretamente
	 * @param mensagem relativa ao erro em especifico da verificacao
	 */
	public PedidosInvalidoException(String msgErro){
		super("Erro no pedido," + msgErro);
	}
}
