package validaPrato;

public class VerificaPrato {
	

	public static void verificaNomePratovazio(String nomePrato) throws Exception {
		if (nomePrato.trim().isEmpty()) {
			throw new Exception("Erro no cadastro do prato. Nome do prato esta vazio.");
		}
	}
	
	public static void verificaDescVazio(String descricao) throws Exception {
		if (descricao.trim().isEmpty()) {
			throw new Exception("Erro no cadastro do prato. Descricao do prato esta vazia.");
		}
	}
	
	public static void verificaPrecoInvalido(double precoPrato) throws Exception {
		if (precoPrato <= 0) {
			throw new Exception("Erro no cadastro do prato. Preco do prato eh invalido.");
		}
	}

}
