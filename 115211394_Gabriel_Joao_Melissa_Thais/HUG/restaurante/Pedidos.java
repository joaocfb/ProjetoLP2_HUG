/**
 * 
 */
package restaurante;

/**
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public class Pedidos {
	private String nome;
	private double preco;
	
	
	/**
	 * @param nome
	 * @param preco
	 */
	public Pedidos(String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
	}


	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}


	/**
	 * @return the preco
	 */
	public double getPreco() {
		return preco;
	}
	
}
