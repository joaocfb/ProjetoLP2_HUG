/**
 * 
 */
package factorys;

import restaurante.Prato;


/**
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public class FactoryPrato {
	
	public Prato criaPrato(String nomePrato, double precoPrato, String descricaoPrato) throws Exception{
		verificaNomePratovazio(nomePrato);
		verificaDescVazio(descricaoPrato);
		verificaPrecoInvalido(precoPrato);
		
		return new Prato(nomePrato, precoPrato, descricaoPrato);
	}


	private void verificaNomePratovazio(String nomePrato) throws Exception {
		if (nomePrato.trim().isEmpty()) {
			throw new Exception("Erro no cadastro do prato. Nome do prato esta vazio.");
		}
	}
	
	private void verificaDescVazio(String descricao) throws Exception {
		if (descricao.trim().isEmpty()) {
			throw new Exception("Erro no cadastro do prato. Descricao do prato esta vazia.");
		}
	}
	
	private void verificaPrecoInvalido(double precoPrato) throws Exception {
		if (precoPrato <= 0) {
			throw new Exception("Erro no cadastro do prato. Preco do prato eh invalido.");
		}
	}
}
