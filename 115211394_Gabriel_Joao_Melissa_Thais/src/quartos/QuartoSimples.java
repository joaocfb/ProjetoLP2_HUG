/**
 * 
 */
package quartos;

/**
 * Classe Quarto
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public class QuartoSimples {
	private String ID;
	//representa se o quarto esta vago(true) ou nao(false)
	private boolean status;
	private double PRECO = 100.0;
	
	public QuartoSimples(String iD) {
		this.ID = iD;
		//quarto comeca livre
		this.status = true;
	}
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "QuartoSimples [ID=" + ID + ", status=" + getStatus() + ", PRECO=" + PRECO + "]";
	}



	/**
	 * @return the status
	 */
	public boolean getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}


	/**
	 * @return the iD
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
	
	
}
