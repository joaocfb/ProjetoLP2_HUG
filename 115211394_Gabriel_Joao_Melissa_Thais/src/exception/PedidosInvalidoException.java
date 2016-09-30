/**
 * 
 */
package exception;

/**
 * @author thaisnat
 *
 */
@SuppressWarnings("serial")
public class PedidosInvalidoException extends Exception{

	public PedidosInvalidoException(String erro){
		super("Erro no pedido," + erro);
	}
}
