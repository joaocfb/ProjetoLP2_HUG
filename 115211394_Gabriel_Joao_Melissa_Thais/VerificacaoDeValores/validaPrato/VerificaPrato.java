package validaPrato;

import exception.CadastroPratoInvalidoException;

public class VerificaPrato {
	

	public static void verificaNomePratovazio(String nomePrato) throws CadastroPratoInvalidoException {
		if (nomePrato.trim().isEmpty()) {
			throw new CadastroPratoInvalidoException("Nome do prato esta vazio.");
		}
	}
	
	public static void verificaDescVazio(String descricao) throws CadastroPratoInvalidoException{
		if (descricao.trim().isEmpty()) {
			throw new CadastroPratoInvalidoException("Descricao do prato esta vazia.");
		}
	}
	
	public static void verificaPrecoInvalido(double precoPrato) throws CadastroPratoInvalidoException {
		if (precoPrato <= 0) {
			throw new CadastroPratoInvalidoException("Preco do prato eh invalido.");
		}
	}

}
