/**
 * 
 */
package quartos;

import java.io.Serializable;

/**
 * @author Gabriel Alves
 * @author Joao Carlos
 * @author Melissa Diniz
 * @author Thais Nicoly
 */
public class QuartoPresidencial extends QuartoSimples implements Serializable{
	
	private static final long serialVersionUID = 1L;
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

	
}
