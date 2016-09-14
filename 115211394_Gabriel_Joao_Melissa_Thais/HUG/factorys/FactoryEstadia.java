/**
 * 
 */
package factorys;

import exception.StringInvalidaException;
import hotel.Estadia;

/**
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public class FactoryEstadia {

	public Estadia criaEstadia(String IDQuarto, int quantDias) throws StringInvalidaException{
		return new Estadia(IDQuarto, quantDias);
	}
}
