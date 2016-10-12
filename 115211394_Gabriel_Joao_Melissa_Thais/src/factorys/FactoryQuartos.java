/**
 * 
 */
package factorys;

import java.io.Serializable;

import exception.CriacaoQuartoInvalidoException;
import quartos.QuartoLuxo;
import quartos.QuartoPresidencial;
import quartos.QuartoSimples;

/** 
 * Fabrica de Quartos
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly *
 */
public class FactoryQuartos implements Serializable {

   
	private static final long serialVersionUID = 1L;

	/**
     * Cria um novo quarto do tipo dado
     * @param ID do Quarto
     * @param Tipo do Quarto
     * @return O quarto 
     * @throws CriacaoQuartoInvalidoException
     */
	public QuartoSimples criaQuartos(String ID, String tipoQuarto) throws CriacaoQuartoInvalidoException {
		
		//cria um quarto de acordo com o tipo
		switch (tipoQuarto.toLowerCase()) {
		
		case "simples":
			return criaQuartoSimples(ID);
		case "presidencial":
			return criaQuartoPresidencial(ID);
		case "luxo":
			return criaQuartoLuxo(ID);
		}
		throw new CriacaoQuartoInvalidoException("");
	}

	/**
	 * Metodo que cria um quarto do tipo simples
	 * @param ID
	 * @return Um quarto simples
	 */
	private QuartoSimples criaQuartoSimples(String ID) {
		return new QuartoSimples(ID);
	}

	/**
	 * Metodo que cria um quarto do tipo luxo
	 * @param ID
	 * @return Um quarto luxo
	 */
	private QuartoLuxo criaQuartoLuxo(String ID) {
		return new QuartoLuxo(ID);
	}

	/**
	 * Metodo que cria um quarto do tipo presidencial
	 * @param ID
	 * @return Um quarto presidencial
	 */
	private QuartoPresidencial criaQuartoPresidencial(String ID) {
		return new QuartoPresidencial(ID);
	}
}
