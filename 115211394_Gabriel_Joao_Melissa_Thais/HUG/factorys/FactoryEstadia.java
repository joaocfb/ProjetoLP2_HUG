/**
 * 
 */
package factorys;

import exception.CheckinInvalidoException;
import exception.VerificaNuloEVazioException;
import hotel.Estadia;
//import testesValores.TestaValores;
import validaEstadia.*;
/**
 * Fabrica de estadias
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public class FactoryEstadia {
	

	/**
	 * Cria uma estadia com id do quarto e uma quantidade de dias
	 * @param IDQuarto
	 * @param quantDias
	 * @return
	 * @throws CheckinInvalidoException 
	 * @throws VerificaNuloEVazioException 
	 * @throws Exception
	 */
	public Estadia criaEstadia(String IDQuarto, int quantDias) throws CheckinInvalidoException, VerificaNuloEVazioException {
		VerificaDias.verificaQuantDias(quantDias);
		//TestaValores.verificaQuantDiasInvalidaCheckin(quantDias);
		return new Estadia(IDQuarto, quantDias);
	}
	
	
	
}
