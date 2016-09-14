/**
 * 
 */
package factorys;

import exception.StringInvalidaException;
import hotel.Hospede;

/**
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public class FactoryHospedes {
	
	/**
	 * Cria um hospede
	 * @param nome
	 * @param email
	 * @param dataNascimento
	 * @return
	 * @throws StringInvalidaException 
	 */
	public Hospede criaHospede(String nome, String email, String dataNascimento) throws StringInvalidaException{
		return new Hospede(nome, email, dataNascimento);
	}
}
