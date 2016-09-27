/**
 * 
 */
package quartos;

/**
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public class QuartoPresidencial extends QuartoSimples{
	private double PRECO = 450.0; 
	
	public QuartoPresidencial(String iD) {
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
