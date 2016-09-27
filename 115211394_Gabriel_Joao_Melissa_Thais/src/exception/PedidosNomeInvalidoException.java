/**
 * 
 */
package exception;

/**
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
@SuppressWarnings("serial")
public class PedidosNomeInvalidoException extends Exception {

	
	public PedidosNomeInvalidoException(String erro){
		super("Erro no pedido," + erro);
	}
}
