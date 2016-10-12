/**
 * 
 */
package hotel;


import java.io.Serializable;

import exception.VerificaNuloEVazioException;

/**
 * Classe que define uma estadia
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 * 
 */

public class Estadia implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int quantDias;
	private String IDQuarto;
	
	/**
	 * Construtor de estadia
	 * @param IDQuarto
	 * @param quantDias
	 * @throws VerificaNuloEVazioException
	 */
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
	 * @return O id do quarto
	 */
	public String getIDQuarto(){
		return this.IDQuarto;
	}
	
	/**
	 * @return a quantidades de dias da estadia
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((IDQuarto == null) ? 0 : IDQuarto.hashCode());
		return result;
	}

	/**
	 * Equals estadia: sao iguais se o id dos quartos sao iguais
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Estadia)) {
			return false;
		}
		
		Estadia outro = (Estadia) obj;
		
		if (getIDQuarto().equals(outro.getIDQuarto())) {
			return true;
		}
		
		return false;
	}
		
}
