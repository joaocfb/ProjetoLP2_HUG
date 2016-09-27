/**
 * 
 */
package hotel;


import exception.VerificaNuloEVazioException;

/**
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 * 
 */

public class Estadia {
	private int quantDias;
	private String IDQuarto;
	
	public Estadia(String IDQuarto, int quantDias) throws VerificaNuloEVazioException  {
		
		verificaQuantDias(quantDias);
		
		this.IDQuarto = IDQuarto;
		this.quantDias = quantDias;
	}
	
	/**
	 * Auxilio test para identificar possiveis erros com relacao ao parametro recebido
	 * @param quantDias
	 * @throws VerificaNuloEVazioException
	 */
	private void verificaQuantDias(int quantDias) throws VerificaNuloEVazioException {
		if (quantDias <= 0) {
			throw new VerificaNuloEVazioException("quantidade de dias nao pode ser menor ou igual a zero.");
		}	
	}
	
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

	//ToString
	@Override
	public String toString() {
		return "Estadia [quantDias=" + quantDias + ", IDQuarto=" + IDQuarto + "]";
	}
		
}
