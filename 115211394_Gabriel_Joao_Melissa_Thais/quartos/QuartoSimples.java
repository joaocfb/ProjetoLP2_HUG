/**
 * 
 */
package quartos;

/**
 *@author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public class QuartoSimples {
	private String ID;
	//representa se o quarto esta vago(true) ou nao(false)
	private boolean status;
	private final double PRECO = 100.0;
	
	public QuartoSimples(String iD) {
		this.ID = iD;
		this.status = true;
	}
	
	/**
	 * @return the status
	 */
	public boolean isStatus() {
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
