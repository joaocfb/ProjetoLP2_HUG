/**
 * 
 */
package hotel;

/**
 * @author Melissa
 *
 */
public class Checkout {
	private String nome;
	private double valor;
	
	public Checkout(String nome, double valor){
		this.nome = nome;
		this.valor = valor;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @return the valor
	 */
	public double getValor() {
		return valor;
	}
	
	
}

