/**
 * 
 */
package factorys;

import java.io.Serializable;

import exception.CadastroHospedeInvalidoException;
import restaurante.Pedidos;

/**
 * Fabrica de Pedidos
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 */
public class FactoryPedidosDoHospede implements Serializable {

	
	private static final long serialVersionUID = 1L;

	//testar nome valido e preco valido
	/**
	 * Cria um novo pedido do hospede
	 * @param nome da refeicao
	 * @param preco da refeicao
	 * @return O Pedido do Hospede
	 * @throws CadastroHospedeInvalidoException 
	 */
	public Pedidos criaPedido(String nome, double preco) {
		return new Pedidos(nome, preco);
		
	}
}
