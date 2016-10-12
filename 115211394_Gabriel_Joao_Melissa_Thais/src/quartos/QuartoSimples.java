/**
 * 
 */
package quartos;

import java.io.Serializable;

/**
 * Classe Quarto
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public class QuartoSimples implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String ID;
	private double PRECO = 100.0;
	
	public QuartoSimples(String iD) {
		this.ID = iD;
		
	}
	
	/**
	 * @return the iD do quarto
	 */
	public String getID() {
		return ID;
	}

	/**
	 * @return the pRECO
	 */
	public double getPRECO() {
		return PRECO;
	}



	/**
	 * ToString do objeto tipo quarto
	 */
	@Override
	public String toString() {
		return "QuartoSimples [ID=" + ID + ", PRECO=" + PRECO + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		return result;
	}



	/**
	 * Dois quartos sao iguais se possuirem mesmo ID
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof QuartoSimples)) {
			return false;
		}
		QuartoSimples other = (QuartoSimples) obj;
		if (ID == null) {
			if (other.ID != null) {
				return false;
			}
		} else if (!ID.equals(other.ID)) {
			return false;
		}
		return true;
	}
	
	
}
