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
public class Prato extends TiposDeRefeicoes implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private double preco;
	
	public Prato(String nome, String descricao, double preco) {
		super(nome, descricao);
		this.setPreco(preco);
		
	}
	

	/**
	 * @return the preco
	 */
	public double getPreco() {
		return preco;
	}

	/**
	 * @param preco the preco to set
	 */
	public void setPreco(double preco) {
		this.preco = preco;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Nome: " + getNome() + " Preco: R$" + getPrecoFormatado() + "\r\n" + "Descricao: " +
	getDescricao() + " \r\n";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(preco);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}


	/**
	 * Equals prato - sao iguais se possuirem o mesmo preco
	 */
	@Override
	public boolean equals(Object obj) {
		
		if (!(obj instanceof Prato)){
			return false;
		}
		Prato outro = (Prato) obj;
		
		if (getPreco() == outro.getPreco()){
			return true;
		}
		return false;
	}
	
	
}
