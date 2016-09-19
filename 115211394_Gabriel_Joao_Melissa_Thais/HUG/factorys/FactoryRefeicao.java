/**
 * 
 */
package factorys;

import java.util.ArrayList;

import hotel.Hospede;
import restaurante.Prato;
import restaurante.Refeicao;

/**
 * Fabrica de refeicoes
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public class FactoryRefeicao {
	
	public Refeicao criaRefeicao(String nomeRef, String descricaoRef, ArrayList<Prato> componentes) throws Exception{
		verificaNomeRefvazio(nomeRef);
		verificaDescVazio(descricaoRef);
		
		return new Refeicao(nomeRef, descricaoRef, componentes);
				
	}
	
	private void verificaDescVazio(String descricao) throws Exception {
		if (descricao.trim().isEmpty()) {
			throw new Exception("Erro no cadastro de refeicao. Descricao da refeicao esta vazia.");
		}

	}

	
	
	private void verificaNomeRefvazio(String nomeRef) throws Exception {
		if (nomeRef.trim().isEmpty()) {
			throw new Exception("Erro no cadastro de refeicao. Nome da refeicao esta vazio.");
		}

	}
}
