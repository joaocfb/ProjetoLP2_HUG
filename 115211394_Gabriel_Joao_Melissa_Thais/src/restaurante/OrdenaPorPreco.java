/**
 * 
 */
package restaurante;

import java.io.Serializable;
import java.util.Comparator;

/**
 * @author Gabriel Alves
 * @author Joao Carlos
 * @author Melissa Diniz
 * @author Thais Nicoly
 */
public class OrdenaPorPreco implements Comparator<Object>,Serializable{

	
	private static final long serialVersionUID = 1L;

	/**
	 * Compara refeicoes pelo preco
	 */
	@Override
	public int compare(Object refeicao1, Object refeicao2) {
		if (((TiposDeRefeicoes) refeicao1).getPreco() > ((TiposDeRefeicoes) refeicao2).getPreco()) {
			return 1;
		} else if (((TiposDeRefeicoes) refeicao1).getPreco() == ((TiposDeRefeicoes) refeicao2).getPreco()) {
			return 0;
		} else {
			return -1;
		}
	}


}