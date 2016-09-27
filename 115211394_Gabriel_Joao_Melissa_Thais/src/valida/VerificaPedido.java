/**
 * 
 */
package valida;

import exception.PedidosNomeInvalidoException;
import exception.PedidosPrecoInvalidoException;

/**
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public class VerificaPedido {
	
	public static void verificaPrecoInvalidoPedido(double preco) throws PedidosPrecoInvalidoException{
		if (preco < 0) {
			throw new PedidosPrecoInvalidoException("Preco invalido.");
		}
	}
	
	
	public static void verificaNomeInvalidoPedido(String nome) throws PedidosNomeInvalidoException{
		if (nome.trim().isEmpty()) {
			throw new PedidosNomeInvalidoException("Nome invalido.");
		}
	}

}
