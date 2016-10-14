/**
 * 
 */
package restaurante;

import java.io.Serializable;

/**
 * @author Gabriel Alves
 * @author Joao Carlos
 * @author Melissa Diniz
 * @author Thais Nicoly
 */
public class Pedidos implements Serializable{
	
	private static final long serialVersionUID = 1L;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Pedidos [nome=" + nome + ", preco=" + preco + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * Dois pedidos sao iguais se possuirem o mesmo nome
	 */
	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof Pedidos))
			return false;

		Pedidos other = (Pedidos) obj;

		if (getNome().equals(other.getNome())) {
			return true;
		}
		return false;
	}
}
