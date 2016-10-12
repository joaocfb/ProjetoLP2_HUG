/**
 * 
 */
package factorys;

import java.io.Serializable;
import java.util.ArrayList;

import exception.CadastroRefeicaoInvalidaException;
import restaurante.Prato;
import restaurante.Refeicao;
import valida.VerificaRefeicao;

/**
 * Fabrica de refeicoes
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 */
public class FactoryRefeicao implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public Refeicao criaRefeicao(String nomeRef, String descricaoRef, ArrayList<Prato> componentes) throws CadastroRefeicaoInvalidaException {
		
		VerificaRefeicao.verificaNomeRefvazio(nomeRef);
		VerificaRefeicao.verificaDescVazio(descricaoRef);
	
		return new Refeicao(nomeRef, descricaoRef, componentes);
				
	}
	
}
