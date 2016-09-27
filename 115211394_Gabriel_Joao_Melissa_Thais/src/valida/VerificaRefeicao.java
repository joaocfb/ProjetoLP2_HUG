package valida;

import exception.CadastroRefeicaoInvalidaException;

/**
 * 
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public class VerificaRefeicao {
	
	public static void verificaDescVazio(String descricao) throws CadastroRefeicaoInvalidaException {
		if (descricao.trim().isEmpty()) {
			throw new CadastroRefeicaoInvalidaException(". Descricao da refeicao esta vazia.");
		}

	}
	
	public static void verificaNomeRefvazio(String nomeRef) throws CadastroRefeicaoInvalidaException {
		if (nomeRef.trim().isEmpty()) {
			throw new CadastroRefeicaoInvalidaException(". Nome da refeicao esta vazio.");
		}

	}

}
