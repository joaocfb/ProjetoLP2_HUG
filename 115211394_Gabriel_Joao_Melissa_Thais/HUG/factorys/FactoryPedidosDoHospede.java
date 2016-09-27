/**
 * 
 */
package factorys;

import restaurante.Pedidos;

/**
 * Fabrica de pedidos
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public class FactoryPedidosDoHospede {

	//testar nome valido e preco valido
	
	public Pedidos criaPedido(String nome, double preco){
		return new Pedidos(nome, preco);
	}
}
