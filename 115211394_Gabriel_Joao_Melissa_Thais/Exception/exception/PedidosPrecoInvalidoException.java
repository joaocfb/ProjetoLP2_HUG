/**
 * 
 */
package exception;

/**
 * @author thaisnat
 *
 */
@SuppressWarnings("serial")
public class PedidosPrecoInvalidoException extends Exception{

	public PedidosPrecoInvalidoException(String erro){
		super("Erro no pedido," + erro);
	}
}
