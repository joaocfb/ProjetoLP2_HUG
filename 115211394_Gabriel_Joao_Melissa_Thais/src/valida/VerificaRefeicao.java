package valida;

import java.io.Serializable;

import exception.CadastroRefeicaoInvalidaException;

/**
 * 
 * @author Gabriel Alves - Joao Carlos - Melissa Diniz - Thais Nicoly
 *
 */
public class VerificaRefeicao implements Serializable{
	private static final long serialVersionUID = 1L;

	/**
	 * Verifica se a descricao da refeicao eh valida
	 * @param descricao
	 * @throws CadastroRefeicaoInvalidaException
	 */
	public static void verificaDescVazio(String descricao) throws CadastroRefeicaoInvalidaException {
		if (descricao.trim().isEmpty()) {
			throw new CadastroRefeicaoInvalidaException(". Descricao da refeicao esta vazia.");
		}

	}
	
	/**
	 * Verifica se o nome da refeicao eh valido
	 * @param nomeRef
	 * @throws CadastroRefeicaoInvalidaException
	 */
	public static void verificaNomeRefvazio(String nomeRef) throws CadastroRefeicaoInvalidaException {
		if (nomeRef.trim().isEmpty()) {
			throw new CadastroRefeicaoInvalidaException(". Nome da refeicao esta vazio.");
		}

	}

}
