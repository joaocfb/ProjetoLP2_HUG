/**
 * 
 */
package restaurante;

import java.util.Comparator;

/**
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public class OrdenaPorPreco implements Comparator<Object>{


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