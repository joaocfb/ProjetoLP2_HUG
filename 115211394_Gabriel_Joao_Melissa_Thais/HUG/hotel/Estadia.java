/**
 * 
 */
package hotel;

import java.util.HashMap;
import java.util.Map;

import exception.StringInvalidaException;
import quartos.QuartoSimples;

/**
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */

public class Estadia {
	private int quantDias;
	private String IDQuarto;
	
	public Estadia(String IDQuarto, int quantDias) throws StringInvalidaException {
		verificaEstadia(IDQuarto, quantDias);
		this.IDQuarto = IDQuarto;
		this.quantDias = quantDias;
	}
	
	public String getIDQuarto(){
		return this.IDQuarto;
	}

	/**
	 * @return the quantDias
	 */
	public int getQuantDias() {
		return quantDias;
	}

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
	
	private void verificaEstadia(String IDQuarto, int quantDias) throws StringInvalidaException {
		if (IDQuarto == null || IDQuarto.trim().isEmpty()) {
			throw new StringInvalidaException("Parametro invalido.");
		} else if (quantDias <= 0) {
			throw new StringInvalidaException("Parametro invalido.");
		}
		
	}
	
	
	
}
