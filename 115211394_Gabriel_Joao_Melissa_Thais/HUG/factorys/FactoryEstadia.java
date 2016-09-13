/**
 * 
 */
package factorys;

import hotel.Estadia;

/**
 * @author melissadg
 *
 */
public class FactoryEstadia {

	public Estadia criaEstadia(String IDQuarto, int quantDias){
		return new Estadia(IDQuarto, quantDias);
	}
}
