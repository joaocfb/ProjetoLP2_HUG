/**
 * 
 */
package factorys;

import exception.CheckinInvalidoException;
import exception.VerificaNuloEVazioException;
import hotel.Estadia;
import valida.VerificaEstadia;

/**
 * Fabrica de estadias
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 */
public class FactoryEstadia {
	

	/**
	 * Cria uma estadia com id do quarto e uma quantidade de dias
	 * @param ID do Quarto
	 * @param Quantidade de Dias
	 * @return Uma nova Estadia 
	 * @throws CheckinInvalidoException 
	 * @throws VerificaNuloEVazioException 
	 */
	public Estadia criaEstadia(String IDQuarto, int quantDias) throws CheckinInvalidoException, VerificaNuloEVazioException {
		VerificaEstadia.verificaQuantDias(quantDias);
		//TestaValores.verificaQuantDiasInvalidaCheckin(quantDias);
		return new Estadia(IDQuarto, quantDias);
	}
	
	
	
}
