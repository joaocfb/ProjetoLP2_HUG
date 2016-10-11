/**
 * 
 */
package hotel;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Define o objeto transacao
 * 
 * @author Gabriel Alves 
 * @author Joao Carlos 
 * @author Melissa Diniz 
 * @author Thais Nicoly
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
	
	public String getPrecoFormatado() {
		DecimalFormat df = new DecimalFormat("R$0.00");
		df.setRoundingMode(RoundingMode.HALF_UP);
		return df.format(this.getTotal());
	}



	/**
	 * @param total
	 *            the total to set
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
	 * @param detalhe
	 *            the detalhe to set
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
	 * @pa(ram nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[total=" + total + ", detalhe=" + detalhe + ", nome=" + nome + "]";
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
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof Transacao)) {
			return false;
		}
		Transacao other = (Transacao) obj;

		if (getNome().equalsIgnoreCase(other.getNome())) {
			return true;
		}
		return false;
	}

}
