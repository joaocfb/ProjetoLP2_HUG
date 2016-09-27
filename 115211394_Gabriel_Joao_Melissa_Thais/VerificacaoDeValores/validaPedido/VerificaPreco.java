/**
 * 
 */
package validaPedido;

import exception.PedidosPrecoInvalidoException;

/**
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public class VerificaPreco {
	
	public static void verificaPrecoInvalidoPedido(double preco) throws PedidosPrecoInvalidoException{
		if (preco < 0) {
			throw new PedidosPrecoInvalidoException("Preco invalido.");
		}
	}
}
