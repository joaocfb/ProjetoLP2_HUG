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
public class OrdenaPorNome implements Comparator<Object>,Serializable{
	
	
	private static final long serialVersionUID = 1L;

	/**
	 * Compara refeicoes pelo nome
	 */
	@Override
	public int compare(Object refeicao1, Object refeicao2) {
		
		return ((TiposDeRefeicoes) refeicao1).getNome().compareTo(((TiposDeRefeicoes) refeicao2).getNome());

	}

}
