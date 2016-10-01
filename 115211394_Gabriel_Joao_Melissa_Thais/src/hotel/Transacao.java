/**
 * 
 */
package hotel;

/**
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public class Transacao {
	double total;
	String detalhe;
	String nome;
	
	
	/**
	 * 
	 * @param total
	 * @param detalhe
	 * @param nome
	 */
	public Transacao(double total, String detalhe, String nome) {
		this.total = total;
		this.detalhe = detalhe;
		this.nome = nome;
	}


	/**
	 * @return the total
	 */
	public double getTotal() {
		return total;
	}


	/**
	 * @param total the total to set
	 */
	public void setTotal(double total) {
		this.total = total;
	}


	/**
	 * @return the detalhe
	 */
	public String getDetalhe() {
		return detalhe;
	}


	/**
	 * @param detalhe the detalhe to set
	 */
	public void setDetalhe(String detalhe) {
		this.detalhe = detalhe;
	}


	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}


	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[total=" + total + ", detalhe=" + detalhe + ", nome=" + nome + "]";
	}
	
	
}
