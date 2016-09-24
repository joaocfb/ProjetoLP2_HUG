/**
 * 
 */
package factorys;

import java.util.ArrayList;

import restaurante.Prato;
import restaurante.Refeicao;
import validaRefeicao.*;
/**
 * Fabrica de refeicoes
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public class FactoryRefeicao {
	
	public Refeicao criaRefeicao(String nomeRef, String descricaoRef, ArrayList<Prato> componentes) throws Exception{
		
		VerificaRefeicao.verificaNomeRefvazio(nomeRef);
		VerificaRefeicao.verificaDescVazio(descricaoRef);
		
		//verificaNomeRefvazio(nomeRef);
		//verificaDescVazio(descricaoRef);
	
		return new Refeicao(nomeRef, descricaoRef, componentes);
				
	}
	
}
