/**
 * 
 */
package valida;

import java.io.Serializable;

import exception.PedidosInvalidoException;

/**
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public class VerificaPedido implements Serializable{
	
	
	private static final long serialVersionUID = 1L;


	public static void verificaPrecoInvalidoPedido(double preco) throws PedidosInvalidoException{
		if (preco < 0) {
			throw new PedidosInvalidoException("Preco invalido.");
		}
	}
	
	
	public static void verificaNomeInvalidoPedido(String nome) throws PedidosInvalidoException{
		if (nome.trim().isEmpty()) {
			throw new PedidosInvalidoException("Nome invalido.");
		}
	}

}
