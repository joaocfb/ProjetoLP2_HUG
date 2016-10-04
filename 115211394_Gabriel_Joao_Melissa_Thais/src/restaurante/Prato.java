/**
 * 
 */
package restaurante;

/**
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public class Prato extends TiposDeRefeicoes{
	
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
		return this.getNome();
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


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		
		if (!(obj instanceof Prato)){
			return false;
		}
		Prato other = (Prato) obj;
		
		if (Double.doubleToLongBits(preco) != Double.doubleToLongBits(other.preco))
			return false;
		return true;
	}
	
	
}
