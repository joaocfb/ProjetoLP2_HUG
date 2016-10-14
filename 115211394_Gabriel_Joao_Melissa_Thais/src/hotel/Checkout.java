/**
 * 
 */
package hotel;

import java.io.Serializable;

/**
 * Classe que definine o tipo checkout 
 * @author Gabriel Alves
 * @author Joao Carlos
 * @author Melissa Diniz
 * @author Thais Nicoly
 */
public class Checkout implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String idCheckout;
	private double valor;
	
	/**
	 * Construtor do checkout
	 * @param nome
	 * @param valor
	 */
	public Checkout(String nome, double valor){
		this.idCheckout = nome;
		this.valor = valor;
	}

	/**
	 * 
	 * @return o id do quarto
	 */
	public String getNome() {
		return idCheckout;
	}

	/**
	 * @return o valor do checkout
	 */
	public double getValor() {
		return valor;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCheckout == null) ? 0 : idCheckout.hashCode());
		return result;
	}

	/**
	 * Equals de checkout: Sao iguais se possuirem o mesmo id
	 */
	@Override
	public boolean equals(Object obj) {
		
		if (!(obj instanceof Checkout)) {
			return false;
		}
		
		Checkout outro = (Checkout) obj;
		
		if (getNome().equals(outro.getNome())) {
			return true;
		}
		
		return false;
	}

	/**
	 * toString checkout
	 */
	@Override
	public String toString() {
		return "Checkout [idCheckout=" + idCheckout + ", valor=" + valor + "]";
	}

	
}

