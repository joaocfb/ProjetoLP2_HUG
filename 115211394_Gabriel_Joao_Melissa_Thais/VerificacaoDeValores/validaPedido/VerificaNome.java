/**
 * 
 */
package validaPedido;

import exception.PedidosNomeInvalidoException;

/**
 * @author thaisnat
 *
 */
public class VerificaNome {
	
	
	public static void verificaNomeInvalidoPedido(String nome) throws PedidosNomeInvalidoException{
		if (nome.trim().isEmpty()) {
			throw new PedidosNomeInvalidoException("Nome invalido.");
		}
	}

	
}
