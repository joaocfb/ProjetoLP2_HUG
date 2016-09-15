/**
 * 
 */
package factorys;

import quartos.QuartoLuxo;
import quartos.QuartoPresidencial;
import quartos.QuartoSimples;

/**
 * @author gabrielvba
 *
 */
public class FactoryQuartos {
	private String ID;
	
	public QuartoSimples criaQuartos(String ID) throws Exception{
		
		if (ID.length() == 2) {
			return criaQuartoSimples(ID);
		}
		else if (ID.length() == 3) {
			return criaQuartoLuxo(ID);
		}else if (ID.length() == 4) {
			return criaQuartoPresidencial(ID);
		}
		throw new Exception("Nao criou o quarto.");
	}
	
	private QuartoSimples criaQuartoSimples(String ID){
		return new QuartoSimples(ID);
	}
	
	private QuartoLuxo criaQuartoLuxo(String ID){
		return new QuartoLuxo(ID);

	}
	
	private QuartoPresidencial criaQuartoPresidencial(String ID){
		return new QuartoPresidencial(ID);

	}
}
