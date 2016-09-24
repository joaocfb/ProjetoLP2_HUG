/**
 * 
 */
package factorys;

import exception.CriacaoQuartoInvalidoException;
import quartos.QuartoLuxo;
import quartos.QuartoPresidencial;
import quartos.QuartoSimples;


public class FactoryQuartos {


	public QuartoSimples criaQuartos(String ID, String tipoQuarto) throws CriacaoQuartoInvalidoException {

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

	private QuartoSimples criaQuartoSimples(String ID) {
		return new QuartoSimples(ID);
	}

	private QuartoLuxo criaQuartoLuxo(String ID) {
		return new QuartoLuxo(ID);
	}

	private QuartoPresidencial criaQuartoPresidencial(String ID) {
		return new QuartoPresidencial(ID);
	}
}
