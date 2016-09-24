/**
 * 
 */
package hotel;


import exception.StringInvalidaException;
//import testesValores.TestaValores;

/**
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */

public class Estadia {
	private int quantDias;
	private String IDQuarto;
	//private TestaValores testa;
	
	public Estadia(String IDQuarto, int quantDias) throws Exception {
		
		verificaQuantDias(quantDias);
		//testa.testaIdInvalido(IDQuarto);
		
		this.IDQuarto = IDQuarto;
		this.quantDias = quantDias;
	}
	
	/**
	 * Auxilio test para identificar possiveis erros com relacao ao parametro recebido
	 * @param quantDias
	 * @throws StringInvalidaException
	 */
	private void verificaQuantDias(int quantDias) throws StringInvalidaException {
		if (quantDias <= 0) {
			throw new StringInvalidaException("quantidade de dias nao pode ser menor ou igual a zero.");
		}	
	}
	
	/**
	 * Getters 
	 * Setters
	 * HashCode
	 * Equals
	 * ToString
	 */
	
	// Getters
	/**
	 * @return IDQuarto
	 */
	public String getIDQuarto(){
		return this.IDQuarto;
	}
	/**
	 * @return the quantDias
	 */
	public int getQuantDias() {
		return quantDias;
	}
	
	// Setters
	/**
	 * @param quantDias the quantDias to set
	 */
	public void setQuantDias(int quantDias) {
		this.quantDias = quantDias;
	}
	/**
	 * @param iDQuarto the iDQuarto to set
	 */
	public void setIDQuarto(String iDQuarto) {
		IDQuarto = iDQuarto;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Estadia [quantDias=" + quantDias + ", IDQuarto=" + IDQuarto + "]";
	}
	
	// HashCode
	//Equals
	//toString
	
	
	
}
