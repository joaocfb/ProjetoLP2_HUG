/**
 * 
 */
package quartos;

/**
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public class QuartoLuxo extends QuartoSimples{
	private double PRECO = 250.0; 
		

	public QuartoLuxo(String iD) {
		super(iD);
	}
	
	/**
	 * @return the pRECO
	 */
	public double getPRECO() {
		return PRECO;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "QuartoLuxo [PRECO=" + PRECO + ", status=" + getStatus() + ", ID=" + getID() + "]";
	}

}
