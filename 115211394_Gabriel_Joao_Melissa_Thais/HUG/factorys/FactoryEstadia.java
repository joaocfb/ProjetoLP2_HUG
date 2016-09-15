/**
 * 
 */
package factorys;

import exception.StringInvalidaException;
import hotel.Estadia;

/**
 * Fabrica de estadias
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public class FactoryEstadia {
	
	//cria uma estadia com ID do quarto e a quantidade de dias
	public Estadia criaEstadia(String IDQuarto, int quantDias) throws Exception{
		testaQuantDias(quantDias);
		return new Estadia(IDQuarto, quantDias);
	}
	
	private void testaQuantDias(int quant)throws Exception{
		if (quant <= 0) {
			throw new Exception("Nao pode.");
		}
	}
}
