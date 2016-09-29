/**
 * 
 */
package restaurante;

import java.util.Comparator;

/**
 * @author thaisnat
 *
 */
public class OrdenaPorNome implements Comparator<Object>{
	
	@Override
	public int compare(Object refeicao1, Object refeicao2) {
		return ((TiposDeRefeicoes) refeicao1).getNome().compareTo(((TiposDeRefeicoes) refeicao2).getNome());

	}

}

/**
public enum OrdenarAlimentacao implements Comparator<Alimentacao>{
	
	PorNome(){
		@Override
		public int compare(Alimentacao um, Alimentacao dois) {
			return um.getNome().compareTo(dois.getNome());
		}
		
	},
	
	PorPreco(){

		@Override
		public int compare(Alimentacao um, Alimentacao dois) {
			if (um.getPreco()>dois.getPreco()) return 1;
			if (um.getPreco()<dois.getPreco()) return -1;
			return 0;
		}
		
	}

}
*/